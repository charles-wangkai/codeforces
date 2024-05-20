import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final char[] SUITS = {'C', 'D', 'H', 'S'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      char trump = sc.next().charAt(0);
      String[] cards = new String[2 * n];
      for (int i = 0; i < cards.length; ++i) {
        cards[i] = sc.next();
      }

      System.out.println(solve(cards, trump));
    }

    sc.close();
  }

  static String solve(String[] cards, char trump) {
    Map<Character, List<Integer>> suitToRanks = new HashMap<>();
    for (char suit : SUITS) {
      suitToRanks.put(suit, new ArrayList<>());
    }
    for (String card : cards) {
      suitToRanks.get(card.charAt(1)).add(card.charAt(0) - '0');
    }
    for (List<Integer> ranks : suitToRanks.values()) {
      Collections.sort(ranks);
    }

    List<String> result = new ArrayList<>();
    int trumpIndex = 0;
    for (char suit : SUITS) {
      if (suit != trump) {
        List<Integer> ranks = suitToRanks.get(suit);

        for (int i = 0; i + 1 < ranks.size(); i += 2) {
          result.add(String.format("%d%c %d%c", ranks.get(i), suit, ranks.get(i + 1), suit));
        }

        if (ranks.size() % 2 == 1) {
          if (trumpIndex == suitToRanks.get(trump).size()) {
            return "IMPOSSIBLE";
          }

          result.add(
              String.format(
                  "%d%c %d%c",
                  ranks.get(ranks.size() - 1),
                  suit,
                  suitToRanks.get(trump).get(trumpIndex),
                  trump));
          ++trumpIndex;
        }
      }
    }

    while (trumpIndex != suitToRanks.get(trump).size()) {
      result.add(
          String.format(
              "%d%c %d%c",
              suitToRanks.get(trump).get(trumpIndex),
              trump,
              suitToRanks.get(trump).get(trumpIndex + 1),
              trump));

      trumpIndex += 2;
    }

    return String.join("\n", result);
  }
}