package com.Testing;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Parameterized.class)
public class TestSplitArray {
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,2,1},3},{new int[]{2,1,1,2,1},-1},{new int[]{10,10},1}
        });
    }
    int output;
    int[] input;
    public TestSplitArray(int[] input,int output) {
        this.input=input;
        this.output=output;
    }
    @Test
    public void evaluate(){
        assertEquals(output, ArrOperation.splitArray(input));
    }
}
