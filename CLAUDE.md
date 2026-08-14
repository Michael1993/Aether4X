# CLAUDE.md

Guidance for Claude Code when working in this repository.

## Project overview

Aether4X is an open-source, JavaFX-based clone of Aurora 4X (see `README.adoc`). The
explicit design goal is high modularity: it should be straightforward to replace the
game data, replace the UI, or replace gameplay rules independently. The project is
MIT licensed (see `LICENSE`).

## Module architecture

Maven multi-module build with four modules, layered as:

```
aether-api  <--  aether-domain
    ^        <--  aether-engine
    |
 aether-ui  (depends on api + domain + engine)
```

- **aether-api** — pure contracts: interfaces, records, enums. No implementation
  code and no dependencies on the other modules. E.g. `com.aether.clock.GameClock`,
  `com.aether.model.celestials.bodies`/`objects`, `com.aether.view.Screen`.
- **aether-domain** — concrete data model classes implementing the `api` model
  interfaces (e.g. `Planet`, `Star`, `Galaxy`, `Nebula`, `PlanetarySystem`,
  `StarCluster`). Depends only on `aether-api`.
- **aether-engine** — simulation/game-logic implementations of the `api` behavioral
  interfaces (e.g. `GameClockImpl` implements `GameClock`). Depends only on
  `aether-api`. Holds the test suite.
- **aether-ui** — JavaFX presentation layer, depends on all three other modules.
  Uses a `ServiceLoader`-based SPI (`NodeBasedEventHandler`) for pluggable event
  handling (drag/zoom), echoing the project's swappable-components goal.

When adding a new capability, put the interface in `aether-api` and the
implementation in `aether-domain` or `aether-engine` depending on whether it's data
or behavior — follow the `GameClock`/`GameClockImpl` pair as the canonical example.
Each module has its own `module-info.java`; update `requires`/`exports` there when
adding cross-module dependencies, and add a `package-info.java` for new packages
(encouraged by Checkstyle, not mandatory).

## Build & test commands

- `mvn clean install` — full build across all modules, including Checkstyle
  (fails the build on violations) and the test suite.
- `mvn test` — run tests only.
- `mvn spotless:check` — verify formatting/import order/license headers without
  modifying files.
- `mvn spotless:apply` — auto-fix formatting/import order/license headers. Run
  this before committing.

There is currently no Maven goal wired to launch the JavaFX UI — `aether-ui`'s
`HelloJava.java` is a manual scratch `Application` class, not a real entry point.

## Code conventions Claude must follow

Checkstyle (`checkstyle.xml`) is strict and runs as part of the build, so code that
violates these will fail `mvn clean install`:

- **One `return` per method** (`ReturnCount` max 1).
- **Keep methods small and simple**: cyclomatic complexity ≤5, method length
  ≤16 lines is a warning, ≤48 lines is a hard error.
- **No abbreviations in identifiers.** camelCase for members/locals/parameters,
  PascalCase for types, UPPER_SNAKE_CASE for constants.
- **Javadoc is required** on all public types and public methods. `{@inheritDoc}`
  is fine for overrides of already-documented interface methods.
- **Tabs for indentation** (not spaces).
- **No star imports**; import order is `java, javax, javafx, org, com, com.aether`
  (enforced by Spotless).
- **`@Override` is required** wherever applicable; one outer type per file.

License headers: every `.java` file except `module-info.java` must start with the
MIT header from `mit-license-header`. Don't hand-write it — run
`mvn spotless:apply` and let Spotless insert/fix it.

## Testing conventions

JUnit 5 (Jupiter). Conventions seen in `aether-engine/src/test/java/...`:

- Test classes are package-private (no `public` modifier).
- Every `@Test`/`@ParameterizedTest` has a `@DisplayName` with a full-sentence
  description of what's being checked.
- **Assertions use AssertJ, not JUnit's `Assertions.*`.** Static-import
  `org.assertj.core.api.Assertions.assertThat` and write fluent assertions
  (`assertThat(x).isEqualTo(y)`, `.isTrue()`, `.isFalse()`, etc.). For a custom
  failure message, use `.as("message")` before the assertion
  (`assertThat(x).as("message").isTrue()`), not a trailing string argument.
  For `BigDecimal` values that should be compared ignoring scale (the way
  `BigDecimal.compareTo` does, as opposed to `.equals()`), use
  `.isEqualByComparingTo(...)` rather than `.isEqualTo(...)`.
- When a test needs to drive an implementation's internals directly (e.g. firing a
  single tick without starting a background thread), expose a package-private
  method on the impl for it rather than reaching into private state — see
  `GameClockImpl.tick()`.

**Gotcha:** `aether-engine/src/test/java/com/aether/LicenseTest.java` asserts that
the copyright year in both `LICENSE` and `mit-license-header` matches the current
calendar year. This test can start failing simply because the year changed — if it
fails, check whether the copyright year needs bumping before assuming it's a real
regression.

## Known docs drift

Don't treat the README.adoc as the current project direction — prefer what's
actually in the build/code, and flag to the user if you update it.

## CI

There is no active GitHub Actions workflow in `.github/workflows`.
`mvn spotless:check && mvn clean install` is the closest thing to a CI gate today — run it before considering a change done.
