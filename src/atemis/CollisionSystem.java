/**
 * 
 */
package atemis;

import maths.Vector2D;

import collisions.LineIntersection;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

/**
 * This is for thge colision detection maybe merge this as a subsyetm of the physics system
 * @author adeptues
 *
 */
public class CollisionSystem extends EntityProcessingSystem {
	@Mapper ComponentMapper<Position> positionMapper;
	@Mapper ComponentMapper<BoundingBox> boundsMapper;
	@Mapper ComponentMapper<Velocity> velocityMapper;
	
	private WorldBounds worldBounds;
	

	public CollisionSystem(Aspect aspect) {
		super(Aspect.getAspectForAll(Position.class, BoundingBox.class));
		// TODO Auto-generated constructor stub
	}
	
	public CollisionSystem(WorldBounds worldBounds){
		super(Aspect.getAspectForAll(Position.class, BoundingBox.class,Velocity.class));
		this.worldBounds = worldBounds;
	}

	@Override
	protected void process(Entity entity) {
		Position pos = positionMapper.get(entity);
		BoundingBox bounds = boundsMapper.get(entity);
		Velocity direction = velocityMapper.get(entity);
		float boundsHeight = bounds.getY();
		float boundsWidth = bounds.getX();
		Line2D [] lines = genBoundsLines(bounds, pos);
		Line2D [] worldLines = worldBounds.getLinesArray();
		
		for(int i = 0; i < lines.length; i++){
			for(int j = 0; j < worldLines.length; j++){
				Vector2D point = LineIntersection.lineIntersect(lines[i], worldLines[j]);
				if(point != null){
					System.out.println("Collision");
					if(direction.getVector().getX() == 1f){
						//then set to opps direction
						direction.setVector(new Vector2D(-1f, 0f));
						break;
					}else if(direction.getVector().getX() == -1f){
						direction.setVector(new Vector2D(1f, 0f));
						break;
					}
				
				}
			}
		}
		
		
		
	}
	
	private Line2D [] genBoundsLines(BoundingBox box, Position pos){
		Line2D [] lines = new Line2D[4];
		float by = box.getY();//box height 
		float bx = box.getX();// box width
		
		//this renders a quad on the center of the position
		float c1y = pos.getY() + (0.5f*by);
		float c1x = pos.getX() + (-0.5f*bx);
		float c2x = pos.getX() + (0.5f*bx);
		float c2y = pos.getY() + (0.5f*by);
		float c3x = pos.getX() + (0.5f*bx);
		float c3y = pos.getY() + (-0.5f*by);
		float c4x = pos.getX() + (-0.5f*bx);
		float c4y = pos.getY() + (-0.5f*by);
		
		Line2D l1 = new Line2D(new Vector2D(c1x,c1y),new Vector2D(c2x,c2y));
		Line2D l2 = new Line2D(new Vector2D(c2x,c2y),new Vector2D(c3x,c3y));
		Line2D l3 = new Line2D(new Vector2D(c3x,c3y),new Vector2D(c4x,c4y));
		Line2D l4 = new Line2D(new Vector2D(c4x,c4y),new Vector2D(c1x,c1y));
		lines[0] = l1;
		lines[1] = l2;
		lines[2] = l3;
		lines[3] = l4;
		return lines;
	}

}
