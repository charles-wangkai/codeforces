import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		int bestIndex = 0;
		for (int i = 1; i < a.length; i++) {
			if (Math.abs(a[(i + 1) % a.length] - a[i]) < Math.abs(a[(bestIndex + 1) % a.length] - a[bestIndex])) {
				bestIndex = i;
			}
		}

		return String.format("%d %d", bestIndex + 1, (bestIndex + 1) % a.length + 1);
	}
}
