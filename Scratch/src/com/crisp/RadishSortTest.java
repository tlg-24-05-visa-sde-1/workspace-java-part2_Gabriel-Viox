package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();

        //color, size, tailLength, sprouts
        radishes.add(new Radish("white", 1.5, 2.5, 5));
        radishes.add(new Radish("black", 1.0, 0.0, 0));
        radishes.add(new Radish("red", 2.7, 5.5, 0));
        radishes.add(new Radish("pink", 0.9, 0.0, 6));

        // original list
        System.out.println("Original List");
        dump(radishes);


        System.out.println("Sort by natural order (size)");
        radishes.sort(null);
        dump(radishes);

        System.out.println("Sort by color via Comparator class");
        radishes.sort(new Comparator<Radish>() {
            @Override
            public int compare(Radish r1, Radish r2) {
                return CharSequence.compare(r1.getColor(),r2.getColor());
            }
        });
        dump(radishes);

        System.out.println("sort by Sprouts via RadishSproutComparator");
        radishes.sort((r1, r2) -> Double.compare(r1.getTailLength(), r2.getTailLength()));
        dump(radishes);
    }

    private static void dump(List<Radish> radishList) {
        for(Radish radish: radishList){
            System.out.println(radish);
        }
        System.out.println();
    }
}
