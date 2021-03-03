package com.Recursionpack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LcmHcfTest {
    int num1=20;
    int num2=30;
    int lcm=60;
    int hcf=10;
    @Test
    public void evaluate_LCM(){
        assertEquals(lcm, LcmHcf.find_lcm(num1, num2));
    }
    @Test
    public void evaluate_HCF(){
        assertEquals(hcf, LcmHcf.find_hcf(num1, num2));
    }
}