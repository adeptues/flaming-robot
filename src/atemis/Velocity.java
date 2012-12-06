/**
 * 
 */
package atemis;

import maths.Vector2D;

import com.artemis.Component;

/**
 * velocity component contains the direction for the obejct to be used in conjuntion with the {@link Position}
 * @author adeptues
 *
 */
public class Velocity extends Component{
	
	private Vector2D vector;

	/**
	 * @param vector
	 */
	public Velocity(Vector2D vector) {
		this.vector = vector;
	}

	/**
	 * 
	 */
	public Velocity() {
	}

	/**
	 * @return the vector
	 */
	public Vector2D getVector() {
		return vector;
	}

	/**
	 * @param vector the vector to set
	 */
	public void setVector(Vector2D vector) {
		this.vector = vector;
	}
	
	

}
