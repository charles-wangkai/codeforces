import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static final char[] COLORS = { 'R', 'G', 'B' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sc.nextInt();
		String s = sc.next();
		System.out.print(solve(s));

		sc.close();
	}

	static String solve(String s) {
		Map<Character, Element> colorToElement = new HashMap<>();
		for (char currentColor : s.toCharArray()) {
			Map<Character, Element> nextColorToElement = new HashMap<>();

			for (char targetColor : COLORS) {
				int recolorNum = Integer.MAX_VALUE;
				Element prev = null;

				int additive = (targetColor == currentColor) ? 0 : 1;

				for (char prevColor : COLORS) {
					if (prevColor != targetColor) {
						if (!colorToElement.containsKey(prevColor)
								|| colorToElement.get(prevColor).recolorNum + additive < recolorNum) {
							recolorNum = (colorToElement.containsKey(prevColor)
									? (colorToElement.get(prevColor).recolorNum)
									: 0) + additive;
							prev = colorToElement.get(prevColor);
						}
					}
				}

				nextColorToElement.put(targetColor, new Element(targetColor, recolorNum, prev));
			}

			colorToElement = nextColorToElement;
		}

		Element lastElement = colorToElement.values().stream()
				.min((element1, element2) -> Integer.compare(element1.recolorNum, element2.recolorNum)).get();

		StringBuilder garland = new StringBuilder();
		for (Element e = lastElement; e != null; e = e.prev) {
			garland.append(e.color);
		}
		garland = garland.reverse();

		return String.format("%d\n%s", lastElement.recolorNum, garland.toString());
	}
}

class Element {
	char color;
	int recolorNum;
	Element prev;

	Element(char color, int recolorNum, Element prev) {
		this.color = color;
		this.recolorNum = recolorNum;
		this.prev = prev;
	}
}