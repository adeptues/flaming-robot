/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import maths.Mat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author adeptues
 */
public class TestMat {
   public static final double[][] M1 = { { 3, 2, 1 }, { 1, 2, 3 }, { 2, 1, 2 } };
   public static final double[][] M2 = { { 1, 2, 3 }, { 2, 3, 1 }, { 1, 2, 3 } };
   public static final double[][] M4 = { { 3, 2 }, { 1, 2 }, { 2, 1 } };
   public static final double[][] M5 = { { 1, 2 }, { 2, 3 }, { 1, 2 } };
   public static final double[][] R1 = { { 8, 14, 14 }, { 8, 14, 14 }, { 6, 11, 13 } };
   public static final double[][] R2 = { { 8, 14 }, { 8, 14 }, { 6, 11 } };
   public static final double delta = 0.1;

   public TestMat() {
   }

   @BeforeClass
   public static void setUpClass() throws Exception {
   }

   @AfterClass
   public static void tearDownClass() throws Exception {
   }

   @Before
   public void setUp() {
   }

   @After
   public void tearDown() {
   }

   @Test
   public void testSize() {
      Mat m1 = new Mat();
      Mat m2 = new Mat(5, 5);
      Mat m3 = new Mat(5, 6);

      assertEquals(m1.getSize(), 100);
      assertEquals(m2.getSize(), 25);
      assertEquals(m3.getSize(), 30);
   }

   @Test
   public void testIsSquare() {
      Mat m1 = new Mat();
      Mat m2 = new Mat(3, 3);
      Mat m3 = new Mat(5, 6);

      assertTrue(m1.isSquare());
      assertTrue(m2.isSquare());
      assertTrue(!m3.isSquare());
   }

   @Test
   public void testIsMXMMatrix() {
      Mat m1 = new Mat();
      Mat m2 = new Mat();

      assertTrue(Mat.isMXMMatrix(m1, m2));
   }

   @Test
   public void testIsMXMMatrix2() {
      Mat m1 = new Mat();
      Mat m2 = new Mat(7, 3);
      assertTrue(!Mat.isMXMMatrix(m1, m2));
   }

   @Test
   public void testMultiply() {
      int cols = 3;
      int rows = 3;
      Mat MA1 = new Mat(M1, rows, cols);
      Mat MA2 = new Mat(M2, rows, cols);
      double[][] M3 = MA1.multiply(MA2).getData();
      if (M3 != null) {
         for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
               assertEquals(R1[i][j], M3[i][j], delta);
            }
         }
      } else {
         fail();
      }

   }

   @Test
   public void testMultiply2() {

      int cols = 2;
      int rows = 2;
      Mat MA1 = new Mat(M4, rows, cols);
      Mat MA2 = new Mat(M5, rows, cols);
      double[][] M3 = MA1.multiply(MA2).getData();
      if (M3 != null) {
         for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
               assertEquals(R2[i][j], M3[i][j], delta);
            }
         }
      } else {
         fail();
      }

   }

   @Test
   public void testTransformCoords() {
      double[][] M1 = { { 2, 4, 20 }, { 3, 5, 30 }, { 0, 0, 1 } };
      Mat mat = new Mat(M1, 3, 3);

      double[][] r = mat.transformCoords(10, 12, M1);
      assertEquals(r[0][0], 88, 0.1);
      assertEquals(r[0][1], 120, 0.1);
   }

   @Test
   public void testTranslate() {
      fail();
   }
}
