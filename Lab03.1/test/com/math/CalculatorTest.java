/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.math;

import static org.junit.Assert.*;

import org.junit.*;

public class CalculatorTest {
    private Calculator calc;

    @BeforeClass // fires once before , can only be static. static = shared
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass // fires once after , can only be static. static = shared
    public static void afterClass(){
        System.out.println("afterClass");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
        calc = new Calculator();
    }

    @After
    public void cleanUp(){
        System.out.println("cleanUp");
    }
    @Test
    public void testIsEven() {
        System.out.println("test is even");
        assertTrue(calc.isEven(10));
        assertFalse(calc.isEven(11));
    }

    @Test
    public void testDivide() {
        System.out.println("test divide");
        assertEquals(2.5, calc.divide(5,2), .001);
    }

    @Test
    public void testAdd() {
        System.out.println("test add");
        assertEquals(5, calc.add(1, 4));  // expected, actual
    }
}