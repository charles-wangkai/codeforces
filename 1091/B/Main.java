import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Vector[] obelisks = readArray(sc, n);
		Vector[] clues = readArray(sc, n);
		System.out.println(solve(obelisks, clues));

		sc.close();
	}

	static Vector[] readArray(Scanner sc, int size) {
		Vector[] result = new Vector[size];
		for (int i = 0; i < result.length; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			result[i] = new Vector(x, y);
		}
		return result;
	}

	static String solve(Vector[] obelisks, Vector[] clues) {
		Set<Vector> obeliskSet = Arrays.stream(obelisks).collect(Collectors.toSet());

		for (int i = 0;; i++) {
			Vector treasure = new Vector(obelisks[i].x + clues[0].x, obelisks[i].y + clues[0].y);

			if (Arrays.stream(clues)
					.allMatch(clue -> obeliskSet.contains(new Vector(treasure.x - clue.x, treasure.y - clue.y)))) {
				return String.format("%d %d", treasure.x, treasure.y);
			}
		}
	}
}

class Vector {
	int x;
	int y;

	Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		Vector other = (Vector) obj;
		return x == other.x && y == other.y;
	}
}