/**
 * 
 */
package atemis;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;

/**
 * This is the movement system reponsible for updating the co-ordinates of every moveable object on the screen
 * @author adeptues
 *
 */
public class MovementSystem extends EntityProcessingSystem{
	@Mapper ComponentMapper<Position> positionMapper;
	@Mapper ComponentMapper<Velocity> velocityMapper;

	/**
	 * Define the aspects that this system should process. As this is a movement system it should process Entities
	 * with both the position component and the velocity component 
	 * @param aspect
	 */
	public MovementSystem(Aspect aspect) {
		super(Aspect.getAspectForAll(Position.class, Velocity.class));
		// TODO Auto-generated constructor stub
	}
	
	public MovementSystem(){
		super(Aspect.getAspectForAll(Position.class, Velocity.class));
	}

	@Override
	protected void process(Entity entity) {
		//update movement co-ords get the components from the mappers
		//probs also need to poll input
		Position pos = positionMapper.get(entity);
		Velocity vel = velocityMapper.get(entity);// assume velocity is a direction
		pos.addX(vel.getVector().getX() * world.delta);//maybe add another constant speed
		pos.addY(vel.getVector().getY() * world.delta);
		
	}

}
