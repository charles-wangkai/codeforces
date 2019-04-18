import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] grades = new int[n][m];
		for (int i = 0; i < n; i++) {
			String line = sc.next();

			for (int j = 0; j < m; j++) {
				grades[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(solve(grades));

		sc.close();
	}

	static int solve(int[][] grades) {
		int n = grades.length;
		int m = grades[0].length;

		int maxSubjectGrades[] = IntStream.range(0, m)
				.map(j -> IntStream.range(0, n).map(i -> grades[i][j]).max().getAsInt()).toArray();

		return (int) IntStream.range(0, n)
				.filter(i -> IntStream.range(0, m).anyMatch(j -> grades[i][j] == maxSubjectGrades[j])).count();
	}
}
