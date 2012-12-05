/**
 * 
 */
package core;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * This class is an implementation of a window renderer using the lwjgl (Light weight java gaming library)
 * which provides wrappers to jogl and by enlarge open gl and is easier to set up and configure and use than
 * jogl and provides both 2D and 3D api rendering capabilities but is slightly harder to use than standard
 * java Canvas implementation in {@link GameWindow} does not use awt canvas
 * 
 * @author adeptues
 * 
 */
public abstract class GameWindowLWJGL extends GameLoopLwjgl {
   // TODO add world manager
   private String title;
   private int width;
   private int height;

   public GameWindowLWJGL(String title, int width, int height) {
      // TODO add event handling and intial gl rendering then leave rest specific to game
      this.title = title;
      this.width = width;
      this.height = height;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   @Override
   protected void shutdown() {
      // destroy deisplay
      gameShutdown();
      Display.destroy();

   }

   @Override
   protected void startup() {
      // create display with settings
      try {
         Display.setDisplayMode(new DisplayMode(width, height));
         Display.create();

         GL11.glMatrixMode(GL11.GL_PROJECTION);
         GL11.glLoadIdentity();
         GL11.glOrtho(1, 1, 1, 1, 1, -1);//this is for 2d drawing ie our drawing window space
         GL11.glMatrixMode(GL11.GL_MODELVIEW);
      } catch (LWJGLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      gameStartup();

   }

   @Override
   public void update(double delta) {
      // handle / parse userinput into event que and input devices then call game specific update
      // basic keyboard and mouse input in lwjgl is static so no need to process leave up to application
      if (Display.isCloseRequested()) {
         shutdown();
      }
      gameUpdate(delta);

   }

   @Override
   public void draw() {
      // set intial background / clear context here then call game specific
      GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

      gameDraw();
      Display.update();
      // swap buffers
      // release / tidy up

   }

   public abstract void gameStartup();

   public abstract void gameUpdate(double delta);

   public abstract void gameDraw();

   public abstract void gameShutdown();

}
