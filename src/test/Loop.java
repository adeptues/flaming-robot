/**
 * 
 */
package test;

import maths.Vector2D;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import utils.Log;

import atemis.BoundingBox;
import atemis.CollisionSystem;
import atemis.Line2D;
import atemis.MovementSystem;
import atemis.Position;
import atemis.RenderSystem;
import atemis.Renderable;
import atemis.Velocity;
import atemis.WorldBounds;

import com.artemis.Entity;
import com.artemis.World;

import core.GameWindowLWJGL;

/**
 * @author adeptues
 *
 */
public class Loop extends GameWindowLWJGL{
	private World world;

	public Loop(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameStartup() {
		Log.info(getClass().getSimpleName(), "Starting Artemis Entity Test");
		Log.info(getClass().getSimpleName(), "Building World ...");
		Line2D l1 = new Line2D(new Vector2D(1,1),new Vector2D(1,-1));
		Line2D l2 = new Line2D(new Vector2D(-1,1),new Vector2D(1,1));
		Line2D l3 = new Line2D(new Vector2D(-1,1),new Vector2D(-1,-1));
		Line2D l4 = new Line2D(new Vector2D(-1,-1),new Vector2D(1,-1));
		WorldBounds wbounds = new WorldBounds(l1, l2, l3, l4); 
		world = new World();
		//set systems
		world.setSystem(new MovementSystem());
		world.setSystem(new RenderSystem(), true);
		world.setSystem(new CollisionSystem(wbounds));
		world.initialize();
		Log.info(getClass().getSimpleName(), "World Initialized");
		Log.info(getClass().getSimpleName(), "Creating Entities");
		Entity e = world.createEntity();
		e.addComponent(new Position(0.0f,0.0f));
		e.addComponent(new Renderable(0.025f,0.025f));
		e.addComponent(new BoundingBox(0.025f, 0.025f));
		//then add velocity
		e.addComponent(new Velocity(new Vector2D(1,0)));
		e.addToWorld();
		Log.info(getClass().getSimpleName(), "Entities created");
		
	}

	@Override
	public void gameUpdate(double delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
	         stop();
	      }
		world.setDelta((float) delta);
		world.process();//each system will process its entiteis based of its aspect
		
	}

	@Override
	public void gameDraw() {
		// TODO Auto-generated method stub
		
		GL11.glColor3f(0.5f, 0.5f, 1.0f);
	      //ship.render();
	      
	      //draws grid / background
	      GL11.glBegin(GL11.GL_LINE_STRIP);
	      GL11.glVertex2f(0.0f, 0.0f);
	      GL11.glVertex2f(1, 0);
	      GL11.glEnd();
	      
	      GL11.glBegin(GL11.GL_LINE_STRIP);
	      GL11.glVertex2f(0.0f, 0.0f);
	      GL11.glVertex2f(0.0f, 1.0f);
	      GL11.glEnd();
	      
	      GL11.glBegin(GL11.GL_LINE_STRIP);
	      GL11.glVertex2f(0.0f, 0.0f);
	      GL11.glVertex2f(-1.0f, 0.0f);
	      GL11.glEnd();
	      
	      GL11.glBegin(GL11.GL_LINE_STRIP);
	      GL11.glVertex2f(0.0f, 0.0f);
	      GL11.glVertex2f(0.0f, -1.0f);
	      GL11.glEnd();
	      
	      
	      GL11.glPointSize(10);
	      GL11.glBegin(GL11.GL_POINTS);
	      GL11.glVertex2f(1.0f, 1.0f);
	      GL11.glEnd();
	      //call render subsystem
	      RenderSystem render = world.getSystem(RenderSystem.class);
	      render.process();//will draw each entity
		
	}

	@Override
	public void gameShutdown() {
		// TODO Auto-generated method stub
		//clean up world and entites
	}

}
