import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Domino[] dominos = new Domino[N];
		for (int i = 0; i < dominos.length; i++) {
			int leftSide = sc.nextInt();
			int rightSide = sc.nextInt();

			dominos[i] = new Domino(leftSide, rightSide);
		}
		System.out.print(solve(dominos));

		sc.close();
	}

	static String solve(Domino[] dominos) {
		Map<Integer, List<Integer>> nodeToDominoIndices = new HashMap<>();
		for (int i = 0; i < dominos.length; i++) {
			if (!nodeToDominoIndices.containsKey(dominos[i].leftSide)) {
				nodeToDominoIndices.put(dominos[i].leftSide, new ArrayList<>());
			}
			if (!nodeToDominoIndices.containsKey(dominos[i].rightSide)) {
				nodeToDominoIndices.put(dominos[i].rightSide, new ArrayList<>());
			}

			nodeToDominoIndices.get(dominos[i].leftSide).add(i);
			nodeToDominoIndices.get(dominos[i].rightSide).add(i);
		}

		if (!hasSolution(dominos, nodeToDominoIndices)) {
			return "No solution";
		}

		int beginNode = findBeginNode(nodeToDominoIndices);

		List<String> arrangement = new ArrayList<>();
		search(arrangement, dominos, nodeToDominoIndices, new HashSet<>(), beginNode);

		return arrangement.stream().collect(Collectors.joining("\n"));
	}

	static void search(List<String> arrangement, Domino[] dominos, Map<Integer, List<Integer>> nodeToDominoIndices,
			Set<Integer> removedDominoIndices, int node) {
		int[] nextDominoIndices = nodeToDominoIndices.get(node).stream()
				.filter(dominoIndex -> !removedDominoIndices.contains(dominoIndex)).mapToInt(x -> x).toArray();

		for (int nextDominoIndex : nextDominoIndices) {
			if (nextDominoIndices.length == 1
					|| !isBridge(dominos, nodeToDominoIndices, removedDominoIndices, node, nextDominoIndex)) {
				removedDominoIndices.add(nextDominoIndex);

				arrangement.add(String.format("%d %c", nextDominoIndex + 1,
						(dominos[nextDominoIndex].leftSide == node) ? '+' : '-'));

				search(arrangement, dominos, nodeToDominoIndices, removedDominoIndices,
						getNextNode(node, dominos[nextDominoIndex]));

				break;
			}
		}
	}

	static boolean isBridge(Domino[] dominos, Map<Integer, List<Integer>> nodeToDominoIndices,
			Set<Integer> removedDominoIndices, int sourceNode, int dominoIndex) {
		int beforeRemovalReachableNodeNum = computeReachableNodeNum(dominos, nodeToDominoIndices, removedDominoIndices,
				sourceNode);

		removedDominoIndices.add(dominoIndex);
		int afterRemovalReachableNodeNum = computeReachableNodeNum(dominos, nodeToDominoIndices, removedDominoIndices,
				sourceNode);
		removedDominoIndices.remove(dominoIndex);

		return beforeRemovalReachableNodeNum != afterRemovalReachableNodeNum;
	}

	static boolean hasSolution(Domino[] dominos, Map<Integer, List<Integer>> nodeToDominoIndices) {
		return nodeToDominoIndices.values().stream().filter(dominoIndices -> dominoIndices.size() % 2 != 0).count() <= 2
				&& computeReachableNodeNum(dominos, nodeToDominoIndices, new HashSet<>(),
						nodeToDominoIndices.keySet().iterator().next()) == nodeToDominoIndices.size();
	}

	static int computeReachableNodeNum(Domino[] dominos, Map<Integer, List<Integer>> nodeToDominoIndices,
			Set<Integer> removedDominoIndices, int sourceNode) {
		Set<Integer> reachableNodes = new HashSet<>();
		dfs(reachableNodes, dominos, nodeToDominoIndices, removedDominoIndices, sourceNode);

		return reachableNodes.size();
	}

	static int getNextNode(int currentNode, Domino domino) {
		return (domino.leftSide == currentNode) ? domino.rightSide : domino.leftSide;
	}

	static void dfs(Set<Integer> reachableNodes, Domino[] dominos, Map<Integer, List<Integer>> nodeToDominoIndices,
			Set<Integer> removedDominoIndices, int node) {
		if (reachableNodes.contains(node)) {
			return;
		}

		reachableNodes.add(node);

		for (int dominoIndex : nodeToDominoIndices.get(node)) {
			if (removedDominoIndices.contains(dominoIndex)) {
				continue;
			}

			dfs(reachableNodes, dominos, nodeToDominoIndices, removedDominoIndices,
					getNextNode(node, dominos[dominoIndex]));
		}
	}

	static int findBeginNode(Map<Integer, List<Integer>> nodeToDominoIndices) {
		int[] oddDegreedNodes = nodeToDominoIndices.keySet().stream()
				.filter(node -> nodeToDominoIndices.get(node).size() % 2 != 0).mapToInt(x -> x).toArray();

		if (oddDegreedNodes.length != 0) {
			return oddDegreedNodes[0];
		} else {
			return nodeToDominoIndices.keySet().iterator().next();
		}
	}
}

class Domino {
	int leftSide;
	int rightSide;

	Domino(int leftSide, int rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
}