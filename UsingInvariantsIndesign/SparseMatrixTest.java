package com.sparse;

import org.junit.Test;

import static org.junit.Assert.*;

public class SparseMatrixTest {
    @Test
    public void transposeTestOne() {
        int array[][] = { { 1, 0, 0 }, { 0, 2, 4 }, { 0, 0, 3 } };
        SparseMatrix sparseMatrix = new SparseMatrix(array);

        SparseMatrix transposedMatrix = sparseMatrix.transpose();

        int expected[][] = { { 3, 3, 4 }, { 0, 0, 1 }, { 1, 1, 2 },
                { 2, 1, 4 }, { 2, 2, 3 } };

        assertArrayEquals(expected, transposedMatrix.getNonZeroValues());

    }

    @Test
    public void transposeTestTwo() {
        int array[][] = { { 1, 0, 2, 0 }, { 0, 2, 8, 0 }, { 0, 0, 0, 9 },
                { 0, 0, 0, 0 } };
        SparseMatrix sparseMatrix = new SparseMatrix(array);

        SparseMatrix transposedMatrix = sparseMatrix.transpose();

        int expected[][] = { { 4, 4, 5 }, { 0, 0, 1 }, { 1, 1, 2 },
                { 2, 0, 2 }, { 2, 1, 8 }, { 3, 2, 9 } };
        assertArrayEquals(expected, transposedMatrix.getNonZeroValues());

    }

    @Test
    public void symmetricTestOne() {
        int array[][] = { { 1, 0, 0 }, { 0, 2, 0 }, { 0, 0, 3 } };
        SparseMatrix sparseMatrix = new SparseMatrix(array);

        assertTrue(sparseMatrix.isSymmetricMatrix());
    }

    @Test
    public void symmetricTestTwo() {
        int array[][] = { { 1, 0, 2, 0 }, { 0, 2, 8, 0 }, { 0, 0, 0, 9 },
                { 0, 0, 0, 0 } };
        SparseMatrix sparseMatrix = new SparseMatrix(array);

        assertFalse(sparseMatrix.isSymmetricMatrix());
    }

    @Test
    public void symmetricTestThree() {
        int array[][] = { { 1, 2, 0 }, { 2, 1, 0 }, { 0, 0, 3 } };
        SparseMatrix sparseMatrix = new SparseMatrix(array);

        assertTrue(sparseMatrix.isSymmetricMatrix());
    }

    @Test
    public void additionTestOne() {
        int firstArray[][] = { { 1, 1, 0 }, { 0, 2, 0 }, { 4, 0, 0 } };
        int secondArray[][] = { { 0, 4, 7 }, { 2, 0, 5 }, { 6, 0, 0 } };
        SparseMatrix first = new SparseMatrix(firstArray);
        SparseMatrix second = new SparseMatrix(secondArray);

        SparseMatrix addition = first.addSparseMatrix(second);

        int expected[][] = { { 3, 3, 7 }, { 0, 0, 1 }, { 0, 1, 5 },
                { 0, 2, 7 }, { 1, 0, 2 }, { 1, 1, 2 }, { 1, 2, 5 },
                { 2, 0, 10 }, };

        assertArrayEquals(expected, addition.getNonZeroValues());

    }

    @Test
    public void additionTestTwo() {
        int firstArray[][] = { { 0, 1 }, { 0, 0 } };
        int secondArray[][] = { { 0, 0 }, { 0, -1 } };
        SparseMatrix first = new SparseMatrix(firstArray);
        SparseMatrix second = new SparseMatrix(secondArray);

        SparseMatrix addition = first.addSparseMatrix(second);

        int expected[][] = { { 2, 2, 2 }, { 0, 1, 1 }, { 1, 1, -1 }, };

        assertArrayEquals(expected, addition.getNonZeroValues());

    }

    @Test
    public void multiplicationTestOne() {
        int firstArray[][] = { { 1, 0 }, { 0, 2 } };
        int secondArray[][] = { { 0, 1 }, { 2, 0 } };
        SparseMatrix first = new SparseMatrix(firstArray);
        SparseMatrix second = new SparseMatrix(secondArray);

        SparseMatrix multiplication = first.multiplySparseMatrix(second);

        int expected[][] = { { 2, 2, 2 }, { 0, 1, 1 }, { 1, 0, 4 }, };

        assertArrayEquals(expected, multiplication.getNonZeroValues());

    }

    @Test
    public void multiplicationTestTwo() {
        int firstArray[][] = { { 1, 2, 0 }, { 0, 2, 0 }, { 0, 4, 0 } };
        int secondArray[][] = { { 3, 0, 0 }, { 0, 2, 3 }, { 4, 6, 0 } };
        SparseMatrix first = new SparseMatrix(firstArray);
        SparseMatrix second = new SparseMatrix(secondArray);

        SparseMatrix multiplication = first.multiplySparseMatrix(second);

        int expected[][] = {

                { 3, 3, 4 }, { 0, 0, 3 }, { 0, 1, 4 }, { 0, 2, 6 }, { 1, 1, 4 },
                { 1, 2, 6 }, { 2, 1, 8 }, { 2, 2, 12 } };

        assertArrayEquals(expected, multiplication.getNonZeroValues());

    }
}