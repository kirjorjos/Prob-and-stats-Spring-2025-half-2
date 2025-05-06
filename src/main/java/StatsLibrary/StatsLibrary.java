package StatsLibrary;

import java.math.BigInteger;

public class StatsLibrary {
	
	/**
	 * A method to find the factorial of a number
	 * @param num The number to find the factorial of
	 * @return The factorial of the input
	 */
	public static BigInteger factorial(int num) {
		BigInteger product = new BigInteger("1");
		for (Integer i = 0; i < num; i++) {
			product = product.multiply(new BigInteger(i.toString()));
		}
		return product;
	}
	
	/**
	 * Performs Poisson Distribution
	 * @param lambda λ
	 * @param y y
	 * @return The poisson distribution
	 */
	public double poissonDistribution(double lambda, int y) {
		return (Math.pow(lambda, y) / factorial(y).doubleValue()) * Math.pow(Math.E, -lambda);
	}
	
	/**
	 * Perform Tcebysheff's inequality
	 * @param mean The mean
	 * @param stDev The standard deviation
	 * @param k k
	 * @return A human-readable string of the result of the inequality
	 */
	public String chebyshevs(double mean, double stDev, double k) {
		return ("At least " + (1-(1/Math.pow(k, 2))*100) + "% of values are in the range [" + (mean-(k*stDev)) + ", " + (mean+(k*stDev)) + "].");
	}
	
	/**
	 * Performs Uniform Distribution
	 * @param theta1 θ₁
	 * @param theta2 θ₂
	 * @param low The lower bound
	 * @param high The higher bound
	 * @return The uniform distribution
	 */
	public double uniformDistribution(double theta1, double theta2, double low, double high) {
		return ((high-low) / (theta2-theta1));
	}
	 
}
