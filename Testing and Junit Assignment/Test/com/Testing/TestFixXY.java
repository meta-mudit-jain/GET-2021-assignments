package com.Testing;
import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(Parameterized.class)
public class TestFixXY{
    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {new int[]{5,4,9,4,9,5},new int[]{9,4,5,4,5,9}},{new int[]{1,4,1,5},new int[]{1,4,5,1}},{new int[]{1,4,1,5,5,4,1},new int[]{1,4,5,1,1,4,5}}
        });
    }

    int[] output;
    int[] input;
    int x=4;
    int y=5;
    public TestFixXY(int[] input,int[] output) {
        this.input=input;
        this.output=output;
    }
    @Test
    public void evaluate(){
        assertArrayEquals(output, ArrOperation.fixXY(input,x,y));
    }
}