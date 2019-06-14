import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		System.out.println(solve(N, M));

		sc.close();
	}

	static String solve(int N, int M) {
		try {
			return String.valueOf(LocalDate.of(2001, M, N).getDayOfWeek().getValue());
		} catch (DateTimeException e) {
			return "Impossible";
		}
	}
}
