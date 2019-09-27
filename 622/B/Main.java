import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String time = sc.next();
		int a = sc.nextInt();
		System.out.println(solve(time, a));

		sc.close();
	}

	static String solve(String time, int a) {
		int totalMinute = (Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3)) + a)
				% (24 * 60);

		return String.format("%02d:%02d", totalMinute / 60, totalMinute % 60);
	}
}
