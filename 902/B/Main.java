import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n - 1];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println(solve(p, c));

		sc.close();
	}

	static int solve(int[] p, int[] c) {
		@SuppressWarnings("unchecked")
		List<Integer>[] childrens = new List[c.length];
		for (int i = 0; i < childrens.length; i++) {
			childrens[i] = new ArrayList<>();
		}

		for (int i = 0; i < p.length; i++) {
			childrens[p[i] - 1].add(i + 1);
		}

		return search(childrens, c, 0).stepNum;
	}

	static Element search(List<Integer>[] childrens, int[] c, int node) {
		int stepNum = 1;
		for (int child : childrens[node]) {
			Element subResult = search(childrens, c, child);

			stepNum += subResult.stepNum + ((subResult.color == c[node]) ? -1 : 0);
		}

		return new Element(c[node], stepNum);
	}
}

class Element {
	int color;
	int stepNum;

	Element(int color, int stepNum) {
		this.color = color;
		this.stepNum = stepNum;
	}
}