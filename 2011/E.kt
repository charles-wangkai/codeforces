import java.util.Scanner

val MOVE_TO_INDEX = mapOf('R' to 0, 'P' to 1, 'S' to 2)

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()
    for (tc in 0 until t) {
        val s = sc.next()

        println(solve(s))
    }

    sc.close()
}

fun solve(s: String): Int {
    return if (s[0] == 'R') {
        computeRoundNum(s)
    } else {
        listOf(
            computeRoundNum("R$s"),
            computeRoundNum("RS$s"),
            computeRoundNum("RP$s"),
            computeRoundNum("RPS$s"),
            computeRoundNum("RSP$s")
        ).minOrNull() ?: Int.MAX_VALUE
    }
}

fun computeRoundNum(s: String): Int {
    var diff = 0
    for (i in 0 until s.length - 1) {
        val delta = (MOVE_TO_INDEX[s[i + 1]]!! - MOVE_TO_INDEX[s[i]]!!).mod(3)
        when (delta) {
            2 -> diff++
            0 -> diff--
        }
    }

    return maxOf(s.length, s.length - diff)
}
