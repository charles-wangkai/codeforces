import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b2 = sc.nextInt();

            System.out.println(solve(a1, b1, a2, b2) ? "YES" : "NO");
        }

        sc.close();
    }

    static boolean solve(int a1, int b1, int a2, int b2) {
        return (a1 == a2 && b1 + b2 == a1) || (a1 == b2 && b1 + a2 == a1) || (b1 == a2 && a1 + b2 == b1)
                || (b1 == b2 && a1 + a2 == b1);
    }
}