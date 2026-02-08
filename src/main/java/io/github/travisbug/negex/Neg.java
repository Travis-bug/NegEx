package io.github.travisbug.negex;
import org.fusesource.jansi.AnsiConsole;


import java.util.List;

public final class Neg {

    private Neg() {}

    //installing jansi console
    static {
        System.setProperty("jansi.passthrough", "true");
        AnsiConsole.systemInstall();
    }


    //NEGATIVE INDEXING FOR ARRAYS
    public static <T> T at (T[] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }

    //ADDED OVERLOADS TO HANDLE Array PRIMITIVE TYPES

    public static int at (int [] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }


    public static boolean at (boolean [] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length,arrayName, index);
        return array[realIndex];
    }


    public static byte at (byte [] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }


    public static long at (long [] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }


    public static char at (char [] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }


    public static float at (float[] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }


    public static short at (short[] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }



    public static double at (double [] array, String arrayName, int index) {
        if (array==null) throw new IllegalArgumentException("array cannot be null " + arrayName );
        int realIndex = IndexHelper.getRealIndex(array.length, arrayName, index);
        return array[realIndex];
    }




    //NEGATIVE INDEXING FOR LISTS
    public static <T> T at (List <T> list, int index, String listName) {
            if (list ==null) throw new IllegalArgumentException("array cannot be null " + listName );
            int realIndex =  IndexHelper.getRealIndex(list.size(), listName, index);

        return list.get(realIndex);
    }



}