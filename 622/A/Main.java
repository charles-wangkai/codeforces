import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(long n) {
		int largest = 0;
		while ((largest + 1L) * (largest + 2) / 2 < n) {
			largest++;
		}

		return (int) (n - largest * (largest + 1L) / 2);
	}
}
