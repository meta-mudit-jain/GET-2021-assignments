package com.sparse;


import java.util.Arrays;
import java.util.Comparator;

public class SparseMatrix {

    private final int nonZeroValues[][];
    private final int numberOfRows; // Row Index, Column Index and Non-zero
    // value
    private final int numberOfColumns = 3;
    private final int rowIndex = 0;
    private final int columnIndex = 1;
    private final int valueIndex = 2;

    /**
     * Initializing and storing only non zero values in the sparse matrix
     *
     * @param matrix
     *            It is the input sparse matrix containing more zero values than
     *            non zero values
     */
    public SparseMatrix(int matrix[][]) {
        int nonZeroElements = nonZeroCount(matrix) + 1;
        numberOfRows = nonZeroElements;
        nonZeroValues = new int[numberOfRows][numberOfColumns];

        int currentRow = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] != 0) {
                    nonZeroValues[currentRow][rowIndex] = row;
                    nonZeroValues[currentRow][columnIndex] = column;
                    nonZeroValues[currentRow][valueIndex] = matrix[row][column];
                    currentRow++;
                }
            }
        }

        // Reserving the first row with size(dimensions) of matrix and non zero
        // values count in that matrix
        nonZeroValues[0][rowIndex] = matrix.length;
        nonZeroValues[0][columnIndex] = matrix[0].length;
        nonZeroValues[0][valueIndex] = nonZeroElements - 1;
    }

    /**
     * Converting the matrix into object of sparse matrix
     *
     * @param matrix
     *            It is the matrix that contains only non zero values
     * @param rows
     *            It the total number of non zero values in the matrix
     */
    public SparseMatrix(int matrix[][], int rows) {
        numberOfRows = rows;
        nonZeroValues = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < numberOfRows; row++) {
            nonZeroValues[row][rowIndex] = matrix[row][rowIndex];
            nonZeroValues[row][columnIndex] = matrix[row][columnIndex];
            nonZeroValues[row][valueIndex] = matrix[row][valueIndex];
        }
    }

    /**
     * This method will calculate and return the transpose of the sparse matrix
     *
     * @return transpose of the sparse matrix
     */
    public SparseMatrix transpose() {

        int transposeMatrix[][] = new int[this.numberOfRows][this.numberOfColumns];

        // Initializing first row with minValue as we will do the sorting later
        // on
        int minValue = -9999;
        transposeMatrix[0][rowIndex] = minValue;
        transposeMatrix[0][columnIndex] = minValue;
        transposeMatrix[0][valueIndex] = minValue;

        for (int row = 1; row < this.numberOfRows; row++) {
            transposeMatrix[row][rowIndex] = this.nonZeroValues[row][columnIndex];
            transposeMatrix[row][columnIndex] = this.nonZeroValues[row][rowIndex];
            transposeMatrix[row][valueIndex] = this.nonZeroValues[row][valueIndex];

        }
        // sorting the transpose matrix
        sort(transposeMatrix);

        // Initializing the first row again with size of the matrix and
        transposeMatrix[0][rowIndex] = this.nonZeroValues[0][columnIndex];
        transposeMatrix[0][columnIndex] = this.nonZeroValues[0][rowIndex];
        transposeMatrix[0][valueIndex] = this.nonZeroValues[0][valueIndex];
        return new SparseMatrix(transposeMatrix, this.numberOfRows);
    }

    /**
     * This method will check the current Sparse Matrix is symmetric or not
     *
     * @return true if the sparse matrix is symmetric else return false
     */
    public boolean isSymmetricMatrix() {
        SparseMatrix originalMatrix = this;
        SparseMatrix transposeMatrix = originalMatrix.transpose();

        for (int row = 1; row < originalMatrix.numberOfColumns; row++) {
            if (originalMatrix.nonZeroValues[row][rowIndex] != transposeMatrix.nonZeroValues[row][rowIndex])
                return false;
            if (originalMatrix.nonZeroValues[row][columnIndex] != transposeMatrix.nonZeroValues[row][columnIndex])
                return false;
            if (originalMatrix.nonZeroValues[row][valueIndex] != transposeMatrix.nonZeroValues[row][valueIndex])
                return false;
        }
        return true;
    }

    /**
     * This method will calculate and return the addition of two sparse matrix
     *
     * @param second
     *            It is the second matrix
     * @return the addition sparse matrix
     */
    public SparseMatrix addSparseMatrix(SparseMatrix second) {
        SparseMatrix first = this;

        // checking whether matrix are of different size
        if ((first.nonZeroValues[0][rowIndex] != second.nonZeroValues[0][rowIndex])
                || (first.nonZeroValues[0][columnIndex] != second.nonZeroValues[0][columnIndex]))
            throw new AssertionError(
                    "Different size matrix can't be multiplied");

        // getting number of rows of resultant addition matrix
        int sizeOfResultMatrix = findSizeOfResultMatrix(first, second);

        int resultMatrix[][] = new int[sizeOfResultMatrix][first.numberOfColumns];

        int rowInFirst = 1, rowInSecond = 1;
        int counter = 1;
        while (rowInFirst < first.numberOfRows
                && rowInSecond < second.numberOfRows) {

            // If row index of first matrix is less than row index of second
            // matrix
            if (first.nonZeroValues[rowInFirst][rowIndex] < second.nonZeroValues[rowInSecond][rowIndex]) {
                resultMatrix[counter][rowIndex] = first.nonZeroValues[rowInFirst][rowIndex];
                resultMatrix[counter][columnIndex] = first.nonZeroValues[rowInFirst][columnIndex];
                resultMatrix[counter][valueIndex] = first.nonZeroValues[rowInFirst][valueIndex];
                rowInFirst++;
                counter++;
            }
            // If row index of first matrix is greater than row index of second
            // matrix
            else if (first.nonZeroValues[rowInFirst][rowIndex] > second.nonZeroValues[rowInSecond][rowIndex]) {
                resultMatrix[counter][rowIndex] = second.nonZeroValues[rowInSecond][rowIndex];
                resultMatrix[counter][columnIndex] = second.nonZeroValues[rowInSecond][columnIndex];
                resultMatrix[counter][valueIndex] = second.nonZeroValues[rowInSecond][valueIndex];
                rowInSecond++;
                counter++;
            }
            // If column index of first matrix is less than column index of
            // second matrix
            else if (first.nonZeroValues[rowInFirst][columnIndex] < second.nonZeroValues[rowInSecond][columnIndex]) {
                resultMatrix[counter][rowIndex] = first.nonZeroValues[rowInFirst][rowIndex];
                resultMatrix[counter][columnIndex] = first.nonZeroValues[rowInFirst][columnIndex];
                resultMatrix[counter][valueIndex] = first.nonZeroValues[rowInFirst][valueIndex];
                rowInFirst++;
                counter++;
            }
            // If column index of first matrix is greater than column index of
            // second matrix
            else if (first.nonZeroValues[rowInFirst][columnIndex] > second.nonZeroValues[rowInSecond][columnIndex]) {
                resultMatrix[counter][rowIndex] = second.nonZeroValues[rowInSecond][rowIndex];
                resultMatrix[counter][columnIndex] = second.nonZeroValues[rowInSecond][columnIndex];
                resultMatrix[counter][valueIndex] = second.nonZeroValues[rowInSecond][valueIndex];
                rowInSecond++;
                counter++;
            }
            // If row and column index of first and second matrix are equal
            else {
                resultMatrix[counter][rowIndex] = first.nonZeroValues[rowInFirst][rowIndex];
                resultMatrix[counter][columnIndex] = first.nonZeroValues[rowInFirst][columnIndex];
                resultMatrix[counter][valueIndex] = first.nonZeroValues[rowInFirst][valueIndex]
                        + second.nonZeroValues[rowInSecond][valueIndex];
                rowInFirst++;
                rowInSecond++;
                counter++;
            }
        }

        // If rows are still left in first matrix
        while (rowInFirst < first.numberOfRows) {
            resultMatrix[counter][rowIndex] = first.nonZeroValues[rowInFirst][rowIndex];
            resultMatrix[counter][columnIndex] = first.nonZeroValues[rowInFirst][columnIndex];
            resultMatrix[counter][valueIndex] = first.nonZeroValues[rowInFirst][valueIndex];
            rowInFirst++;
            counter++;
        }

        // If rows are still left in second matrix
        while (rowInSecond < second.numberOfRows) {
            resultMatrix[counter][rowIndex] = second.nonZeroValues[rowInSecond][rowIndex];
            resultMatrix[counter][columnIndex] = second.nonZeroValues[rowInSecond][columnIndex];
            resultMatrix[counter][valueIndex] = second.nonZeroValues[rowInSecond][valueIndex];
            rowInSecond++;
            counter++;
        }

        // Reserving the first row with size(dimensions) of matrix and non zero
        // values count in that matrix
        resultMatrix[0][rowIndex] = first.nonZeroValues[0][rowIndex];
        resultMatrix[0][columnIndex] = first.nonZeroValues[0][columnIndex];
        resultMatrix[0][valueIndex] = sizeOfResultMatrix - 1;

        return new SparseMatrix(resultMatrix, sizeOfResultMatrix);
    }

    /**
     * This method will calculate and find the total number of rows for the
     * resultant addition matrix
     *
     * @param first
     *            It is the first sparse matrix
     * @param second
     *            It is the second sparse matrix
     * @return the total number of row for the resultant addition matrix
     */
    public int findSizeOfResultMatrix(SparseMatrix first, SparseMatrix second) {
        int size = 1;
        int rowInFirst = 1, rowInSecond = 1;
        while (rowInFirst < first.numberOfRows
                && rowInSecond < second.numberOfRows) {
            if (first.nonZeroValues[rowInFirst][rowIndex] < second.nonZeroValues[rowInSecond][rowIndex]) {
                rowInFirst++;
                size++;
            } else if (first.nonZeroValues[rowInFirst][rowIndex] > second.nonZeroValues[rowInSecond][rowIndex]) {
                rowInSecond++;
                size++;
            } else if (first.nonZeroValues[rowInFirst][columnIndex] < second.nonZeroValues[rowInSecond][columnIndex]) {
                rowInFirst++;
                size++;
            } else if (first.nonZeroValues[rowInFirst][columnIndex] > second.nonZeroValues[rowInSecond][columnIndex]) {
                rowInSecond++;
                size++;
            } else {
                rowInFirst++;
                rowInSecond++;
                size++;
            }
        }
        while (rowInFirst < first.numberOfRows) {
            rowInFirst++;
            size++;
        }
        while (rowInSecond < second.numberOfRows) {
            rowInSecond++;
            size++;
        }
        return size;
    }

    /**
     * This method will multiply two sparse matrices and return the
     * multiplication
     *
     * @param second
     *            It is the second sparse matrix
     * @return the multiplication of the two sparse matrices
     */
    public SparseMatrix multiplySparseMatrix(SparseMatrix second) {
        SparseMatrix first = this;

        // checking whether matrix are of different size
        if ((first.nonZeroValues[0][rowIndex] != second.nonZeroValues[0][rowIndex])
                || (first.nonZeroValues[0][columnIndex] != second.nonZeroValues[0][columnIndex]))
            throw new AssertionError(
                    "Different size matrix can't be multiplied");

        // transpose of second matrix
        SparseMatrix transposedSecondMatrix = second.transpose();
        int rowsOfMuliplicationMatrix = findRowsOfMultiplicationMatrix(first,
                transposedSecondMatrix);

        // creating the multiplication matrix
        int multiplication[][] = new int[rowsOfMuliplicationMatrix][first.numberOfColumns];

        // Reserving the first row by initializing with minimum value
        int minValue = -9999;
        multiplication[0][rowIndex] = minValue;
        multiplication[0][columnIndex] = minValue;
        multiplication[0][valueIndex] = minValue;

        int count = 1;
        for (int rowInFirst = 1; rowInFirst < first.numberOfRows; rowInFirst++) {
            for (int rowInSecond = 1; rowInSecond < transposedSecondMatrix.numberOfRows; rowInSecond++) {
                if (first.nonZeroValues[rowInFirst][columnIndex] == transposedSecondMatrix.nonZeroValues[rowInSecond][columnIndex]) {
                    multiplication[count][rowIndex] = first.nonZeroValues[rowInFirst][rowIndex];
                    multiplication[count][columnIndex] = transposedSecondMatrix.nonZeroValues[rowInSecond][rowIndex];
                    multiplication[count][valueIndex] = first.nonZeroValues[rowInFirst][valueIndex]
                            * transposedSecondMatrix.nonZeroValues[rowInSecond][valueIndex];
                    count++;
                }
            }
        }

        // sorting the multiplication matrix
        sort(multiplication);

        // Reserving the first row with size(dimensions) of matrix and non zero
        // values count in that matrix
        multiplication[0][rowIndex] = this.nonZeroValues[0][columnIndex];
        multiplication[0][columnIndex] = this.nonZeroValues[0][rowIndex];
        multiplication[0][valueIndex] = this.nonZeroValues[0][valueIndex];
        return new SparseMatrix(multiplication, rowsOfMuliplicationMatrix);

    }

    /**
     * This method is used to calculate the total number of rows will be there
     * in the multiplication matrix
     *
     * @param first
     *            It is the first sparse matrix
     * @param second
     *            It is the second sparse matrix
     * @return total number of rows in the multiplication matrix
     */
    public int findRowsOfMultiplicationMatrix(SparseMatrix first,
                                              SparseMatrix second) {
        int count = 1;
        for (int rowInFirst = 1; rowInFirst < first.numberOfRows; rowInFirst++) {
            for (int rowInSecond = 1; rowInSecond < second.numberOfRows; rowInSecond++) {
                if (first.nonZeroValues[rowInFirst][columnIndex] == second.nonZeroValues[rowInSecond][columnIndex])
                    count++;
            }
        }
        return count;
    }

    /**
     * This method will count the total number of non values in the input matrix
     *
     * @param matrix
     *            It is the input matrix
     * @return non zero values count in the input matrix
     */
    public int nonZeroCount(int matrix[][]) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++)
                if (matrix[row][column] != 0)
                    count++;
        }
        return count;
    }

    /**
     * This method will return the copy of nonZeroValues array of the sparse
     * matrix
     *
     * @return copy of non zero values array
     */
    public int[][] getNonZeroValues() {
        int copyArray[][] = new int[nonZeroValues.length][nonZeroValues[0].length];
        for (int row = 0; row < nonZeroValues.length; row++)
            for (int column = 0; column < nonZeroValues[0].length; column++)
                copyArray[row][column] = nonZeroValues[row][column];

        return copyArray;
    }

    /**
     * This method is used to sort the input array on row and column
     *
     * @param array
     *            It is the input array that needs to be sorted
     */
    public void sort(int array[][]) {
        Comparator<int[]> comparator = new Comparator<int[]>() {

            @Override
            public int compare(int[] first, int[] second) {
                // For row
                if (first[0] > second[0])
                    return 1;
                else if (first[0] < second[0])
                    return -1;
                    // For column
                else if (first[1] > second[1])
                    return 1;
                else
                    return -1;
            }
        };
        Arrays.sort(array, comparator);
    }

}