import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String sequence = sc.next();
		System.out.println(solve(sequence));

		sc.close();
	}

	static int solve(String sequence) {
		int result = 0;
		int index = 0;
		while (index != sequence.length()) {
			if (sequence.startsWith("RU", index) || sequence.startsWith("UR", index)) {
				index += 2;
			} else {
				index++;
			}

			result++;
		}
		return result;
	}
}
