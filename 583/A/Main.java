import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Intersection[] intersections = new Intersection[n * n];
		for (int i = 0; i < intersections.length; i++) {
			int h = sc.nextInt();
			int v = sc.nextInt();

			intersections[i] = new Intersection(h, v);
		}
		System.out.println(String.join(" ", solve(intersections).stream().map(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static List<Integer> solve(Intersection[] intersections) {
		Set<Integer> historyH = new HashSet<>();
		Set<Integer> historyV = new HashSet<>();

		List<Integer> days = new ArrayList<>();
		for (int i = 0; i < intersections.length; i++) {
			if (!historyH.contains(intersections[i].h) && !historyV.contains(intersections[i].v)) {
				days.add(i + 1);

				historyH.add(intersections[i].h);
				historyV.add(intersections[i].v);
			}
		}
		return days;
	}
}

class Intersection {
	int h;
	int v;

	Intersection(int h, int v) {
		this.h = h;
		this.v = v;
	}
}