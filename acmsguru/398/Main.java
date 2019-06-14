import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int x = sc.nextInt();
		int[][] friends = new int[N + 1][];
		for (int i = 1; i < friends.length; i++) {
			int d = sc.nextInt();
			friends[i] = new int[d];
			for (int j = 0; j < friends[i].length; j++) {
				friends[i][j] = sc.nextInt();
			}
		}
		System.out.print(solve(friends, x));

		sc.close();
	}

	static String solve(int[][] friends, int x) {
		boolean[] friendsOfFriend = new boolean[friends.length];

		for (int friend : friends[x]) {
			for (int friendOfFriend : friends[friend]) {
				friendsOfFriend[friendOfFriend] = true;
			}
		}

		friendsOfFriend[x] = false;
		for (int friend : friends[x]) {
			friendsOfFriend[friend] = false;
		}

		int[] friendNumbersOfFriend = IntStream.range(0, friendsOfFriend.length).filter(i -> friendsOfFriend[i])
				.toArray();
		return String.format("%d\n%s", friendNumbersOfFriend.length,
				Arrays.stream(friendNumbersOfFriend).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
