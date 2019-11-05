import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int q = sc.nextInt();
	for (int tc = 0; tc < q; tc++) {
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    int n = sc.nextInt();
	    int S = sc.nextInt();

	    System.out.println(solve(a, b, n, S) ? "YES" : "NO");
	}

	sc.close();
    }

    static boolean solve(int a, int b, int n, int S) {
	int x = Math.min(a, S / n);

	return S - x * n <= b;
    }
}
