import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(Arrays.stream(solve(n)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int n) {
		int[] result = new int[n];
		int index = 0;
		for (int number = 2; index < result.length; number++) {
			if (isPrime(number)) {
				result[index] = number;
				index++;
			}
		}
		return result;
	}

	static boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
