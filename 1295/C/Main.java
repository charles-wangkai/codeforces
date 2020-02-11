import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 0; tc < T; ++tc) {
            String s = sc.next();
            String t = sc.next();

            System.out.println(solve(s, t));
        }

        sc.close();
    }

    static int solve(String s, String t) {
        Map<Character, List<Integer>> letterToIndices = buildLetterToIndices(s);

        int result = 0;
        int beginIndex = Integer.MAX_VALUE;
        for (char letter : t.toCharArray()) {
            if (!letterToIndices.containsKey(letter)) {
                return -1;
            }

            List<Integer> indices = letterToIndices.get(letter);
            int index = Collections.binarySearch(indices, beginIndex);
            if (index < 0) {
                index = -1 - index;
            }

            if (index == indices.size()) {
                ++result;
                beginIndex = indices.get(0) + 1;
            } else {
                beginIndex = indices.get(index) + 1;
            }
        }

        return result;
    }

    static Map<Character, List<Integer>> buildLetterToIndices(String s) {
        Map<Character, List<Integer>> letterToIndices = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char letter = s.charAt(i);

            if (!letterToIndices.containsKey(letter)) {
                letterToIndices.put(letter, new ArrayList<>());
            }

            letterToIndices.get(letter).add(i);
        }

        return letterToIndices;
    }
}