package com.Recursionpack;

import org.junit.Test;

import static org.junit.Assert.*;

public class NQueensProblemTest {
        int row=0;
        int size_of_board=4;
        boolean output=true;
        NQueensProblem obj=new NQueensProblem(size_of_board);
        @Test
        public void evaluate_NQueens(){
            assertEquals(output, obj.findQueens(size_of_board,row));
        }
    }

