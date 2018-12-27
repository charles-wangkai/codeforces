import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		Queue<Element> queue = new LinkedList<>();
		queue.offer(new Element(1, "Sheldon"));
		queue.offer(new Element(1, "Leonard"));
		queue.offer(new Element(1, "Penny"));
		queue.offer(new Element(1, "Rajesh"));
		queue.offer(new Element(1, "Howard"));

		while (true) {
			Element head = queue.poll();
			if (n <= head.count) {
				return head.name;
			}

			n -= head.count;
			queue.offer(new Element(head.count * 2, head.name));
		}
	}
}

class Element {
	int count;
	String name;

	Element(int count, String name) {
		this.count = count;
		this.name = name;
	}
}