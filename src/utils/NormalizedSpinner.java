/**
 * 
 */
package utils;

/**
 * 
 * from http://www.java-gaming.org/topics/utils-essentials/22144/view.html
 * @author adeptues
 *
 */
public class NormalizedSpinner {
	
	/**
	    * Spin a spinner with the given relative probabilities, get the index that results.  This
	    * method does not alter the passed array.
	    * <pre>
	    * normalizedSpinner(10, 20, 30) => 1/6 chance of 0, 1/3 chance of 1, 1/2 chance of 2
	    * normalizedSpinner(1,1,2) => 1/4 chance of 0, 1/4 chance of 1, 1/2 chance of 2
	    * </pre>
	    * Note: during intermediate steps, this method will cause two float[] creations, the
	    * same length as the probabilities array.  If creation is a concern, use {@link #spinner(float[], float[])}
	    * to pass your own pre-allocated intermediate array and handle the probability normalization yourself. 
	    * Also remember that unless probabilities is passed as an array, Java's varargs will create another
	    * intermediate array.
	    * 
	    * @param probabilities a list of relative probabilities
	    * @return the index of the event that is randomly chosen based on the provided probabilities
	    */
	   public static int normalizedSpinner(float ... probabilities) {
	      float sum = 0.0f;
	      for (int i=0; i<probabilities.length; ++i) {
	         sum += probabilities[i];
	      }
	      if (sum == 0.0f) {
	         throw new IllegalArgumentException("At least one probability must be non-zero.");
	      } else if (sum < 0.0f) {
	         throw new IllegalArgumentException("Probabilities may not be negative.");
	      }
	      float[] normProbs = new float[probabilities.length];
	      for (int i=0; i<probabilities.length; ++i) {
	         normProbs[i] = probabilities[i] / sum;
	      }
	      return spinner(normProbs);
	   }
	   
	    /**
	     * Spin a spinner with the given probabilities, get the index that results.
	     * Sum of probabilities should add up to 1f.
	     * 
	     * If the sum of probabilities is less than 1, the last index gets all the
	     * remaining probability.
	     * e.g. spinner(0.5f, 0.3f) => 50% chance of 0, 50% chance of 1
	     * 
	     * If the sum of probabilities is greater than 1, the probabilities are clipped
	     * at 1.
	     * 
	     * e.g. spinner(0.5f, 0.3f, 0.5f) => 50% chance of 0, 30% chance of 1, 20% chance of 2 (extra 30% discarded)
	     * 
	     * This method creates an intermediate float array the same length as probabilities; if garbage
	     * creation is a concern, use {@link #spinner(float[], float[])} instead, and provide a pre-allocated
	     * array of the correct length as the first parameter.
	     * 
	     * @param probabilities a list of probabilities that should add up to 1
	     * @return the index of the event that is randomly chosen based on the provided probabilities
	     */
	    public static int spinner(float ... probabilities) {
	        float[] mins = new float[probabilities.length];
	        return spinner(mins, probabilities);
	    }
	    
	    /**
	     * Used instead of {@link #spinner(float...)} to avoid garbage creation by manually supplying
	     * intermediate array.
	     * 
	     * @param auxiliaryArray a pre-allocated array to use for intermediate step that should
	     * have at least the same length as the probabilities array (used to avoid intermediate allocations)
	     * @param probabilities a list of probabilities that should add up to 1
	     * @return the index of the event that is chosen
	     * @see Spinner#spinner(float...)
	     */
	    public static int spinner(float[] auxiliaryArray, float[] probabilities) {
	       if (auxiliaryArray.length < probabilities.length){
	          throw new IllegalArgumentException("Auxiliary array must have at least the same length as probabilities array.");
	       }
	       float sum = 0.0f;
	        float[] mins = auxiliaryArray;
	        for (int i = 0; i < probabilities.length; ++i) {
	            if (probabilities[i] < 0.0f) {
	                throw new IllegalArgumentException("Probabilities must be positive; received " + probabilities[i] +
	                        " as parameter " + i + ".");
	            }
	            mins[i] = sum;
	            sum += probabilities[i];
	        }
	        double randomNumber = Math.random();
	        for (int i = probabilities.length - 1; i > 0; --i) {
	            if (randomNumber >= mins[i]) {
	                return i;
	            }
	        }
	        return 0;
	    }

}
