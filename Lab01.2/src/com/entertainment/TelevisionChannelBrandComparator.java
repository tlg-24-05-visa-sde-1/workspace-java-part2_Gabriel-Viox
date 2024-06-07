package com.entertainment;


import java.util.Comparator;

public class TelevisionChannelBrandComparator implements Comparator<Television> {


    @Override
    public int compare(Television tv1, Television tv2) {
       int result = tv1.getBrand().compareTo(tv2.getBrand());

       if (result == 0) {
           result = tv1.getBrand().compareTo(tv2.getBrand());
       }
       return result;
    }
}
