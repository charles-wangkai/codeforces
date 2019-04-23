import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] doors = new int[n];
		for (int i = 0; i < doors.length; i++) {
			doors[i] = sc.nextInt();
		}
		System.out.println(solve(doors));

		sc.close();
	}

	static int solve(int[] doors) {
		return Math.min(findLast(doors, 0), findLast(doors, 1)) + 1;
	}

	static int findLast(int[] doors, int target) {
		for (int i = doors.length - 1;; i--) {
			if (doors[i] == target) {
				return i;
			}
		}
	}
}
