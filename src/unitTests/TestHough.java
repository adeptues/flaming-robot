/**
 * 
 */
package unitTests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

/**
 * @author adeptues
 *
 */
public class TestHough {

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
        
        /**
         * This test, tests the output of the accumulator from both the java
         * version and the working C version this then shows whether the 
         * calculations are being performed correctly and whether a problem lies
         * with either the houghspace or the drawing of hough space.
         */
        @Test
        public void testHoughAlgorithm(){
        	fail();
        try {//FIXME WARNING FILE NOT FOUND!
            LinkedList<String> expected = loadTemplate("expectedACC");
            LinkedList<String> actual = loadTemplate("actualACC.txt");
            for(String x: expected){
                for(String z: actual){
                    //Assert Here
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TestHough.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        private LinkedList<String> loadTemplate(String filePath) throws IOException{
		FileReader reader = new FileReader(filePath);
		BufferedReader buf = new BufferedReader(reader);
		LinkedList<String> template = new LinkedList<String>();
		String line1;
		do{
			line1 = buf.readLine();
			if(line1 != null){
				template.add(line1);
			}
		}while(line1 != null);
		buf.close();
		return template;
	}

	@Test
	public void testRounding() {
		double a = 3.25;
		double b = 3.75;
		double c = 3.499;
		double d = 3.51;
		int round = (int)Math.rint(a);
		assertEquals(3, round);
		round = (int)Math.rint(b);
		assertEquals(4,round);
		round = (int)Math.rint(c);
		assertEquals(3,round);
		round = (int)Math.rint(d);
		assertEquals(4,round);
	}

}
