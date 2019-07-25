package com.htec.sandbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
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
	@Ignore
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
