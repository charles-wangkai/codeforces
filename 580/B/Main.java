import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		Friend[] friends = new Friend[n];
		for (int i = 0; i < friends.length; i++) {
			int money = sc.nextInt();
			int friendship = sc.nextInt();

			friends[i] = new Friend(money, friendship);
		}
		System.out.println(solve(friends, d));

		sc.close();
	}

	static long solve(Friend[] friends, int d) {
		Arrays.sort(friends, (friend1, friend2) -> Integer.compare(friend1.money, friend2.money));

		long result = -1;
		long friendshipSum = 0;
		int leftIndex = 0;
		for (int rightIndex = 0; rightIndex < friends.length; rightIndex++) {
			friendshipSum += friends[rightIndex].friendship;

			while (friends[rightIndex].money - friends[leftIndex].money >= d) {
				friendshipSum -= friends[leftIndex].friendship;
				leftIndex++;
			}

			result = Math.max(result, friendshipSum);
		}
		return result;
	}
}

class Friend {
	int money;
	int friendship;

	Friend(int money, int friendship) {
		this.money = money;
		this.friendship = friendship;
	}
}