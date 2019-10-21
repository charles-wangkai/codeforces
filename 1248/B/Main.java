import java.util.Arrays;
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

	static long solve(int[] a) {
		int sum = Arrays.stream(a).sum();
		int side1 = Arrays.stream(a).boxed().sorted().limit(a.length / 2).mapToInt(x -> x).sum();
		int side2 = sum - side1;

		return square(side1) + square(side2);
	}

	static long square(int x) {
		return (long) x * x;
	}
}
