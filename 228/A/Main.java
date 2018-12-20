import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int s3 = sc.nextInt();
		int s4 = sc.nextInt();
		System.out.println(solve(s1, s2, s3, s4));

		sc.close();
	}

	static int solve(int s1, int s2, int s3, int s4) {
		return 4 - (int) Arrays.stream(new int[] { s1, s2, s3, s4 }).distinct().count();
	}
}
