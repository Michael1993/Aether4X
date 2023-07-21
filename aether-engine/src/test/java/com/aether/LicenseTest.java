/*
    MIT License
    Copyright (c) 2023 Mihály Verhás
    See LICENSE file.
*/
package com.aether;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LicenseTest {

	@ParameterizedTest
	@ValueSource(strings = { "../LICENSE", "../mit-license-header" })
	@DisplayName("Check the year on the license and header")
	void checkLicense(String path) throws IOException {
		var reader = new BufferedReader(new FileReader(path));
		assertTrue(reader
				.lines()
				.filter(line -> line.contains("Copyright"))
				.allMatch(line -> line.contains(format("%s", Calendar.getInstance().get(Calendar.YEAR)))),
			"License outdated, please update.");
	}

}
