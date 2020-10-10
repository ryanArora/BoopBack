package me.ryanarora.utils;

public class Utils {
    public static String[] reverseStringArray(String [] array){
        String [] reversed = new String [array.length];
        for(int i = array.length; i > 0; i--){
            reversed[array.length - i] = array[i - 1];
        }
        return reversed;
    }
}
