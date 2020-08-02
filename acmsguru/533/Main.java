import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(solve(n));

        sc.close();
    }

    static int solve(int n) {
        int[][] diceNums = new int[n + 1][7];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(diceNums[i], -1);
        }
        diceNums[0][0] = 0;

        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(0, 0));

        while (!queue.isEmpty()) {
            Element head = queue.poll();

            if (head.sum == n) {
                return diceNums[head.sum][head.top];
            }

            for (int nextTop = 1; nextTop <= 6; ++nextTop) {
                int nextSum = (head.sum == 0) ? 21 : (head.sum - head.top + (21 - (7 - nextTop)));

                if (nextSum <= n && diceNums[nextSum][nextTop] == -1) {
                    diceNums[nextSum][nextTop] = diceNums[head.sum][head.top] + 1;
                    queue.offer(new Element(nextSum, nextTop));
                }
            }
        }

        return -1;
    }
}

class Element {
    int sum;
    int top;

    public Element(int sum, int top) {
        this.sum = sum;
        this.top = top;
    }
}