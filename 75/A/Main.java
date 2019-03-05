import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(solve(a, b) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int a, int b) {
		return removeZeros(a) + removeZeros(b) == removeZeros(a + b);
	}

	static int removeZeros(int x) {
		return Integer.parseInt(String.join("", String.valueOf(x).chars().filter(ch -> ch != '0')
				.mapToObj(ch -> String.valueOf((char) ch)).toArray(String[]::new)));
	}
}
