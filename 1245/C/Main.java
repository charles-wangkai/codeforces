import java.util.Scanner;

public class Main {
    static final int MODULUS = 1_000_000_007;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	String s = sc.next();
	System.out.println(solve(s));

	sc.close();
    }

    static int solve(String s) {
	int[] wayNums = new int[s.length() + 1];
	wayNums[0] = 1;
	for (int i = 1; i < wayNums.length; i++) {
	    if (s.charAt(i - 1) == 'w' || s.charAt(i - 1) == 'm') {
		wayNums[i] = 0;
	    } else {
		wayNums[i] = wayNums[i - 1];

		if (i != 1 && (s.substring(i - 2, i).equals("uu") || s.substring(i - 2, i).equals("nn"))) {
		    wayNums[i] = addMod(wayNums[i], wayNums[i - 2]);
		}
	    }
	}

	return wayNums[s.length()];
    }

    static int addMod(int x, int y) {
	return (x + y) % MODULUS;
    }
}
