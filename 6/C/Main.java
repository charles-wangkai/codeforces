import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int n = sc.nextInt();
	int[] t = new int[n];
	for (int i = 0; i < t.length; i++) {
	    t[i] = sc.nextInt();
	}
	System.out.println(solve(t));

	sc.close();
    }

    static String solve(int[] t) {
	int leftIndex = -1;
	int rightIndex = t.length;
	int leftTime = 0;
	int rightTime = 0;
	while (leftIndex + 1 != rightIndex) {
	    leftIndex++;
	    leftTime += t[leftIndex];

	    while (rightIndex != leftIndex + 1 && rightTime < leftTime) {
		rightIndex--;
		rightTime += t[rightIndex];
	    }
	}

	return String.format("%d %d", leftIndex + 1, t.length - rightIndex);
    }
}
