import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	static final int MOD_DIVISOR = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(n, k, d));

		sc.close();
	}

	static int solve(int n, int k, int d) {
		int result = 0;

		Map<State, Integer> stateToCount = new HashMap<>();
		stateToCount.put(new State(0, false), 1);

		while (!stateToCount.isEmpty()) {
			Map<State, Integer> nextStateToCount = new HashMap<>();

			for (State state : stateToCount.keySet()) {
				for (int weight = 1; weight <= k; weight++) {
					int nextWeightSum = state.weightSum + weight;
					boolean nextEnoughMaxWeight = state.enoughMaxWeight || (weight >= d);

					if (nextWeightSum < n) {
						State nextState = new State(nextWeightSum, nextEnoughMaxWeight);

						nextStateToCount.put(nextState,
								addMod(nextStateToCount.getOrDefault(nextState, 0), stateToCount.get(state)));
					} else if (nextWeightSum == n && nextEnoughMaxWeight) {
						result = addMod(result, stateToCount.get(state));
					}
				}
			}

			stateToCount = nextStateToCount;
		}

		return result;
	}

	static int addMod(int x, int y) {
		return (x + y) % MOD_DIVISOR;
	}
}

class State {
	int weightSum;
	boolean enoughMaxWeight;

	State(int weightSum, boolean enoughMaxWeight) {
		this.weightSum = weightSum;
		this.enoughMaxWeight = enoughMaxWeight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(weightSum, enoughMaxWeight);
	}

	@Override
	public boolean equals(Object obj) {
		State other = (State) obj;
		return weightSum == other.weightSum && enoughMaxWeight == other.enoughMaxWeight;
	}
}