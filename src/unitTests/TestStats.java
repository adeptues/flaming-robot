/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTests;

import maths.Stats;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * This is the test class for the stats class and it tests all of the 
 * statistic functions in the stats class
 * @author adeptues
 */
public class TestStats {
    private double [] xData = {5.0,15.0,7.0,15.0,4.0,10.0,8.0,9.0,23.0};
    private double [] yData = {7.0,19.0,5.0,10.0,11.0,8.0,18.0,15.0,20.0};
    
    public TestStats() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testStandardDeviation(){
        double expected = 6.0207972894;
        double actual = Stats.standardDeviation(xData);
        double delta = 0.1;
        assertEquals(expected, actual, delta);
    }
    
    @Test
    public void testAverage(){
        double expected = 10.66666667;
        double delta = 0.1;
        double actual = Stats.average(xData);
        //System.out.println("Expected is : "+expected+" Actual is : "+actual);
        assertEquals(expected, actual, delta);
    }
    @Test
    public void testVariance(){
        double expected = 36.25;
        double actual = Stats.variance(xData);
        double delta = 0.1;
        assertEquals(expected, actual, delta);
    }
    @Test
    public void testCovariance(){
        double expected = 18.0740740741;
        double actual = Stats.coVariance(xData, yData);
        double delta = 0.1;
        assertEquals(expected, actual, delta);
    }
}
