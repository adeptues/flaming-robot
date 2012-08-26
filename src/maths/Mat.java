/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package maths;

/**
 * This class represents a matrix and the basic math operations that can be performed on it.
 * 
 * @author adeptues
 */
public class Mat {

   private double[][] matrix;
   private int rows;
   private int cols;

   /**
    * The size of the matrix
    */
   private int size;

   /**
    * default constructor creates a new 10*10 matrix
    */
   public Mat() {
      this.matrix = new double[10][10];
      this.cols = 10;
      this.rows = 10;
      this.size = cols * rows;
   }

   /**
    * creates a new empty matrix of size x and y where x is the width or num of columns and y is num of rows
    * 
    * @param x
    * @param y
    */
   public Mat(int x, int y) {
      matrix = new double[x][y];
      size = x * y;
      cols = x;
      rows = y;
   }

   public int getSize() {
      return this.size;
   }

   public boolean isSquare() {
      if (this.rows == this.cols) {
         return true;
      }
      return false;
   }

   public static boolean isMXMMatrix(Mat M1, Mat M2) {
      if (M1.isSquare() && M2.isSquare()) {
         if (M1.getSize() == M2.getSize()) {
            return true;
         }
         return false;

      }
      return false;
   }

   /**
    * creates a new matrix with the data from a 2d array and the number of rows and cols where rows are the
    * height of the matrix and cols are the length
    * 
    * @param data
    * @param rows
    * @param cols
    */
   public Mat(double[][] data, int rows, int cols) {
      matrix = data;
      this.rows = rows;
      this.cols = cols;
      this.size = rows * cols;
   }

   /**
    * Gets the data held in this matrix as a 2D array
    * 
    * @return
    */
   public double[][] getData() {
      return matrix;
   }

   public Mat multiply(Mat matrix) {
      // only works for now for mxn square matricies
      if (this.isSquare() && matrix.isSquare()) {
         if (isMXMMatrix(this, matrix)) {
            double[][] M2 = matrix.getData();// beacuse it passed all square tests safe t use cols
            double[][] M3 = matrixMultiply(getData(), M2, cols);
            return new Mat(M3, M3.length, M3.length);// should work still needs polish
         }
         return null;
         // then do calculation
         // matrixMultiply

      }

      return null;

   }

   /**
    * for rotating a around a point x and y where the origin is 0,0 the origin must be supplied
    * 
    * @param angle
    * @param originX
    * @param originY
    * @param x
    * @param y
    * @return double [][] size [1][2] x y vector
    */
   public double[][] rotate(double angle, double originX, double originY, int x, int y) {
      // translate to origin rotate then trasnlate back
      double[][] tlMatrix = Mat.buildTlMatrix(originX, originY);
      double[][] rMatrix = Mat.buildRMatrix(angle);
      double[][] inversertlMatrix = Mat.buildTlMatrix(-originX, -originY);
      double[][] compMat = matrixMultiply(tlMatrix, rMatrix);
      double[][] compMat2 = matrixMultiply(compMat, inversertlMatrix);
      double[][] result = transformCoords(x, y, compMat2);
      return result;
   }

   public static double[][] buildRMatrix(double angle) {
      double rads = Math.toRadians(angle);
      double cosine = Math.cos(rads);
      double sine = Math.sin(rads);
      double[][] M1 = { { cosine, -sine, 0 }, { sine, cosine, 0 }, { 0, 0, 1 } };
      return M1;
   }

   public static double[][] buildTlMatrix(double tx, double ty) {
      double[][] M1 = { { 1, 0, tx }, { 0, 1, ty }, { 0, 0, 1 } };
      return M1;
   }

   @Deprecated
   public double[][] translate(double tx, double ty, double x, double y) {
      double[][] M1 = { { 1, 0, tx }, { 0, 1, ty }, { 0, 0, 1 } };
      int ix = (int) Math.rint(x);
      int iy = (int) Math.rint(y);
      double r[][] = transformCoords(ix, iy, M1);
      return r;
   }

   private double[][] matrixMultiply(double[][] M1, double[][] M2, int size) {
      double[][] M3;
      M3 = new double[size][size];

      for (int i = 0; i < size; i++) {
         for (int n = 0; n < size; n++) {
            for (int j = 0; j < size; j++) {
               M3[i][n] += M1[i][j] * M2[j][n];
            }
         }
      }

      return M3;
   }

   /**
    * Produces a composite (2D) matrix by multiplying two other matrices together
    * 
    * @param Matrix
    *           M1 and Matrix M2
    */
   //
   // (Matrix M3 = Matrix M1 * Matrix M2)
   //
   private double[][] matrixMultiply(double[][] M1, double[][] M2) {
      double[][] M3;
      M3 = new double[3][3];

      for (int i = 0; i < 3; i++) {
         for (int n = 0; n < 3; n++) {
            for (int j = 0; j < 3; j++) {
               M3[i][n] += M1[i][j] * M2[j][n];
            }
         }
      }

      return M3;
   }

   /**
    * Transforms a co-ordinate pair using given matrix
    * 
    * @param input
    *           : x,y,matrix output: matrix holding one pair of (x,y) coords
    */
   public double[][] transformCoords(int xIn, int yIn, double[][] M) {
      double[][] result;

      result = new double[1][2];

      result[0][0] = (xIn * M[0][0]) + (yIn * M[0][1]) + (1 * M[0][2]);
      result[0][1] = (xIn * M[1][0]) + (yIn * M[1][1]) + (1 * M[1][2]);
      return result;
   } // end of transformCoords()

   // TODO matrix operations
   // TODO matrix multuply
   // TODO rotations and composite matrixes
}
