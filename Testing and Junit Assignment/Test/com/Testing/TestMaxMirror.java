package com.Testing;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import com.Testing.ArrOperation;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Parameterized.class)
public class TestMaxMirror {
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,1,4},3},{new int[]{7,1,4,9,7,4,1},2},{new int[]{1,2,3,8,9,3,2,1},3},{new int[]{1,4,5,3,5,4,1},7}
        });
    }
    private int output;
    int[] input;

    public TestMaxMirror(int[] input,int output) {
        this.input=input;
        this.output=output;
    }
    @Test
    public void evaluate(){
        assertEquals(output, ArrOperation.maxMirrorSize(input));
    }
}