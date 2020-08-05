import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] X = new int[M];
        int[] Y = new int[M];
        int[] C = new int[M];
        for (int i = 0; i < M; ++i) {
            X[i] = sc.nextInt() - 1;
            Y[i] = sc.nextInt() - 1;
            C[i] = sc.nextInt();
        }

        System.out.println(solve(N, X, Y, C));

        sc.close();
    }

    static int solve(int N, int[] X, int[] Y, int[] C) {
        @SuppressWarnings("unchecked")
        List<Integer>[] edgeList = new List[N];
        for (int i = 0; i < edgeList.length; ++i) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < X.length; ++i) {
            edgeList[X[i]].add(i);
        }

        int[][] distances = new int[N][4];
        for (int i = 0; i < distances.length; ++i) {
            Arrays.fill(distances[i], -1);
        }
        distances[0][0] = 0;

        Queue<Element> queue = new LinkedList<>();
        queue.offer(new Element(0, 0));

        while (!queue.isEmpty()) {
            Element head = queue.poll();
            if (head.node == N - 1) {
                return distances[head.node][head.color];
            }

            for (int edge : edgeList[head.node]) {
                if (C[edge] != head.color && distances[Y[edge]][C[edge]] == -1) {
                    distances[Y[edge]][C[edge]] = distances[head.node][head.color] + 1;
                    queue.offer(new Element(Y[edge], C[edge]));
                }
            }
        }

        return -1;
    }
}

class Element {
    int node;
    int color;

    Element(int node, int color) {
        this.node = node;
        this.color = color;
    }
}