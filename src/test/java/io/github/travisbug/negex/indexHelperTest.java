package io.github.travisbug.negex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class indexHelperTest {

    private static final int LENGTH = 8;

    // 1. Positive index valid
    @Test
    void positiveIndexWorks() {
        int realIndex = IndexHelper.getRealIndex(LENGTH, "arr", 2);
        assertEquals(2, realIndex);
    }

    // 2. Negative index valid
    @Test
    void negativeIndexWorks() {
        int realIndex = IndexHelper.getRealIndex(LENGTH, "arr", -1);
        assertEquals(7, realIndex);
    }



    // 3. Index zero regression
    @Test
    void zeroIndexIsValid() {
        int realIndex = IndexHelper.getRealIndex(LENGTH, "arr", 0);
        assertEquals(0, realIndex);
    }

    // 4. Negative lower-bound edge (-N)
    @Test
    void negativeLengthIndexIsValid() {
        int realIndex = IndexHelper.getRealIndex(LENGTH, "arr", -8);
        assertEquals(0, realIndex);
    }

    // 5. Slightly too negative
    @Test
    void tooNegativeIndexThrows() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                IndexHelper.getRealIndex(LENGTH, "arr", -9)
        );
    }

    // 6. Way too negative
    @Test
    void negativeWayOutThrows() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                IndexHelper.getRealIndex(LENGTH, "arr", -80000)
        );
    }

    // 7. Positive out-of-bounds (index == N)
    @Test
    void indexEqualToLengthThrows() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                IndexHelper.getRealIndex(LENGTH, "arr", 8)
        );
    }

    // 8. Positive far out-of-bounds
    @Test
    void indexWayTooLargeThrows() {
        assertThrows(IndexOutOfBoundsException.class, () ->
                IndexHelper.getRealIndex(LENGTH, "arr", 100)
        );
    }
}