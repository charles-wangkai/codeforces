import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int a = sc.nextInt();
	int b = sc.nextInt();
	int c = sc.nextInt();
	System.out.println(solve(a, b, c));

	sc.close();
    }

    static int solve(int a, int b, int c) {
	boolean[] seen = new boolean[b];
	int remainder = a;
	int result = 1;
	while (true) {
	    int digit = remainder * 10 / b;
	    if (digit == c) {
		return result;
	    }

	    remainder = remainder * 10 % b;
	    if (seen[remainder]) {
		return -1;
	    }

	    seen[remainder] = true;
	    result++;
	}
    }
}
