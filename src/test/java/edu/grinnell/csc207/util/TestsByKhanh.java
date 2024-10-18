package edu.grinnell.csc207.util;

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
} // class TestByKhanh
