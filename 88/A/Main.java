import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "B", "H"};
  static final Map<String, Integer> NOTE_TO_INDEX =
      IntStream.range(0, NOTES.length).boxed().collect(Collectors.toMap(i -> NOTES[i], i -> i));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] chord = new String[3];
    for (int i = 0; i < chord.length; ++i) {
      chord[i] = sc.next();
    }

    System.out.println(solve(chord));

    sc.close();
  }

  static String solve(String[] chord) {
    Arrays.sort(chord, Comparator.comparing(NOTE_TO_INDEX::get));
    int[] distances =
        IntStream.range(0, chord.length)
            .map(i -> computeDistance(chord[i], chord[(i + 1) % chord.length]))
            .toArray();

    if (IntStream.range(0, distances.length)
        .anyMatch(i -> distances[i] == 4 && distances[(i + 1) % distances.length] == 3)) {
      return "major";
    }
    if (IntStream.range(0, distances.length)
        .anyMatch(i -> distances[i] == 3 && distances[(i + 1) % distances.length] == 4)) {
      return "minor";
    }

    return "strange";
  }

  static int computeDistance(String note1, String note2) {
    int result = NOTE_TO_INDEX.get(note2) - NOTE_TO_INDEX.get(note1);
    if (result < 0) {
      result += NOTES.length;
    }

    return result;
  }
}