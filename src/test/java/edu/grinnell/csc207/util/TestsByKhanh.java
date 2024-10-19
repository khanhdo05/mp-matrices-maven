package edu.grinnell.csc207.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import static edu.grinnell.csc207.util.MatrixAssertions.assertFigure;

/**
 * Student tests for {@link MatrixV0}
 *
 * @author Khanh Do - CSC-207-02
 */
public class TestsByKhanh {
  @Test
  void TestSuccessfullyCreate2DMatrix() throws Exception {
    try {
      Matrix<String> m1 = new MatrixV0<>(2, 4, "o");
      assertFigure("""
          +---+---+
          | o | o |
          +---+---+
          | o | o |
          +---+---+
          | o | o |
          +---+---+
          | o | o |
          +---+---+
          """, m1, "Create a matrix of width 2 and height 4 with default value of 'o'");
    } catch (NegativeArraySizeException e) {
      fail("Fail to create a MatrixV0 object. " + e.getMessage());
    } // try/catch
  } // TestSuccessfullyCreate2DMatrix

  /**
   * This test aims to test the method fill region.
   */
  @Test
  void testFillRegion() {
    Matrix<Integer> m = new MatrixV0<>(4, 4);
    // Fill a 2x2 region starting from (1,1) with the value 7
    m.fillRegion(1, 1, 2, 2, 7);
    assertFigure("""
        +---+---+---+---+
        | / | / | / | / |
        +---+---+---+---+
        | / | 7 | / | / |
        +---+---+---+---+
        | / | / | / | / |
        +---+---+---+---+
        | / | / | / | / |
        +---+---+---+---+
        """, m, "Fill region correctly");
  } // testFillRegion()

  /**
   * This test aims to test the fill line method.
   */
  @Test
  void TestFillLine() {
    Matrix<Integer> m = new MatrixV0<>(4, 4);
    m.fillLine(1, 0, 0, 1, 4, 4, 9);
    assertFigure("""
        +---+---+---+---+
        | / | / | / | / |
        +---+---+---+---+
        | 9 | 9 | 9 | 9 |
        +---+---+---+---+
        | / | / | / | / |
        +---+---+---+---+
        | / | / | / | / |
        +---+---+---+---+
        """, m, "Fill line correctly");
  } // TestFillLine()

  /**
   * This test aims to test the clone method.
   */
  @SuppressWarnings("unchecked")
  @Test
  void TestCloneMatrix() {
    // Initialize a 3x3 matrix of Integers and set some values
    Matrix<Integer> matrix = new MatrixV0<>(3, 3);
    matrix.set(0, 0, 1);
    matrix.set(1, 1, 2);
    matrix.set(2, 2, 3);

    // Clone the matrix
    Matrix<Integer> clonedMatrix = matrix.clone();

    // Check that all values in the cloned matrix match the original
    for (int i = 0; i < matrix.height(); i++) {
      for (int j = 0; j < matrix.width(); j++) {
        assertEquals(matrix.get(i, j), clonedMatrix.get(i, j));
      } // for
    } // for

    // Check that the cloned matrix is not the same reference as the original
    assertNotSame(matrix, clonedMatrix);

    // Modify the original matrix and check that the cloned matrix is unaffected
    matrix.set(0, 0, 10);
    assertEquals(Integer.valueOf(10), matrix.get(0, 0));
    assertEquals(Integer.valueOf(1), clonedMatrix.get(0, 0));

    // Modify the cloned matrix and check that the original matrix is unaffected
    clonedMatrix.set(2, 2, 30);
    assertEquals(Integer.valueOf(30), clonedMatrix.get(2, 2));
    assertEquals(Integer.valueOf(3), matrix.get(2, 2));
  } // TestCloneMatrix()

  /**
   * This test aims to test method equal.
   */
  @Test
  public void testEqualsMatrix() {
    // Initialize two 3x3 matrices with the same values
    Matrix<Integer> matrix1 = new MatrixV0<>(3, 3, 1);
    Matrix<Integer> matrix2 = new MatrixV0<>(3, 3, 1);

    // Set identical values in both matrices
    matrix1.set(0, 0, 1);
    matrix1.set(1, 1, 2);
    matrix1.set(2, 2, 3);

    matrix2.set(0, 0, 1);
    matrix2.set(1, 1, 2);
    matrix2.set(2, 2, 3);

    // Check that matrix1 equals matrix2
    assertTrue(matrix1.equals(matrix2));
    assertTrue(matrix2.equals(matrix1));

    // Modify matrix2 slightly
    matrix2.set(0, 0, 10);

    // Now the matrices should not be equal
    assertFalse(matrix1.equals(matrix2));
    assertFalse(matrix2.equals(matrix1)); // Check symmetry

    // Create another matrix with different dimensions
    MatrixV0<Integer> matrix3 = new MatrixV0<>(2, 2);

    // Set some values in the 2x2 matrix
    matrix3.set(0, 0, 1);
    matrix3.set(1, 1, 2);

    // Check that matrices with different dimensions are not equal
    assertFalse(matrix1.equals(matrix3));
    assertFalse(matrix2.equals(matrix3));
    assertFalse(matrix3.equals(matrix1));
    assertFalse(matrix3.equals(matrix2));

    // Ensure matrix1 is still equal to itself
    assertTrue(matrix1.equals(matrix1));
  } // TestEqualsMatrix()
} // class TestByKhanh
