import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static final Map<String, Integer> POLYHEDRON_TO_FACENUM = new HashMap<>();
	static {
		POLYHEDRON_TO_FACENUM.put("Tetrahedron", 4);
		POLYHEDRON_TO_FACENUM.put("Cube", 6);
		POLYHEDRON_TO_FACENUM.put("Octahedron", 8);
		POLYHEDRON_TO_FACENUM.put("Dodecahedron", 12);
		POLYHEDRON_TO_FACENUM.put("Icosahedron", 20);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] polyhedrons = new String[n];
		for (int i = 0; i < polyhedrons.length; i++) {
			polyhedrons[i] = sc.next();
		}
		System.out.println(solve(polyhedrons));

		sc.close();
	}

	static int solve(String[] polyhedrons) {
		return Arrays.stream(polyhedrons).mapToInt(polyhedron -> POLYHEDRON_TO_FACENUM.get(polyhedron)).sum();
	}
}
