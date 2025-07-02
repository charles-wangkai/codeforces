import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] t = new int[n];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(t));

    sc.close();
  }

  static int solve(int[] t) {
    List<Integer> rooms = new ArrayList<>();
    rooms.add(0);

    Map<Integer, Integer> roomToLastIndex = new HashMap<>();
    roomToLastIndex.put(0, 0);

    for (int ti : t) {
      if (roomToLastIndex.get(rooms.get(ti)) == ti) {
        roomToLastIndex.put(rooms.get(ti), rooms.size());
        rooms.add(rooms.get(ti));
      } else {
        int nextRoom = roomToLastIndex.size();
        roomToLastIndex.put(nextRoom, rooms.size());
        rooms.add(nextRoom);
      }
    }

    return roomToLastIndex.size();
  }
}