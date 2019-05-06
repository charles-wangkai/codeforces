import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] letters = new int[n];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = sc.nextInt();
		}
		System.out.println(solve(letters));

		sc.close();
	}

	static int solve(int[] letters) {
		int result = 0;
		int prevOneIndex = -1;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == 1) {
				if (prevOneIndex < 0 || prevOneIndex + 1 == i) {
					result++;
				} else {
					result += 2;
				}

				prevOneIndex = i;
			}
		}
		return result;
	}
}
