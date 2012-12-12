/**
 * 
 */
package atemis;

/**
 * This class should contain the world bounds ie 4 lines that define either
 * the viewable screen or the end of the world
 * @author adeptues
 *
 */
public class WorldBounds {
	private Line2D l1;
	private Line2D l2;
	private Line2D l3;
	private Line2D l4;
	/**
	 * @param l1
	 * @param l2
	 * @param l3
	 * @param l4
	 */
	public WorldBounds(Line2D l1, Line2D l2, Line2D l3, Line2D l4) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		this.l4 = l4;
	}
	/**
	 * @return the l1
	 */
	public Line2D getL1() {
		return l1;
	}
	/**
	 * @param l1 the l1 to set
	 */
	public void setL1(Line2D l1) {
		this.l1 = l1;
	}
	/**
	 * @return the l2
	 */
	public Line2D getL2() {
		return l2;
	}
	/**
	 * @param l2 the l2 to set
	 */
	public void setL2(Line2D l2) {
		this.l2 = l2;
	}
	/**
	 * @return the l3
	 */
	public Line2D getL3() {
		return l3;
	}
	/**
	 * @param l3 the l3 to set
	 */
	public void setL3(Line2D l3) {
		this.l3 = l3;
	}
	/**
	 * @return the l4
	 */
	public Line2D getL4() {
		return l4;
	}
	/**
	 * @param l4 the l4 to set
	 */
	public void setL4(Line2D l4) {
		this.l4 = l4;
	}
	
	public Line2D [] getLinesArray(){
		Line2D [] lines = new Line2D[4];
		lines[0] = l1;
		lines[1] = l2;
		lines[2] = l3;
		lines[3] = l4;
		return lines;
	}
	
	
	

}
