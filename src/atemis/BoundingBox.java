/**
 * 
 */
package atemis;

import com.artemis.Component;

/**
 * Bounding box component defines a box area that is used for collisions. is always box / cube quad
 * @author adeptues
 *
 */
public class BoundingBox extends Component{
	
	private float x;
	private float y;
	/**
	 * @param x
	 * @param y
	 */
	public BoundingBox(float x, float y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 */
	public BoundingBox() {
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
