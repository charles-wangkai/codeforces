import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String seating = sc.next();
		System.out.println(solve(seating) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(String seating) {
		return !seating.contains("11") && !('0' + seating + '0').contains("000");
	}
}
