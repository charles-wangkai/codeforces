import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int tc = 0; tc < t; ++tc) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int z2 = sc.nextInt();

            System.out.println(solve(x1, y1, z1, x2, y2, z2));
        }

        sc.close();
    }

    static int solve(int x1, int y1, int z1, int x2, int y2, int z2) {
        int posCount = Math.min(z1, y2);
        int negCount = Math.max(0, y1 - (y2 - posCount + x2));

        return (posCount - negCount) * 2;
    }
}