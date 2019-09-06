import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String commands = sc.next();
		System.out.println(solve(commands));

		sc.close();
	}

	static int solve(String commands) {
		return Math.min(count(commands, 'U'), count(commands, 'D')) * 2
				+ Math.min(count(commands, 'L'), count(commands, 'R')) * 2;
	}

	static int count(String commands, char command) {
		return (int) commands.chars().filter(ch -> ch == command).count();
	}
}
