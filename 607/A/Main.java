import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Beacon[] beacons = new Beacon[n];
		for (int i = 0; i < beacons.length; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			beacons[i] = new Beacon(a, b);
		}
		System.out.println(solve(beacons));

		sc.close();
	}

	static int solve(Beacon[] beacons) {
		int n = beacons.length;

		Arrays.sort(beacons, (beacon1, beacon2) -> Integer.compare(beacon1.a, beacon2.a));

		int[] remainNums = new int[n];
		for (int i = 0; i < remainNums.length; i++) {
			int index = Arrays.binarySearch(beacons, new Beacon(beacons[i].a - beacons[i].b - 1, -1),
					(beacon1, beacon2) -> Integer.compare(beacon1.a, beacon2.a));
			if (index < 0) {
				index = -1 - index - 1;
			}

			remainNums[i] = ((index == -1) ? 0 : remainNums[index]) + 1;
		}

		return n - Arrays.stream(remainNums).max().getAsInt();
	}
}

class Beacon {
	int a;
	int b;

	Beacon(int a, int b) {
		this.a = a;
		this.b = b;
	}
}