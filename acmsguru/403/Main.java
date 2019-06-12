import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		System.out.println(solve(x));

		sc.close();
	}

	static int solve(int x) {
		return x * 2 + 1;
	}
}
