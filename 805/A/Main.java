import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int r = sc.nextInt();
		System.out.println(solve(l, r));

		sc.close();
	}

	static int solve(int l, int r) {
		return (l == r) ? l : 2;
	}
}
