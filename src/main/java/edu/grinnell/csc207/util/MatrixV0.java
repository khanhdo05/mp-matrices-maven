package edu.grinnell.csc207.util;

/**
 * An implementation of two-dimensional matrices.
 *
 * @author Khanh Do - CSC-207-02
 * @author Samuel A. Rebelsky
 *
 * @param <T> The type of values stored in the matrix.
 */
public class MatrixV0<T> implements Matrix<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /** The width of the matrix. */
  int width;

  /** The height of the matrix. */
  int height;

  /** The default value to fill. */
  T def;

  /** The 2-D matrix we store. */
  T[][] matrix;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new matrix of the specified width and height with the given value as the default.
   *
   * @param width The width of the matrix.
   * @param height The height of the matrix.
   * @param def The default value, used to fill all the cells.
   *
   * @throws NegativeArraySizeException If either the width or height are negative.
   */
  @SuppressWarnings("unchecked")
  public MatrixV0(int width, int height, T def) throws NegativeArraySizeException {
    if (width <= 0 || height <= 0) {
      throw new NegativeArraySizeException("Invalid width or height");
    } // if

    // Initialize fields
    this.width = width;
    this.height = height;
    this.def = def;
    this.matrix = (T[][]) new Object[height][width];

    // A nested for loop to fill the matrix with the default value.
    for (int row = 0; row < this.height; row++) {
      for (int col = 0; col < this.width; col++) {
        this.matrix[row][col] = this.def;
      } // for
    } // for
  } // MatrixV0(int, int, T)

  /**
   * Create a new matrix of the specified width and height with null as the default value.
   *
   * @param width The width of the matrix.
   * @param height The height of the matrix.
   *
   * @throws NegativeArraySizeException If either the width or height are negative.
   */
  public MatrixV0(int width, int height) throws NegativeArraySizeException {
    this(width, height, null);
  } // MatrixV0

  // +--------------+------------------------------------------------
  // | Core methods |
  // +--------------+

  /**
   * Get the element at the given row and column.
   *
   * @param row The row of the element.
   * @param col The column of the element.
   *
   * @return the value at the specified location.
   *
   * @throws IndexOutOfBoundsException If either the row or column is out of reasonable bounds.
   */
  @Override
  public T get(int row, int col) {
    if (row < 0 || row >= this.height || col < 0 || col >= this.width) {
      throw new IndexOutOfBoundsException("Error: invalid row or column.");
    } // if

    return this.matrix[row][col];
  } // get(int, int)

  /**
   * Set the element at the given row and column.
   *
   * @param row The row of the element.
   * @param col The column of the element.
   * @param val The value to set.
   *
   * @throws IndexOutOfBoundsException If either the row or column is out of reasonable bounds.
   */
  @Override
  public void set(int row, int col, T val) {
    if (row < 0 || row >= this.height || col < 0 || col >= this.width) {
      throw new IndexOutOfBoundsException("Error: invalid row or column.");
    } // if

    this.matrix[row][col] = val;
  } // set(int, int, T)

  /**
   * Determine the number of rows in the matrix.
   *
   * @return the number of rows.
   */
  @Override
  public int height() {
    return this.height;
  } // height()

  /**
   * Determine the number of columns in the matrix.
   *
   * @return the number of columns.
   */
  @Override
  public int width() {
    return this.width;
  } // width()

  /**
   * Insert a row filled with the default value.
   *
   * @param row The number of the row to insert.
   *
   * @throws IndexOutOfBoundsException If the row is negative or greater than the height.
   */
  @Override
  public void insertRow(int row) {
    if (row < 0 || row >= this.height()) {
      throw new IndexOutOfBoundsException("Error: invalid row.");
    } // if

    for (int col = 0; col < this.width(); col++) {
      this.matrix[row][col] = this.def;
    } // for
  } // insertRow(int)

  /**
   * Insert a row filled with the specified values.
   *
   * @param row The number of the row to insert.
   * @param vals The values to insert.
   *
   * @throws IndexOutOfBoundsException If the row is negative or greater than the height.
   * @throws ArraySizeException If the size of vals is not the same as the width of the matrix.
   */
  @Override
  public void insertRow(int row, T[] vals) throws ArraySizeException {
    if (row < 0 || row >= this.height()) {
      throw new IndexOutOfBoundsException("Error: invalid row.");
    } // if

    if (vals.length != this.width()) {
      throw new ArraySizeException("Error: invalid size of vals.");
    } // if

    System.arraycopy(vals, 0, this.matrix[row], 0, this.width());
  } // insertRow(int, T[])

  /**
   * Insert a column filled with the default value.
   *
   * @param col The number of the column to insert.
   *
   * @throws IndexOutOfBoundsException If the column is negative or greater than the width.
   */
  public void insertCol(int col) {
    if (col < 0 || col >= this.width()) {
      throw new IndexOutOfBoundsException("Error: invalid column.");
    } // if

    for (int row = 0; row < this.height(); row++) {
      this.matrix[row][col] = this.def;
    } // for
  } // insertCol(int)

  /**
   * Insert a column filled with the specified values.
   *
   * @param col The number of the column to insert.
   * @param vals The values to insert.
   *
   * @throws IndexOutOfBoundsException If the column is negative or greater than the width.
   * @throws ArraySizeException If the size of vals is not the same as the height of the matrix.
   */
  @Override
  public void insertCol(int col, T[] vals) throws ArraySizeException {
    if (col < 0 || col >= this.width()) {
      throw new IndexOutOfBoundsException("Error: invalid column.");
    } // if

    if (vals.length != this.height()) {
      throw new ArraySizeException("Error: invalid size of vals.");
    } // if

    System.arraycopy(vals, 0, this.matrix[col], 0, this.height());
  } // insertCol(int, T[])

  /**
   * Delete a row.
   *
   * @param row The number of the row to delete.
   *
   * @throws IndexOutOfBoundsException If the row is negative or greater than or equal to the
   *         height.
   */
  @Override
  public void deleteRow(int row) {
    // STUB
  } // deleteRow(int)

  /**
   * Delete a column.
   *
   * @param col The number of the column to delete.
   *
   * @throws IndexOutOfBoundsException If the column is negative or greater than or equal to the
   *         width.
   */
  @Override
  public void deleteCol(int col) {
    // STUB
  } // deleteCol(int)

  /**
   * Fill a rectangular region of the matrix.
   *
   * @param startRow The top edge / row to start with (inclusive).
   * @param startCol The left edge / column to start with (inclusive).
   * @param endRow The bottom edge / row to stop with (exclusive).
   * @param endCol The right edge / column to stop with (exclusive).
   * @param val The value to store.
   *
   * @throw IndexOutOfBoundsException If the rows or columns are inappropriate.
   */
  @Override
  public void fillRegion(int startRow, int startCol, int endRow, int endCol, T val) {
    // STUB
  } // fillRegion(int, int, int, int, T)

  /**
   * Fill a line (horizontal, vertical, diagonal).
   *
   * @param startRow The row to start with (inclusive).
   * @param startCol The column to start with (inclusive).
   * @param deltaRow How much to change the row in each step.
   * @param deltaCol How much to change the column in each step.
   * @param endRow The row to stop with (exclusive).
   * @param endCol The column to stop with (exclusive).
   * @param val The value to store.
   *
   * @throw IndexOutOfBoundsException If the rows or columns are inappropriate.
   */
  public void fillLine(int startRow, int startCol, int deltaRow, int deltaCol, int endRow,
      int endCol, T val) {
    // STUB
  } // fillLine(int, int, int, int, int, int, T)

  /**
   * A make a copy of the matrix. May share references (e.g., if individual elements are mutable,
   * mutating them in one matrix may affect the other matrix) or may not.
   *
   * @return a copy of the matrix.
   */
  @Override
  public Matrix<T> clone() {
    Matrix<T> copy = new MatrixV0<T>(this.width(), this.height(), this.def);

    for (int row = 0; row < this.height(); row++) {
      for (int col = 0; col < this.width(); col++) {
        copy.set(row, col, this.get(row, col));
      } // for
    } // for

    return copy;
  } // clone()

  /**
   * Determine if this object is equal to another object.
   *
   * @param other The object to compare.
   *
   * @return true if the other object is a matrix with the same width, height, and equal elements;
   *         false otherwise.
   */
  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object other) {
    if (other instanceof Matrix) {
      Matrix<T> otherMatrix = (Matrix<T>) other;
      if (this.width() == otherMatrix.width() && this.height() == otherMatrix.height()) {
        for (int row = 0; row < this.height(); row++) {
          for (int col = 0; col < this.width(); col++) {
            if (!this.get(row, col).equals(otherMatrix.get(row, col))) {
              return false;
            } // if
          } // for col
        } // for row
        return true;
      } // if
    } // if
    return false;
  } // equals(Object)

  /**
   * Compute a hash code for this matrix. Included because any object that implements `equals` is
   * expected to implement `hashCode` and ensure that the hash codes for two equal objects are the
   * same.
   *
   * @return the hash code.
   */
  @Override
  public int hashCode() {
    int multiplier = 7;
    int code = this.width() + multiplier * this.height();
    for (int row = 0; row < this.height(); row++) {
      for (int col = 0; col < this.width(); col++) {
        T val = this.get(row, col);
        if (val != null) {
          // It's okay if the following computation overflows, since
          // it will overflow uniformly.
          code = code * multiplier + val.hashCode();
        } // if
      } // for col
    } // for row
    return code;
  } // hashCode()
} // class MatrixV0
