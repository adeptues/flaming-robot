/**
 * 
 */
package atemis;

import org.lwjgl.opengl.GL11;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

/**
 * This class is responsible for drawing the objects / graphics
 * @author adeptues
 *
 */
public class RenderSystem extends EntityProcessingSystem{
	@Mapper ComponentMapper<Position> positionMapper;
	@Mapper ComponentMapper<Renderable> renderableMapper;

	public RenderSystem(Aspect aspect) {
		super(Aspect.getAspectForAll(Position.class,Renderable.class));
		// TODO Auto-generated constructor stub
	}
	
	public RenderSystem(){
		super(Aspect.getAspectForAll(Position.class,Renderable.class));
	}

	@Override
	protected void process(Entity Entity) {
		Position pos = positionMapper.get(Entity);
		Renderable rend = renderableMapper.get(Entity);
		
		
	}
	
	/**
	 * draws a quad centred on a position component given a renderable components height and width.
	 * @param pos
	 * @param rend
	 */
	public void drawQuad(Position pos, Renderable rend){
		float by = rend.getHeight();//box height 
		float bx = rend.getWidth();// box width
		
		//this renders a quad on the center of the position
		float c1y = pos.getY() + (0.5f*by);
		float c1x = pos.getX() + (-0.5f*bx);
		float c2x = pos.getX() + (0.5f*bx);
		float c2y = pos.getY() + (0.5f*by);
		float c3x = pos.getX() + (0.5f*bx);
		float c3y = pos.getY() + (-0.5f*by);
		float c4x = pos.getX() + (-0.5f*bx);
		float c4y = pos.getY() + (-0.5f*by);
		
		//draw quad
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(c1x, c1y);
		GL11.glVertex2f(c2x, c2y);
		GL11.glVertex2f(c3x, c3y);
		GL11.glVertex2f(c4x, c4y);
		GL11.glEnd();
	}

}
