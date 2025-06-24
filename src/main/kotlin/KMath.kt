import java.math.BigInteger
import kotlin.math.abs

/**
 * An improved, pure Kotlin math utility library.
 *
 * This version enhances the original by:
 * - Using extension functions for a more fluent, idiomatic API on collections and numbers.
 * - Handling edge cases more robustly (e.g., empty lists, zero/negative inputs).
 * - Improving the efficiency of algorithms like Fibonacci and factorial.
 * - Providing more accurate results for statistical functions like mode.
 * - Leveraging BigInteger to prevent overflow in calculations like factorial.
 *
 * @author Gemini (Revised)
 * @version 2.0
 */

//================================================================================
// MAIN KMath OBJECT - For standalone algorithmic functions
//================================================================================

object KMath {

    /**
     * Calculates the Greatest Common Divisor (GCD) of two integers using the Euclidean algorithm.
     * Handles zero and negative inputs correctly by operating on absolute values.
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the absolute values of a and b.
     */
    fun gcd(a: Long, b: Long): Long {
        var num1 = abs(a)
        var num2 = abs(b)
        while (num2 != 0L) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }
        return num1
    }

    /**
     * Calculates the Least Common Multiple (LCM) of two integers.
     * @param a The first integer.
     * @param b The second integer.
     * @return The LCM of a and b. Returns 0 if either a or b is 0.
     */
    fun lcm(a: Long, b: Long): Long {
        if (a == 0L || b == 0L) return 0L
        return abs(a * b) / gcd(a, b)
    }

    /**
     * Generates the nth Fibonacci number using an efficient iterative approach.
     * This avoids the performance issues of the recursive implementation.
     * @param n The position in the Fibonacci sequence (0-based).
     * @return The nth Fibonacci number as a BigInteger to support large values.
     * @throws IllegalArgumentException if n is negative.
     */
    fun fibonacci(n: Int): BigInteger {
        require(n >= 0) { "Fibonacci position must be non-negative." }
        if (n <= 1) return n.toBigInteger()

        var a = BigInteger.ZERO
        var b = BigInteger.ONE
        for (i in 2..n) {
            val sum = a + b
            a = b
            b = sum
        }
        return b
    }
}

//================================================================================
// EXTENSION FUNCTIONS
//================================================================================

// --- Collection Extensions (Statistics) ---

/**
 * Calculates the average (mean) of a collection of numbers.
 * @return The average as a Double.
 * @throws IllegalArgumentException if the collection is empty.
 */
fun <T : Number> Collection<T>.average(): Double {
    require(this.isNotEmpty()) { "Cannot calculate average of an empty collection." }
    return this.sumOf { it.toDouble() } / this.size
}

/**
 * Calculates the median of a collection of numbers.
 * @return The median as a Double.
 * @throws IllegalArgumentException if the collection is empty.
 */
fun <T : Number> Collection<T>.median(): Double {
    require(this.isNotEmpty()) { "Cannot calculate median of an empty collection." }

    val sortedList = this.map { it.toDouble() }.sorted()
    val middle = sortedList.size / 2

    return if (sortedList.size % 2 == 1) {
        sortedList[middle]
    } else {
        (sortedList[middle - 1] + sortedList[middle]) / 2.0
    }
}

/**
 * Finds the mode(s) (most frequent values) in a collection.
 * This version correctly returns all modes if there's a tie.
 * @return A list containing the most frequent element(s). Returns an empty list if the collection is empty.
 */
fun <T> Collection<T>.mode(): List<T> {
    if (this.isEmpty()) return emptyList()

    val frequencyMap = this.groupingBy { it }.eachCount()
    val maxFrequency = frequencyMap.values.maxOrNull()
        ?: return emptyList() // Should not happen if not empty, but safe

    return frequencyMap.filter { it.value == maxFrequency }.keys.toList()
}


// --- Number Extensions ---

/**
 * Calculates the factorial of a non-negative integer using BigInteger to prevent overflow.
 * @return The factorial as a BigInteger.
 * @throws IllegalArgumentException if the number is negative.
 */
fun Int.factorial(): BigInteger {
    require(this >= 0) { "Factorial is not defined for negative numbers." }
    var result = BigInteger.ONE
    for (i in 2..this) {
        result = result.multiply(i.toBigInteger())
    }
    return result
}

/**
 * Checks if an integer is a prime number.
 * The implementation is optimized for efficiency.
 * @return True if the number is prime, false otherwise.
 */
fun Int.isPrime(): Boolean {
    // Basic checks
    if (this <= 1) return false
    if (this <= 3) return true
    if (this % 2 == 0 || this % 3 == 0) return false

    // Check divisibility for numbers of the form 6k +/- 1 up to sqrt(n)
    var i = 5
    while (i * i <= this) {
        if (this % i == 0 || this % (i + 2) == 0) return false
        i += 6
    }
    return true
}

/**
 * A safe power function for integers that returns a BigInteger to avoid overflow.
 * @param exponent The exponent (must be non-negative).
 * @return The result of the base raised to the exponent.
 */
fun Int.power(exponent: Int): BigInteger {
    require(exponent >= 0) { "Exponent must be non-negative." }
    return this.toBigInteger().pow(exponent)
}

/**
 * Generates a random integer within a range (inclusive).
 * @param max The maximum value of the range.
 * @return A random integer between this number and max.
 */
fun Int.randomInRange(max: Int): Int {
    require(max >= this) { "Max must be greater than or equal to min." }
    return (this..max).random()
}
