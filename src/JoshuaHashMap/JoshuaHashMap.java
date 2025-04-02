package src.JoshuaHashMap;
import java.util.LinkedList;

public class JoshuaHashMap<E> {
	
	private LinkedList<E>[] data;
	public JoshuaHashMap(E[] data) {
		this.data = parseData(data);
	}
	
	public int dumbHash(E input) {
		return input.toString().length();
	}
	
	public boolean contains(E input) {
		for (LinkedList<E> element : data) {
			if (element.contains(input)) return true;
		}
		return false;
	}
	
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
	
	public int checkCollisions(E data) {
		return checkCollisions(data.toString().length());
	}
	
	public int checkCollisions(int index) {
		return data[index].size();
	}
}
