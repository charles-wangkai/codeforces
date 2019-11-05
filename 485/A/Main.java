import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int a = sc.nextInt();
	int m = sc.nextInt();
	System.out.println(solve(a, m) ? "Yes" : "No");

	sc.close();
    }

    static boolean solve(int a, int m) {
	boolean[] seen = new boolean[m];

	int remainder = a % m;
	while (remainder != 0) {
	    if (seen[remainder]) {
		return false;
	    }

	    seen[remainder] = true;
	    remainder = remainder * 2 % m;
	}

	return true;
    }
}
