import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		Container[] containers = new Container[m];
		for (int i = 0; i < containers.length; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			containers[i] = new Container(a, b);
		}
		System.out.println(solve(n, containers));

		sc.close();
	}

	static int solve(int n, Container[] containers) {
		Arrays.sort(containers, (c1, c2) -> -Integer.compare(c1.b, c2.b));

		int result = 0;
		for (Container container : containers) {
			int count = Math.min(n, container.a);
			result += count * container.b;

			n -= count;
		}

		return result;
	}
}

class Container {
	int a;
	int b;

	Container(int a, int b) {
		this.a = a;
		this.b = b;
	}
}