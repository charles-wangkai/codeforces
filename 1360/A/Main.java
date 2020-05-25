import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(solve(a, b));
        }

        sc.close();
    }

    static int solve(int a, int b) {
        return Math.min(Math.min(computeSquareArea(a + a, b), computeSquareArea(a + b, Math.max(a, b))),
                computeSquareArea(a, b + b));
    }

    static int computeSquareArea(int side1, int side2) {
        int size = Math.max(side1, side2);

        return size * size;
    }
}