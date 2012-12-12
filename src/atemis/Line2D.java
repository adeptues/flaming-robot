package atemis;

import maths.Vector2D;

/**
 * This class defines a line in 2d space as having two end points p1 and p2 wich are 2d vectors
 * @author adeptues
 *
 */
public class Line2D {
	private Vector2D p1;
	private Vector2D p2;
	
	/**
	 * default constructor line is a single point
	 */
	public Line2D(){
		p1 = new Vector2D(0, 0);
		p2 = new Vector2D(0,0);
	}

	/**
	 * @param p1
	 * @param p2
	 */
	public Line2D(Vector2D p1, Vector2D p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	/**
	 * @return the p1
	 */
	public Vector2D getP1() {
		return p1;
	}

	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(Vector2D p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p2
	 */
	public Vector2D getP2() {
		return p2;
	}

	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(Vector2D p2) {
		this.p2 = p2;
	}
	
	

}
