package com.company.linkedin;

import java.util.Random;

public class InPlaceShuffle {

    public static void main(String[] args) {

        int[] array = {6,11,3,6,76,100,32,2,0};

        shuffle(array);
    }

    private static Random random = new Random();

    private static int getRandom(int floor, int ceiling) {
        return random.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] array) {

        // if it's 1 - 0 items, just return
        if (array.length <= 1) {
            return;
        }

        // walk through the array
        for (int indexWeAreChoosingFor = 0;
             indexWeAreChoosingFor < array.length - 1; indexWeAreChoosingFor++) {
            // choose a random not-yet-placed item to place there
            // (could also be the item currently in that spot)
            // must be an item AFTER the current item, because the stuff
            // before has all already been placed
            int randomChoiceIndex = getRandom(indexWeAreChoosingFor, array.length - 1);

            // places our random choice in the spot swapping
            if (randomChoiceIndex != indexWeAreChoosingFor){
                int valueAtIndexWeChoseFor = array[indexWeAreChoosingFor];
                array[indexWeAreChoosingFor] = array[randomChoiceIndex];
                array[randomChoiceIndex] = valueAtIndexWeChoseFor;
            }

        }
    }
}
