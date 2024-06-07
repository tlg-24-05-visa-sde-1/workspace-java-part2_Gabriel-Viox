package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;
    private Television tv1;
    private Television tv2;


    @Before
    public void setUp() {
        tv1 = new Television("Sony", 30, DisplayType.CRT);
        tv2 = new Television("Sony", 30, DisplayType.CRT);
    }


    @Test
    public void channelChange_shouldStoreValue_validInput_lowerBound()
    throws InvalidChannelException {
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }

    @Test
    public void channelChange_shouldStoreValue_validInput_upperBound()
            throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowIllegalArgumentException_invalidInput_lowerBound()
    throws InvalidChannelException {
        tv.changeChannel(0);
    }

    @Test
    public void changeChannel_shouldThrowIllegalArgumentException_invalidInput_upperBound()
    throws InvalidChannelException {
        tv.changeChannel(1000);
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_lowerBound() {
        tv.setVolume(-1);
    }

    @Test
    public void setVolume_shouldThrowIllegalArgumentException_invalidInput_upperBound() {
        tv.setVolume(101);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_lowerBound() {
        tv.setVolume(0);
    }

    @Test
    public void setVolume_shouldStoreValue_validInput_upperBound() {
        tv.setVolume(100);
    }
}