package com.htec.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {

	@Test
	public void testAssetionExample() {

		// GIVEN
		String message = "Hello World";

		// WHEN nothing

		// THEN
		assertThat(message).isNotBlank();
	}

	@Test
//	@Ignore
	public void ignoreTestExample() {

		// GIVEN
		String message = "Hello World";

		// WHEN

		// THEN
		assertThat(message).isNotBlank();
	}

	@Test
	public void failTestExample() {

		// GIVEN
		String expectedMessage = "Hello World";

		// WHEN
		String actualMessage = "blabla";

		// THEN
		assertThat(actualMessage).isEqualTo(expectedMessage);
	}
}
