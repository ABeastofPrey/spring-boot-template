package com.kuka.springtemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringtemplateApplicationTests {

	@BeforeAll
	public static void setAll() {
		System.out.println("Set all");
	}
	
	@BeforeEach
	public void setUp() {
		System.out.println("Set up");
	}

	@AfterEach
	public void tearDown() {
		System.out.println("Tear down");
	}

	@AfterAll
	public static void tearAll() {
		System.out.println("Tear all");
	}

	@Test
	void contextLoads() {
		assertTrue(true);
	}

	@Disabled
	@Test
	void contextLoads1() {
		assertTrue(false);
	}

	@Test
	void testNegative() {
		assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException();
		});
	}
}
