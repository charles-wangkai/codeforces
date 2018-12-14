import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b));

		sc.close();
	}

	static int solve(int[] a, int[] b) {
		int maxPassengerNum = 0;
		int passengerNum = 0;
		for (int i = 0; i < a.length; i++) {
			passengerNum += b[i] - a[i];
			maxPassengerNum = Math.max(maxPassengerNum, passengerNum);
		}
		return maxPassengerNum;
	}
}
