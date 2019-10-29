// https://cs.stackexchange.com/questions/64137/how-many-range-are-completely-inside-a-given-range/64190#64190

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int m = Integer.parseInt(br.readLine());
		int[] l = new int[m];
		int[] r = new int[m];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(solve(s, l, r));
	}

	static String solve(String s, int[] l, int[] r) {
		List<Range> ranges = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				if (!stack.empty()) {
					ranges.add(new Range(stack.pop(), i));
				}
			}
		}

		Collections.sort(ranges, (r1, r2) -> Integer.compare(r1.begin, r2.begin));

		int[] begins = ranges.stream().mapToInt(range -> range.begin).toArray();
		Node root = buildMergeSortTree(ranges.stream().mapToInt(range -> range.end).toArray(), 0, ranges.size() - 1);

		int[] result = new int[l.length];
		for (int i = 0; i < result.length; i++) {
			int minIndex = findMinIndex(begins, l[i] - 1);
			if (minIndex == -1) {
				continue;
			}

			int rangeNum = computeNum(root, r[i] - 1, minIndex, begins.length - 1);

			result[i] = rangeNum * 2;
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
	}

	static int findMinIndex(int[] begins, int minBegin) {
		int result = -1;
		int lowerIndex = 0;
		int upperIndex = begins.length - 1;
		while (lowerIndex <= upperIndex) {
			int middleIndex = (lowerIndex + upperIndex) / 2;

			if (begins[middleIndex] >= minBegin) {
				result = middleIndex;

				upperIndex = middleIndex - 1;
			} else {
				lowerIndex = middleIndex + 1;
			}
		}

		return result;
	}

	static Node buildMergeSortTree(int[] values, int minIndex, int maxIndex) {
		if (minIndex > maxIndex) {
			return null;
		}

		Node node = new Node(minIndex, maxIndex);

		if (minIndex == maxIndex) {
			node.sortedValues[0] = values[minIndex];
		} else {
			int middleIndex = (minIndex + maxIndex) / 2;

			node.left = buildMergeSortTree(values, minIndex, middleIndex);
			node.right = buildMergeSortTree(values, middleIndex + 1, maxIndex);

			int index = 0;
			int leftIndex = 0;
			int rightIndex = 0;
			while (leftIndex != node.left.sortedValues.length || rightIndex != node.right.sortedValues.length) {
				int value;
				if (rightIndex == node.right.sortedValues.length || (leftIndex != node.left.sortedValues.length
						&& node.left.sortedValues[leftIndex] <= node.right.sortedValues[rightIndex])) {
					value = node.left.sortedValues[leftIndex];
					leftIndex++;
				} else {
					value = node.right.sortedValues[rightIndex];
					rightIndex++;
				}

				node.sortedValues[index] = value;
				index++;
			}
		}

		return node;
	}

	static int computeNum(Node node, int value, int targetMinIndex, int targetMaxIndex) {
		if (targetMinIndex > node.maxIndex || targetMaxIndex < node.minIndex) {
			return 0;
		} else if (targetMinIndex <= node.minIndex && targetMaxIndex >= node.maxIndex) {
			return computeLessEqualNum(node.sortedValues, value);
		} else {
			return computeNum(node.left, value, targetMinIndex, targetMaxIndex)
					+ computeNum(node.right, value, targetMinIndex, targetMaxIndex);
		}
	}

	static int computeLessEqualNum(int[] sortedValues, int value) {
		int index = -1;
		int lowerIndex = 0;
		int upperIndex = sortedValues.length - 1;
		while (lowerIndex <= upperIndex) {
			int middleIndex = (lowerIndex + upperIndex) / 2;

			if (sortedValues[middleIndex] <= value) {
				index = middleIndex;

				lowerIndex = middleIndex + 1;
			} else {
				upperIndex = middleIndex - 1;
			}
		}

		return index + 1;
	}
}

class Range {
	int begin;
	int end;

	Range(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
}

class Node {
	int minIndex;
	int maxIndex;
	int[] sortedValues;
	Node left;
	Node right;

	Node(int minIndex, int maxIndex) {
		this.minIndex = minIndex;
		this.maxIndex = maxIndex;
		sortedValues = new int[maxIndex - minIndex + 1];
	}
}