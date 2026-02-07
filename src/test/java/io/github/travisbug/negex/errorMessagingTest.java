package io.github.travisbug.negex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class errorMessagingTest {


    @Test
    void tooNegativeThrowsHelpfulMessage () {
        System.out.println("Testing error messaging");
  //variable to store test
        IndexOutOfBoundsException ex;
        ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> IndexHelper.getRealIndex(8, "arr", -9)
        );
        String expectedMessage = ex.getMessage ();
        assertTrue(expectedMessage.contains("OUT OF BOUNDS"));
        assertTrue(expectedMessage.contains("did you mean"));
        assertTrue(expectedMessage.contains("-8"));
        }


    @Test
    void arrayIsEmptyThrowsHelpfulMessage () {
        System.out.println("Testing error messaging");
        //variable to store test
        IllegalStateException ex;
        ex = assertThrows(
                IllegalStateException.class,
                () -> IndexHelper.getRealIndex(0, "arr", -9)
        );
        String expectedMessage = ex.getMessage ();
        assertTrue(expectedMessage.contains("ERROR"));
        assertTrue(expectedMessage.contains("The array"));
        assertTrue(expectedMessage.contains("is EMPTY"));
    }

    @Test
    void Positive_OOBThrowsHelpfulMessage () {
        System.out.println("Testing error messaging");
        //variable to store test
        IndexOutOfBoundsException ex;
        ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> IndexHelper.getRealIndex(8, "arr", 8)
        );
        String expectedMessage = ex.getMessage ();
        assertTrue(expectedMessage.contains("ERROR"));
        assertTrue(expectedMessage.contains("OUT OF BOUNDS"));
        assertTrue(expectedMessage.contains("did you mean"));
        assertTrue(expectedMessage.contains("7"));
    }

    @Test
    void tooPositiveThrowsHelpfulMessage () {
        System.out.println("Testing error messaging");
        //variable to store test
        IndexOutOfBoundsException ex;
        ex = assertThrows(
                IndexOutOfBoundsException.class,
                () -> IndexHelper.getRealIndex(8, "arr", 13)
        );
        String expectedMessage = ex.getMessage ();
        assertTrue(expectedMessage.contains("ERROR"));
        assertTrue(expectedMessage.contains("WAY OUT OF BOUNDS"));
        assertTrue(expectedMessage.contains("you are"));
        assertTrue(expectedMessage.contains("6"));
        assertTrue(expectedMessage.contains("numbers passed the last valid index"));
    }


    }

