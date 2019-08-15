import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		City[] cities = new City[N];
		for (int i = 0; i < cities.length; i++) {
			int x = sc.nextInt();
			int p = sc.nextInt();

			cities[i] = new City(x, p);
		}
		System.out.println(solve(cities));

		sc.close();
	}

	static double solve(City[] cities) {
		Arrays.sort(cities, (c1, c2) -> Integer.compare(c1.x, c2.x));

		int leftCitizenSum = 0;
		int rightCitizenSum = Arrays.stream(cities).mapToInt(city -> city.p).sum();
		int stationX = cities[0].x;
		long distanceSum = Arrays.stream(cities).mapToLong(city -> (long) (city.x - cities[0].x) * city.p).sum();
		long minDistanceSum = distanceSum;

		for (int i = 1; i < cities.length; i++) {
			leftCitizenSum += cities[i - 1].p;
			rightCitizenSum -= cities[i - 1].p;

			distanceSum += (long) (cities[i].x - cities[i - 1].x) * (leftCitizenSum - rightCitizenSum);
			if (distanceSum < minDistanceSum) {
				minDistanceSum = distanceSum;
				stationX = cities[i].x;
			}
		}

		return stationX;
	}
}

class City {
	int x;
	int p;

	City(int x, int p) {
		this.x = x;
		this.p = p;
	}
}