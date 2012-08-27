/**
 * 
 */
package core;

/**
 * This version does exactly the same thing as {@link GameLoop} except it does not inherit from
 * {@link java.awt.Canvas} Because this implementation is designed for opengl with LWJGL and has no need for
 * the 2D Features of java canvas
 * 
 * @author adeptues
 * 
 */
public abstract class GameLoopLwjgl {

   /**
    * Run flag defines whether the main loop should run or not used as trigger.
    */
   private boolean runFlag;

   /**
    * This will be the main game loop responsible for logic rendoring animation and movement
    * 
    * @param delta
    *           The time between logic updates
    */
   public void run(double delta) {
      runFlag = true;
      startup();
      // time conversion to nano seconds
      double nextTime = System.nanoTime() / 1000000000.0;
      double maxTimeDiff = 0.5;
      int skippedFrames = 1;
      int maxSkippedFrames = 5;

      // start of loop
      while (runFlag) {
         double currTime = System.nanoTime() / 1000000000.0;
         if ((currTime - nextTime) > maxTimeDiff) {
            nextTime = currTime;
         }
         if (currTime >= nextTime) {
            // assign the time for the next update
            nextTime = nextTime + delta;
            update(delta);
            if ((currTime < nextTime) || (skippedFrames > maxSkippedFrames)) {
               draw();
               skippedFrames = 1;

            } else {
               skippedFrames++;
            }
         } else {
            // sleep and play catch up
            int sleep = (int) (1000.0 * (nextTime - currTime));
            if (sleep > 0) {
               // then sleep
               try {
                  Thread.sleep(sleep);
               } catch (InterruptedException e) {
                  // do nothing
               }
            }
         }
      }
      shutdown();
   }

   public void stop() {
      runFlag = false;
   }

   protected abstract void shutdown();

   protected abstract void startup();

   /**
    * This method should be implemented in any subclass as it is called to performgame logic
    */
   public abstract void update(double delta);

   /**
    * This is responsible for drawing the graphics and will be called by teh game loop for rendering
    */
   public abstract void draw();

}
