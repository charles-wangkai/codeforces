import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int da = sc.nextInt();
		int db = sc.nextInt();
		System.out.println(solve(da, db));

		sc.close();
	}

	static String solve(int da, int db) {
		if (da == db) {
			return String.format("%d0 %d1", da, db);
		}
		if (da + 1 == db) {
			return String.format("%d %d", da, db);
		}
		if (da == 9 && db == 1) {
			return "9 10";
		}

		return "-1";
	}
}
