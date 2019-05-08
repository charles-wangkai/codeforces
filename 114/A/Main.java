import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		int l = sc.nextInt();
		System.out.print(solve(k, l));

		sc.close();
	}

	static String solve(int k, int l) {
		long power = k;
		int importance = 0;
		while (power < l) {
			power *= k;
			importance++;
		}

		return (power == l) ? String.format("YES\n%d", importance) : "NO";
	}
}
