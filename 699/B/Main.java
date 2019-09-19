import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] cells = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				cells[r][c] = line.charAt(c);
			}
		}
		System.out.print(solve(cells));

		sc.close();
	}

	static String solve(char[][] cells) {
		int n = cells.length;
		int m = cells[0].length;

		List<Point> walls = IntStream.range(0, n).boxed().flatMap(
				r -> IntStream.range(0, m).filter(c -> cells[r][c] == '*').mapToObj(c -> new Point(r + 1, c + 1)))
				.collect(Collectors.toList());

		if (walls.isEmpty()) {
			return "YES\n1 1";
		}

		Point firstWall = walls.get(0);

		int[] cCandiates = walls.stream().filter(wall -> wall.x != firstWall.x).mapToInt(wall -> wall.y).distinct()
				.toArray();
		if (cCandiates.length == 0) {
			return String.format("YES\n%d 1", firstWall.x);
		} else if (cCandiates.length == 1) {
			return String.format("YES\n%d %d", firstWall.x, cCandiates[0]);
		}

		int[] rCandidates = walls.stream().filter(wall -> wall.y != firstWall.y).mapToInt(wall -> wall.x).distinct()
				.toArray();
		if (rCandidates.length == 0) {
			return String.format("YES\n1 %d", firstWall.y);
		} else if (rCandidates.length == 1) {
			return String.format("YES\n%d %d", rCandidates[0], firstWall.y);
		}

		return "NO";
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}