/**
 * 
 */
package core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import utils.Log;

/**
 * This is the game window which will contain the rendering context and graphics and will allow us to draw to
 * a window which the java's graphics 2D canvas. contains all of the windowing code and some methods of
 * trapping event handling from the user.
 * 
 * @author adeptues
 * 
 */
@Deprecated
public abstract class GameWindow extends GameLoop {

   private JFrame frame;
   private Canvas canvas;
   private BufferStrategy buffer;
   private Keyboard keyboard;
   private Mouse mouse;
   private MouseWheel mouseWheel;
   private boolean FSEM;

   // TODO add FSEM full screen exclusive mode to the engine by adding boolean to constuctor
   public GameWindow(String title, int width, int height) {
      Log.debug("Core", "Creating game " + title + " (" + width + ", " + height + ")");
      frameInit(width, height);
      canvasInput();
      FSEM = false;

   }// TODO remove setters only getters needed

   public String getTitle() {
      return frame.getTitle();
   }

   @Override
   public int getWidth() {
      return canvas.getWidth();
   }

   @Override
   public int getHeight() {
      return canvas.getHeight();
   }

   public Keyboard getKeyboard() {
      return keyboard;
   }

   public void setKeyboard(Keyboard keyboard) {
      this.keyboard = keyboard;
   }

   public Mouse getMouse() {
      return mouse;
   }

   public void setMouse(Mouse mouse) {
      this.mouse = mouse;
   }

   public MouseWheel getMouseWheel() {
      return mouseWheel;
   }

   public void setMouseWheel(MouseWheel mouseWheel) {
      this.mouseWheel = mouseWheel;
   }

   public boolean isFullScreenRunning() {
      return FSEM;
   }

   public void fullScreen(boolean arg0) {
      GraphicsDevice device = utils.GraphicsHelper.getPrimaryDisplay();
      Log.info(getClass().getSimpleName(), "Enabling FullScreen to " + arg0);
      if (arg0) {
         // then turn on fullscreen
         try {
            device.setFullScreenWindow(frame);
            FSEM = true;
         } catch (Exception e) {
            FSEM = false;
            e.printStackTrace();
         } finally {
            // graphicsCard.setFullScreenWindow(null);
         }
      } else {
         if (device.isDisplayChangeSupported()) {
            device.setFullScreenWindow(null);
            FSEM = false;
         }
      }

   }

   private void canvasInput() {
      // double buffering
      canvas.createBufferStrategy(2);
      buffer = canvas.getBufferStrategy();
      // intialise user input
      keyboard = new Keyboard();
      mouse = new Mouse();
      mouseWheel = new MouseWheel();
      canvas.addKeyListener(keyboard);
      canvas.addMouseListener(mouse);
      canvas.addMouseMotionListener(mouse);
      canvas.addMouseWheelListener(mouseWheel);
      canvas.requestFocus();
   }

   private void frameInit(int width, int height) {
      frame = new JFrame();
      frame.setResizable(false);
      // TODO add frame close behaviour
      canvas = new Canvas();
      // we will control repaint
      canvas.setIgnoreRepaint(true);
      frame.add(canvas);// TODO use layout manager
      canvas.setSize(width, height);
      frame.pack();
      frame.setVisible(true);
   }

   @Override
   protected void startup() {
      gameStartup();
   }

   @Override
   public void update(double delta) {
      // process input first
      keyboard.update();
      mouse.update();
      mouseWheel.update();
      // call game specific logic
      gameUpdate(delta);
   }

   @Override
   public void draw() {
      // get teh graphics object
      Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
      // clear window
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
      // send configured graphics object to be handled by game specific rendering
      gameDraw(g);
      // double buffer
      buffer.show();
      // release graphics object
      g.dispose();
   }

   @Override
   protected void shutdown() {
      gameShutdown();
   }

   public abstract void gameStartup();

   public abstract void gameUpdate(double delta);

   public abstract void gameDraw(Graphics2D g);

   public abstract void gameShutdown();

}
