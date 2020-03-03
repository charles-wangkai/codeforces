import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] r = readArray(sc, n);
        int[] b = readArray(sc, n);
        System.out.println(solve(r, b));

        sc.close();
    }

    static int[] readArray(Scanner sc, int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = sc.nextInt();
        }

        return result;
    }

    static int solve(int[] r, int[] b) {
        int countR = (int) IntStream.range(0, r.length).filter(i -> r[i] == 1 && b[i] == 0).count();
        int countB = (int) IntStream.range(0, r.length).filter(i -> r[i] == 0 && b[i] == 1).count();

        return (countR == 0) ? -1 : divideToCeil(countB + 1, countR);
    }

    static int divideToCeil(int x, int y) {
        return x / y + (x % y == 0 ? 0 : 1);
    }
}