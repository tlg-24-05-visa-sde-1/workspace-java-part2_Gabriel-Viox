package com.entertainment;

import org.junit.Before;

import static org.junit.Assert.*;

public class TelevisionChannelComparatorTest {
        private Television tv1;
        private Television tv2;


    // tv1, tv2, a comparator
    @Before
    public void setUp() {
        tv1 = new Television("Sony", 75);
        tv2 = new Television("Sony", 75);
    }
}