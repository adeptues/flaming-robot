/**
 * 
 */
package test;

/**
 * @author adeptues
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Loop loop = new Loop("Entity test", 800, 600);
		loop.run(1.0 / 60.0);
	      System.out.println("Finished");
	      System.exit(0);

	}

}
