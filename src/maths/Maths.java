/**
 * 
 */
package maths;

/**
 * This package is to contain home made maths functions some of them will inevitables be duplicated in the
 * standard java Math package
 * 
 * @author adeptues
 * 
 */
public class Maths {

   public static float getRotatedX(float currentX, float currentY, float pivotX, float pivotY, float angle) {
      float x = currentX - pivotX;
      float y = currentY - pivotY;
      float a = (float) Math.toRadians(angle);
      float xr = (float) ((x * Math.cos(a)) - (y * Math.sin(a)));
      return xr + pivotX;
   }

   public static float getRotatedY(float currentX, float currentY, float pivotX, float pivotY, float angle) {
      float x = currentX - pivotX;
      float y = currentY - pivotY;
      float a = (float) Math.toRadians(angle);
      float yr = (float) ((x * Math.sin(a)) + (y * Math.cos(a)));
      return yr + pivotY;
   }

}
