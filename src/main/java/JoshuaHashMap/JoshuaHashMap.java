package JoshuaHashMap;
import java.util.LinkedList;

public class JoshuaHashMap<E> {
	
	private LinkedList<E>[] data;
	
	/**
	 * A dumb hash map class
	 * @param data The initial data to put in the dumb hash map
	 */
	public JoshuaHashMap(E[] data) {
		this.data = parseData(data);
	}
	
	/**
	 * Get the hash of an object
	 * @param input The object to get the hash of
	 * @return The hash
	 */
	public int dumbHash(E input) {
		return input.toString().length();
	}
	
	/**
	 * If the dumb hash map contains the object
	 * @param input The object to check
	 * @return If the dumb hash map contains the object or not
	 */
	public boolean contains(E input) {
		for (LinkedList<E> element : data) {
			if (element.contains(input)) return true;
		}
		return false;
	}
	
	/**
	 * Parse the input array into a linked list
	 * @param input The input to parse
	 * @return The linked list
	 */
	private LinkedList<E>[] parseData(E[] input) {
		data = (LinkedList<E>[]) new LinkedList<?>[1];
		data[0] = new LinkedList<E>();
		for (E element : input) {
			int index = element.toString().length();
			if (index > data.length-1) {
				data = resize(data, index+1);
			}
			data[index].add(element);
		}
		return data;
	}
	
	/**
	 * Resize the internal array
	 * @param data The array to resize
	 * @param newSize The new size of the array
	 * @return The new array
	 */
	private LinkedList<E>[] resize(LinkedList<E>[] data, int newSize) {
		LinkedList<E>[] temp = data;
		data = (LinkedList<E>[]) new LinkedList<?>[newSize];
		for (int i = 0; i < temp.length; i++) {
			data[i] = temp[i];
		}
		for (int i = temp.length; i < data.length; i++) {
			data[i] = new LinkedList<E>();
		}
		return data;
	}
	
	/**
	 * Check how many times the value's hash collides with another value's hash
	 * @param data The object to check
	 * @return The number of collisions
	 */
	public int checkCollisions(E data) {
		return checkCollisions(data.toString().length());
	}
	
	/**
	 * Check the collision count given a hash
	 * @param index The hash to check
	 * @return The number of collisions
	 */
	public int checkCollisions(int index) {
		return data[index].size();
	}
}
