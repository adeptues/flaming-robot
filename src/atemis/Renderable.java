/**
 * 
 */
package atemis;

import com.artemis.Component;

/**
 * component for 2d drawing. this specific component defines Quads size by height and width for which to be drawn
 * @author adeptues
 *
 */
public class Renderable extends Component{
	private float height;
	private float width;
	
	/**
	 * create a renderable box with a width and height component
	 * @param height
	 * @param width
	 */
	public Renderable(float height, float width) {
		this.height = height;
		this.width = width;
	}
	
	/**
	 * this will display nothing as it has a default of 0.0f
	 */
	public Renderable() {
		this.height = 0.0f;
		this.width = 0.0f;
	}
	/**
	 * @return the height
	 */
	public float getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}
	
	

}
