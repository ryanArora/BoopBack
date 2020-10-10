package me.ryanarora.utils;

public class Utils {
    public static String[] reverseStringArray(String[] array) {
        String[] reversed = new String[array.length];
        for (int i = array.length; i > 0; i--) {
            reversed[array.length - i] = array[i - 1];
        }
        return reversed;
    }

    public static int random(int min, int max) {
        int x = (int) (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
}
