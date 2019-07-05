import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(String s) {
		int leftIndex = s.indexOf('[');
		if (leftIndex == -1) {
			return -1;
		}

		leftIndex = s.indexOf(':', leftIndex);
		if (leftIndex == -1) {
			return -1;
		}

		int rightIndex = s.lastIndexOf(']');
		if (rightIndex == -1) {
			return -1;
		}

		rightIndex = s.lastIndexOf(':', rightIndex);
		if (rightIndex == -1) {
			return -1;
		}

		if (leftIndex >= rightIndex) {
			return -1;
		}

		return (int) IntStream.range(leftIndex + 1, rightIndex).filter(i -> s.charAt(i) == '|').count() + 4;
	}
}
