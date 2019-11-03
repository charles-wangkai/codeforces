import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static final String[] RODS = { "O-|-OOOO", "O-|O-OOO", "O-|OO-OO", "O-|OOO-O", "O-|OOOO-", "-O|-OOOO", "-O|O-OOO",
	    "-O|OO-OO", "-O|OOO-O", "-O|OOOO-" };

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();
	System.out.println(solve(n));

	sc.close();
    }

    static String solve(int n) {
	return new StringBuilder(String.valueOf(n)).reverse().chars().mapToObj(ch -> RODS[ch - '0'])
		.collect(Collectors.joining("\n"));
    }
}
