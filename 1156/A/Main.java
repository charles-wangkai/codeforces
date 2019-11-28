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
		int pointNum = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] == 1) {
				if (a[i - 1] == 2) {
					pointNum += 3;
				} else {
					pointNum += 4;
				}
			} else if (a[i] == 2) {
				if (a[i - 1] == 1) {
					if (i != 1 && a[i - 2] == 3) {
						pointNum += 2;
					} else {
						pointNum += 3;
					}
				} else {
					return "Infinite";
				}
			} else {
				if (a[i - 1] == 1) {
					pointNum += 4;
				} else {
					return "Infinite";
				}
			}
		}

		return String.format("Finite\n%d", pointNum);
	}
}
