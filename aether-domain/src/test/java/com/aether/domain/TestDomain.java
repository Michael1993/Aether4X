package com.aether.domain;

import static javax0.geci.api.Source.maven;

import javax0.geci.accessor.Accessor;
import javax0.geci.builder.Builder;
import javax0.geci.engine.Geci;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestDomain {

    @Test
    @DisplayName("Test that the necessary code has been generated.")
    public void testGeciGeneratedCode() throws Exception {
        Assertions.assertFalse(new Geci()
                .source(maven().module("./aether-domain").mainSource())
                .register(Accessor.builder().build())
                .register(Builder.builder().build())
                .generate(),
            Geci.FAILED);
    }
}
