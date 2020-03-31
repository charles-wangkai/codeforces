import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(solve(a, b, c, d, x, y, x1, y1, x2, y2) ? "Yes" : "No");
        }

        sc.close();
    }

    static boolean solve(int a, int b, int c, int d, int x, int y, int x1, int y1, int x2, int y2) {
        return check(a, b, x, x1, x2) && check(c, d, y, y1, y2);
    }

    static boolean check(int negStep, int posStep, int v0, int minV, int maxV) {
        if (negStep < posStep) {
            return v0 + (posStep - negStep) <= maxV;
        } else if (negStep > posStep) {
            return v0 - (negStep - posStep) >= minV;
        } else {
            return minV != v0 || maxV != v0 || (negStep == 0 && posStep == 0);
        }
    }
}