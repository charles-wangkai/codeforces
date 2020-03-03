import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(solve(s));

        sc.close();
    }

    static String solve(String s) {
        List<List<Integer>> result = new ArrayList<>();
        while (true) {
            Deque<Integer> leftIndices = new LinkedList<>();
            Deque<Integer> rightIndices = new LinkedList<>();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    leftIndices.offerLast(i);
                } else {
                    rightIndices.offerFirst(i);
                }
            }

            boolean[] removed = new boolean[s.length()];
            List<Integer> operation = new ArrayList<>();
            while (!leftIndices.isEmpty() && !rightIndices.isEmpty()
                    && leftIndices.peekFirst() < rightIndices.peekFirst()) {
                int leftIndex = leftIndices.pollFirst();
                int rightIndex = rightIndices.pollFirst();

                operation.add(leftIndex + 1);
                operation.add(rightIndex + 1);
                removed[leftIndex] = true;
                removed[rightIndex] = true;
            }

            if (operation.isEmpty()) {
                break;
            }

            result.add(operation);

            StringBuilder rest = new StringBuilder();
            for (int i = 0; i < s.length(); ++i) {
                if (!removed[i]) {
                    rest.append(s.charAt(i));
                }
            }
            s = rest.toString();
        }

        return String.format("%d\n%s", result.size(),
                result.stream()
                        .map(op -> String.format("%d\n%s", op.size(),
                                op.stream().sorted().map(String::valueOf).collect(Collectors.joining(" "))))
                        .collect(Collectors.joining("\n")));
    }
}