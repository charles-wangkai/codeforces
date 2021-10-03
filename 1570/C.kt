import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in a.indices) {
        a[i] = sc.nextInt()
    }
    println(solve(a))
    sc.close()
}

fun solve(a: IntArray): String {
    val elements = IntStream.range(0, a.size).mapToObj { i: Int -> Element(i, a[i]) }
        .sorted { e1: Element, e2: Element -> Integer.compare(e2.value, e1.value) }
        .toArray<Element> { size -> arrayOfNulls<Element>(size) }
    return String.format("%d\n%s", IntStream.range(0, elements.size).map { i: Int -> i * elements[i].value + 1 }
        .sum(),
        Arrays.stream(elements).map { element: Element -> (element.index + 1).toString() }
            .collect(Collectors.joining(" ")))
}

internal class Element(var index: Int, var value: Int)