import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		return (int) IntStream.rangeClosed(1, n).filter(Main::isAlmostPrime).count();
	}

	static boolean isAlmostPrime(int x) {
		int primeDivisorNum = 0;
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				primeDivisorNum++;

				while (x % i == 0) {
					x /= i;
				}
			}
		}
		if (x != 1) {
			primeDivisorNum++;
		}

		return primeDivisorNum == 2;
	}
}
