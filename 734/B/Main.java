import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k2 = sc.nextInt();
		int k3 = sc.nextInt();
		int k5 = sc.nextInt();
		int k6 = sc.nextInt();
		System.out.println(solve(k2, k3, k5, k6));

		sc.close();
	}

	static int solve(int k2, int k3, int k5, int k6) {
		int sum = 0;
		while (k2 > 0 && k5 > 0 && k6 > 0) {
			k2--;
			k5--;
			k6--;
			sum += 256;
		}
		while (k3 > 0 && k2 > 0) {
			k3--;
			k2--;
			sum += 32;
		}
		return sum;
	}
}
