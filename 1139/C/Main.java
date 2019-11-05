import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();
	int k = sc.nextInt();
	int[] u = new int[n - 1];
	int[] v = new int[n - 1];
	int[] x = new int[n - 1];
	for (int i = 0; i < n - 1; i++) {
	    u[i] = sc.nextInt();
	    v[i] = sc.nextInt();
	    x[i] = sc.nextInt();
	}
	System.out.println(solve(u, v, x, k));

	sc.close();
    }

    static int solve(int[] u, int[] v, int[] x, int k) {
	int n = u.length + 1;

	int[] parents = new int[n];
	Arrays.fill(parents, -1);

	for (int i = 0; i < x.length; i++) {
	    if (x[i] == 0) {
		int root1 = findRoot(parents, u[i] - 1);
		int root2 = findRoot(parents, v[i] - 1);

		if (root1 != root2) {
		    parents[root2] = root1;
		}
	    }
	}

	Map<Integer, Integer> rootToCount = new HashMap<>();
	for (int i = 0; i < n; i++) {
	    int root = findRoot(parents, i);

	    rootToCount.put(root, rootToCount.getOrDefault(root, 0) + 1);
	}

	int result = powMod(n, k);
	for (int count : rootToCount.values()) {
	    result = subtractMod(result, powMod(count, k));
	}

	return result;
    }

    static int findRoot(int[] parents, int node) {
	int root = node;
	while (parents[root] != -1) {
	    root = parents[root];
	}

	int p = node;
	while (p != root) {
	    int next = parents[p];
	    parents[p] = root;

	    p = next;
	}

	return root;
    }

    static int powMod(int base, int exponent) {
	int result = 1;
	for (int i = 0; i < exponent; i++) {
	    result = multiplyMod(result, base);
	}

	return result;
    }

    static int subtractMod(int x, int y) {
	return (x - y + MODULUS) % MODULUS;
    }

    static int multiplyMod(int x, int y) {
	return (int) ((long) x * y % MODULUS);
    }
}
