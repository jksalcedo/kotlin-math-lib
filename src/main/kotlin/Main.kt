fun main() {
    println("KMath Object Functions")

    // GCD (Greatest Common Divisor)
    val gcd1 = KMath.gcd(48, 18)
    println("GCD of 48 and 18: $gcd1") // Expected: 6
    val gcd2 = KMath.gcd(0, 100)
    println("GCD of 0 and 100: $gcd2") // Expected: 100
    val gcd3 = KMath.gcd(-48, 18)
    println("GCD of -48 and 18: $gcd3") // Expected: 6

    // LCM (Least Common Multiple)
    val lcm1 = KMath.lcm(12, 15)
    println("LCM of 12 and 15: $lcm1") // Expected: 60
    val lcm2 = KMath.lcm(7, 13)
    println("LCM of 7 and 13: $lcm2") // Expected: 91
    val lcm3 = KMath.lcm(0, 5)
    println("LCM of 0 and 5: $lcm3") // Expected: 0

    // Fibonacci
    val fib0 = KMath.fibonacci(0)
    println("Fibonacci(0): $fib0") // Expected: 0
    val fib1 = KMath.fibonacci(1)
    println("Fibonacci(1): $fib1") // Expected: 1
    val fib10 = KMath.fibonacci(10)
    println("Fibonacci(10): $fib10") // Expected: 55
    val fib50 = KMath.fibonacci(50)
    println("Fibonacci(50): $fib50") // Expected: 12586269025


    println("\n--- Collection Extension Functions (Statistics) ---")

    val numbers = listOf(10, 20, 30, 40, 50)
    val mixedNumbers = listOf(5.5, 10, 2.5, 7.0)
    val oddNumbers = listOf(1, 3, 5, 7, 9)
    val evenNumbers = listOf(2, 4, 6, 8)
    val dataWithMode = listOf(1, 2, 2, 3, 4, 4, 4, 5, 5, 6)
    val dataWithMultipleModes = listOf(1, 2, 2, 3, 4, 4, 5)
    val emptyList = emptyList<Int>()

    // Average
    println("Average of $numbers: ${numbers.average()}") // Expected: 30.0
    println("Average of $mixedNumbers: ${mixedNumbers.average()}") // Expected: 6.25

    // Median
    println("Median of $numbers: ${numbers.median()}") // Expected: 30.0
    println("Median of $oddNumbers: ${oddNumbers.median()}") // Expected: 5.0
    println("Median of $evenNumbers: ${evenNumbers.median()}") // Expected: 5.0 ( (4+6)/2 )

    // Mode
    println("Mode of $dataWithMode: ${dataWithMode.mode()}") // Expected: [4]
    println("Mode of $dataWithMultipleModes: ${dataWithMultipleModes.mode()}") // Expected: [2, 4]
    println("Mode of $emptyList: ${emptyList.mode()}") // Expected: []


    println("\n--- Number Extension Functions ---")

    // Factorial
    val fact0 = 0.factorial()
    println("Factorial of 0: $fact0") // Expected: 1
    val fact5 = 5.factorial()
    println("Factorial of 5: $fact5") // Expected: 120
    val fact20 = 20.factorial()
    println("Factorial of 20: $fact20") // Expected: 2432902008176640000 (BigInteger)

    // isPrime
    println("Is 7 prime? ${7.isPrime()}") // Expected: true
    println("Is 1 prime? ${1.isPrime()}") // Expected: false
    println("Is 10 prime? ${10.isPrime()}") // Expected: false
    println("Is 2 prime? ${2.isPrime()}") // Expected: true
    println("Is 29 prime? ${29.isPrime()}") // Expected: true
    println("Is 97 prime? ${97.isPrime()}") // Expected: true

    // Power
    val pow23 = 2.power(3)
    println("2 to the power of 3: $pow23") // Expected: 8
    val pow105 = 10.power(5)
    println("10 to the power of 5: $pow105") // Expected: 100000
    val powNeg22 = (-2).power(2)
    println("-2 to the power of 2: $powNeg22") // Expected: 4

    // Random In Range
    val minVal = 10
    val maxVal = 20
    println("Random integer between $minVal and $maxVal (inclusive): ${minVal.randomInRange(maxVal)}")
    println("Random integer between $minVal and $maxVal (inclusive): ${minVal.randomInRange(maxVal)}")
    println("Random integer between $minVal and $maxVal (inclusive): ${minVal.randomInRange(maxVal)}")

    // Example of error handling (uncomment to test)

    try {
        emptyList.average()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}") // Expected: Cannot calculate average of an empty collection.
    }

    try {
        (-5).factorial()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}") // Expected: Factorial is not defined for negative numbers.
    }

    try {
        10.randomInRange(5)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}") // Expected: Max must be greater than or equal to min.
    }

}
