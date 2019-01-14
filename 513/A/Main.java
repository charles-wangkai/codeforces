import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int k1 = sc.nextInt();
		int k2 = sc.nextInt();
		System.out.println(solve(n1, n2, k1, k2));

		sc.close();
	}

	static String solve(int n1, int n2, int k1, int k2) {
		return (n1 > n2) ? "First" : "Second";
	}
}
