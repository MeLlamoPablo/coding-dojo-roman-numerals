fun main(args: Array<String>) {
    assert(1, "I")
    assert(2, "II")
    assert(3, "III")
    assert(4, "IV")
    assert(5, "V")
    assert(6, "VI")
    assert(7, "VII")
    assert(8, "VIII")
    assert(9, "IX")
    assert(10, "X")
    assert(11, "XI")
    assert(12, "XII")
    assert(13, "XIII")
    assert(14, "XIV")
    assert(15, "XV")
    assert(16, "XVI")
    assert(17, "XVII")
    assert(18, "XVIII")
    assert(19, "XIX")
    assert(20, "XX")
    assert(50, "L")
}

val LETTERS = listOf("I", "V", "X", "L")

fun arabicToRoman(i: Int, depth: Int = 0): String {
    return when (i) {
        in 1..3 -> LETTERS[depth].repeat(i)
        else -> when (i) {
            4 -> "${arabicToRoman(5 - i)}${LETTERS[depth + 1]}"
            5 -> LETTERS[depth + 1]
            in 6..8 -> "${LETTERS[depth + 1]}${arabicToRoman(i - 5)}"
            else -> when (i) {
                9 -> "${arabicToRoman(10 - i)}${LETTERS[depth + 2]}"
                10 -> LETTERS[depth + 2]

                else -> when (i) {
                    9 -> "${arabicToRoman(10 - i)}${LETTERS[depth + 2]}"
                    50 -> LETTERS[depth + 3]
                    else -> "${LETTERS[depth + 2]}${arabicToRoman(i - 10)}"
                }
            }

        }

    }
}

private fun assert(i: Int, s: String) {
    val roman = arabicToRoman(i)
    println(
        "$i " + (if (roman == s) "PASSES" else "FAILS (Expected: $s - got: $roman)")
    )
}