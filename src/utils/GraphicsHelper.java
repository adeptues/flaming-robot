/**
 * 
 */
package utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * @author adeptues
 * 
 */
public class GraphicsHelper {

   /**
    * gets all the available graphics devices that can be drawn to IE screens or monitors
    * 
    * @return
    */
   public static GraphicsDevice[] getSupportedScreens() {
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      GraphicsDevice[] devices = ge.getScreenDevices();
      for (int i = 0; i < devices.length; i++) {
         System.out.println(i + ". " + devices[i]);
      }
      return devices;
   }

   /**
    * Not yet implemented
    * 
    * @return
    */
   public static GraphicsDevice getPrimaryDisplay() {
      GraphicsDevice device = getSupportedScreens()[0];
      return device;
   }

}
