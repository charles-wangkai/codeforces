import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long k = sc.nextLong();
		System.out.println(solve(n, k));

		sc.close();
	}

	static int solve(int n, long k) {
		int middle = n;
		long length = (1L << middle) - 1;
		while (k != (length + 1) / 2) {
			if (k > (length + 1) / 2) {
				k = length + 1 - k;
			}

			middle--;
			length /= 2;
		}
		return middle;
	}
}
