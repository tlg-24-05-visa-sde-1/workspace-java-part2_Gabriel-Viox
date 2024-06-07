package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {
    private InMemoryCatalog catalog;


    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void findCheapRock_returnsCheapClassicRock_isNotValid() {

    }

    @Test
    public void findCheapRock_returnsCheapClassicRock_isValid() {
        Collection<MusicItem> classicRockItems = catalog.findByCategory(MusicCategory.CLASSIC_ROCK);
        assertEquals(1, classicRockItems.size());
        for(MusicItem item : classicRockItems) {
            assertEquals(MusicCategory.CLASSIC_ROCK, item.getMusicCategory());
        }
    }

    @Test
    public void findCategory_shouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4, popItems.size());
        for(MusicItem item : popItems) {
            assertEquals(MusicCategory.POP, item.getMusicCategory());
        }
    }

    @Test
    public void findByID_shouldReturnNull_idNotFound() {
        //make the business call, a null MusicItem should come back
        MusicItem item = catalog.findById(101L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItem_idFound() {
        // make the business call, a non-null MusicItem should come back
        MusicItem item = catalog.findById(6L);
        assertNotNull(item);
        assertEquals(6L, (long) item.getId());
    }
}