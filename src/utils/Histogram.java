package utils;

/**
 * This class represents a histogram which can hold data and a size and performs all
 * processing upon the histogram. This class is for a 1 dimensional histogram
 * @author adeptues
 *
 */
public class Histogram {
	/**
	 * The histogram bins which hold data
	 */
	private int [] bins;
	
	/**
	 * Default constructor for the Histogram
	 */
	public Histogram(){
		
	}
	
	/**
	 * Creates a new Histogram of a specified size
	 * @param size
	 */
	public Histogram(int size){
		bins = new int [size];
	}
	
	/**
	 * Clears the histogram of data by setting all of the bins to 0
	 */
	public void clearBins(){
		for(int i = 0;i < bins.length;i++){
			bins[i] = 0;
		}
	}
	
	/**
	 * computes a histogram from the data by incrementing teh desired bin by one 
	 * @param data
	 * @return The bin Counter
	 */
	public int computeHistogram(int [] data){
		return 0;
	}

}
