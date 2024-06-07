package com.entertainment;

import java.util.Objects;


/*
 * Note: to be "consistent with equals", you must use the same sort key(s)
 * as you're using in your equals() method for us, that's (brand, volume).
 * Natural order is thus defined by brand (string) and then by volume (int)
 * when tied by brand
 */
public class Television implements Comparable<Television> {
    private String brand;
    private int volume;


    //TV has-a tuner
    private final Tuner tuner = new Tuner(); // instantiated internally

    //constructor
    public Television(){
        super();
    }

    public Television(String brand, int volume){
        super();
        setBrand(brand);
        setVolume(volume);
    }


    // business methods
    public int getCurrentChannel(){
        return tuner.getChannel(); // delegate to contained Tuner Object
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel); // delegate to contained Tuner Object
    }

    // accessor methods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
        // whatever you use for equality, use it for the hashcode
    @Override
    public boolean equals(Object obj){
        boolean result = false;
        // check that obj is really referring to a Television object
       // if (obj instanceof Television){ // instanceof = IS-A check
        if(this.getClass()== obj.getClass()){ // are we the exact same class
            // downcast 'obj' to more specific reference type television, for getBrand(), getVolume()
            Television other = (Television) obj;
            // do the checks: business equality is defined as brand, volume
            result = this.getBrand().equals(other.getBrand()) &&
                    this.getVolume() == other.getVolume();
        }
        return result;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Television other = (Television) obj;
//        return getVolume() == other.getVolume() &&
//                Objects.equals(getBrand(), other.getBrand());
//    }

    @Override
    public int hashCode() {
        //scientifically correct hash function
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());
        if(result == 0){
            result = this.getVolume() - other.getVolume();
        }
        return result;
    }

    @Override
    public String toString(){
        return String.format("%s:  brand=%s, volume=%s, currentChannel=%s",
                getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());
    }
}

//  NOTES:
//    @Override public int hashCode(){
//        // this is a poor hash function, because it easily yields "hash collisions"
//        // a "hash collision" is when different objects happens to have the same hashcode
//        // return getBrand().length() + getVolume();
//
//        // this is a scientifically correct hash function
//        //Minimizes the probability of a hash collision
//        return Objects.hash(getBrand(),getVolume());
//    }

