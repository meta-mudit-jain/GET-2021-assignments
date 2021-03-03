package com.Recursionpack;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchFunctionsTest {
    int[] arr={10,12,14,16};
    int num=12;
    int low=0;
    int high=3;
    int outputIndex=1;
    @Test
    public void evaluate_linear_search(){
        assertEquals(outputIndex,SearchFunctions.linearSearch(arr, num, low, high));
    }
    @Test
    public void evaluate_binary_search(){
        assertEquals(outputIndex, SearchFunctions.binarySearch(arr, num, low, high));
    }
}