package JoshuaHashMap;
import java.util.LinkedList;

public class JoshuaHashMapTester {
	public static void main(String[] args) {
		JoshuaHashMap<String> tester = new JoshuaHashMap<String>(new String[] {"test", "test1", "test2"});
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("List contains \"test2\": " + tester.contains("test2"));	//actually returns true because it contains test1
		System.out.println("\"Test2\" has " + tester.checkCollisions("test2") + " collisions.");
	}
}
