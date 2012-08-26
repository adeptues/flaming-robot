package test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

public class SimpleScene {
   public static void main(String[] args) {
      GLProfile glp = GLProfile.getDefault();
      GLCapabilities caps = new GLCapabilities(glp);
      GLCanvas canvas = new GLCanvas(caps);

      Frame frame = new Frame("AWT Window Test");
      frame.setSize(300, 300);
      frame.add(canvas);
      frame.setVisible(true);

      // by default, an AWT Frame doesn't do anything when you click
      // the close button; this bit of code will terminate the program when
      // the window is asked to close
      frame.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
}