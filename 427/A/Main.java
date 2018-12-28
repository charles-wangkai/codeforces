import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		System.out.println(solve(numbers));

		sc.close();
	}

	static int solve(int[] numbers) {
		int result = 0;
		int officerNum = 0;
		for (int number : numbers) {
			if (number > 0) {
				officerNum += number;
			} else {
				if (officerNum == 0) {
					result++;
				} else {
					officerNum--;
				}
			}
		}
		return result;
	}
}
