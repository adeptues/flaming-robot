/**
 * 
 */
package atemis;

import com.artemis.Component;

/**
 * This is a position component for the artemis entity components system. components are just data artefacts
 * 
 * @author adeptues
 *
 */
public class Position extends Component{

	private float x;
	private float y;
	
	/**
	 * Creates a default position component designed to store the entities location on in the game. creates the position
	 * at (0,0) origin
	 */
	public Position() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	/**
	 * increment x by a givent amount
	 * @param amount
	 */
	public void addX(float amount){
		this.x += amount;
	}
	
	/**
	 * increment y by a given amount
	 * @param amount
	 */
	public void addY(float amount){
		this.y += amount;
	}

	/**
	 * creates a position component with at an x and y location.
	 * @param x
	 * @param y
	 */
	public Position(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	
	

}
