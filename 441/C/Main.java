import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		System.out.print(solve(n, m, k));

		sc.close();
	}

	static String solve(int n, int m, int k) {
		Queue<Cell> queue = new LinkedList<>();
		for (int x = 1; x <= n; x++) {
			if (x % 2 != 0) {
				for (int y = 1; y <= m; y++) {
					queue.offer(new Cell(x, y));
				}
			} else {
				for (int y = m; y >= 1; y--) {
					queue.offer(new Cell(x, y));
				}
			}
		}

		@SuppressWarnings("unchecked")
		List<Cell>[] tubes = new List[k];
		for (int i = 0; i < tubes.length; i++) {
			tubes[i] = new ArrayList<>();
		}

		for (int i = 0; i < tubes.length - 1; i++) {
			tubes[i].add(queue.poll());
			tubes[i].add(queue.poll());
		}

		while (!queue.isEmpty()) {
			tubes[tubes.length - 1].add(queue.poll());
		}

		return Arrays.stream(tubes)
				.map(tube -> String.format("%d %s", tube.size(), tube.stream()
						.map(cell -> String.format("%d %d", cell.x, cell.y)).collect(Collectors.joining(" "))))
				.collect(Collectors.joining("\n"));
	}
}

class Cell {
	int x;
	int y;

	Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
}