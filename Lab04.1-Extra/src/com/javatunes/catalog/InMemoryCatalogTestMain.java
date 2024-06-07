/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.Collection;

class InMemoryCatalogTestMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */


    public static void main(String[] args) {
//         testFindById();
//         testFindByKeyword();
//         testFindByCategory();
//         testSize();
         testGetAll();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        MusicItem found = catalog.findById(6L);
        System.out.println(found);
        MusicItem notFound = catalog.findById(101L);
        System.out.println(notFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        //referencing a collection
        Collection<MusicItem> keywordItems = catalog.findByKeyword("SEAL");
        System.out.println(keywordItems);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        //referencing a collection
        Collection<MusicItem> categoryItems =  catalog.findByCategory(MusicCategory.JAZZ);
        System.out.println(categoryItems);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        catalog.size();
        System.out.println(catalog.size());
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        for (MusicItem item : catalog.getAll()) {
            System.out.println(item);
        }
    }
}