import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		System.out.println(solve(n, t1, t2));

		sc.close();
	}

	static String solve(int n, int t1, int t2) {
		int solutionNum = 0;
		int endTime = -1;
		int endTime1 = t1;
		int endTime2 = t2;

		while (true) {
			if (endTime1 < endTime2) {
				solutionNum++;
				endTime = endTime1;

				if (solutionNum >= n) {
					solutionNum++;
					endTime = endTime2;

					break;
				}

				endTime1 += t1;
			} else if (endTime1 > endTime2) {
				solutionNum++;
				endTime = endTime2;

				if (solutionNum >= n) {
					solutionNum++;
					endTime = endTime1;

					break;
				}

				endTime2 += t2;
			} else {
				solutionNum += 2;
				endTime = endTime1;

				if (solutionNum >= n) {
					break;
				}

				endTime1 += t1;
				endTime2 += t2;
			}
		}

		return String.format("%d %d", solutionNum, endTime);
	}
}