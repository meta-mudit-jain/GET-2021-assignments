package com.Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrOperationTest {
    ArrOperation obj =new ArrOperation();
    @Test
    void maxMirrorSizeTest() {
        int[] input={1, 2, 3, 8, 9, 3, 2, 1};
        int output=3;
        assertEquals(output,obj.maxMirrorSize(input));

    }

    @Test
    void countClumpsTest() {
        int[] input={1, 2, 2, 3, 4, 4};
        int output=2;
        assertEquals(output,obj.countClumps(input));
    }

    @Test
    void fixXY() {

    }
    @Test
    void splitArrayTest(){
    int[] input ={1, 1, 1, 2, 1};
    int output=3;
    assertEquals(output,obj.splitArray(input));
    }
}