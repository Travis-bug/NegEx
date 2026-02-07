package io.github.travisbug.negex;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;



import static org.junit.jupiter.api.Assertions.*;

 class stressTesting {

     // stress testing indexHelper class (helper method for getRealIndex)
     @Test
     void stressExtremeIndices() {
         int N = 8;
         int max = Integer.MAX_VALUE;
         int min = Integer.MIN_VALUE;

         int[] stressValues = {
                  min,
                 -1_000_000_000,
                 -2_100_000_000,
                 -10_000,
                 -9,
                 -8,
                 -1,
                 0,
                 7,
                 8,
                 10_000,
                 1_000_000_000,
                 2_000_000_000,
                 max,

         };

         for (int index : stressValues) {
             try {
                 IndexHelper.getRealIndex(N, "arr", index);
             } catch (IndexOutOfBoundsException e) {
                 // expected for many cases
             }
         }
     }


     // stress testing the NegEx library itself

     @Test
     void libraryStressTest() {
         int[] testingArray = new int[8];
         int[] testingArray2 = new int[0];
         int max = Integer.MAX_VALUE;
         int min = Integer.MIN_VALUE;

         int[] stressValues = {
                 min,
                 -1_000_000_000,
                 -2_100_000_000,
                 -10_000,
                 -9,
                 -8,
                 -1,
                 0,
                 7,
                 8,
                 10_000,
                 1_000_000_000,
                 2_000_000_000,
                 max,

         };

         for (int index : stressValues) {
             try {
                 Neg.at(testingArray, "testingArray", index);
                 Neg.at(testingArray2, "testingArray2", index);
             } catch (IndexOutOfBoundsException | IllegalStateException e) {

             }
         }

     }

 }
