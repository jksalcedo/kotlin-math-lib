# kotlin-math-lib - A Kotlin Math Utility Library
[![Made with Google Gemini](https://img.shields.io/badge/Made%20with-Google%20Gemini-blue?logo=google)](https://ai.google.dev/gemini)

kotlin-math-lib is a pure Kotlin JVM math utility library designed to provide common mathematical and statistical functions. It leverages Kotlin's idiomatic features and java.math.BigInteger to handle large number calculations safely, preventing overflow.

This library is ideal for any JVM-based Kotlin project, including Android applications, desktop applications, or server-side services, requiring robust mathematical computations.

## Features

- **Core Arithmetic**: Functions for Greatest Common Divisor (GCD) and Least Common Multiple (LCM).
- **Number Sequences**: Efficient iterative calculation of Fibonacci numbers, supporting large values using BigInteger.
- **Factorial & Power**: Calculate factorials and powers for integers, returning BigInteger to handle large results and prevent overflow.
- **Prime Number Check**: Optimized function to determine if an integer is prime.
- **Statistical Functions (Collection Extensions)**:
  - average(): Calculates the mean of a collection of numbers.
  - median(): Finds the median of a collection.
  - mode(): Identifies the most frequent value(s), supporting multiple modes.
- **Random Generation**: Generate random integers within a specified range.
- **BigInteger Integration**: Directly uses java.math.BigInteger for accurate large number arithmetic.

## Installation

Add the JitPack repository to your project's settings.gradle.kts (or settings.gradle):

```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_NON_DECLARED_REPOSITORIES)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' } // Add this line
        maven { url = uri("https://jitpack.io")} // For .kts
    }
}
```

Then, add the kotlin-math-lib dependency to your module's build.gradle.kts (or build.gradle):

```kotlin
// app/build.gradle.kts (or your JVM project's build.gradle.kts)
dependencies {
    implementation("com.github.jksalcedo:kotlin-math-lib:1.0.0")
    // No other special dependencies needed for basic kotlin-math-lib functions
}
```

## Usage

The kotlin-math-lib library provides functions through its KMath object and as extension functions on Collection and Int types.

### KMath Object Functions

```kotlin
import com.jksalcedo.kotlinmathlib.KMath

fun main() {
    // GCD (Greatest Common Divisor)
    println("GCD of 48 and 18: ${KMath.gcd(48, 18)}") // Output: 6
    println("GCD of 0 and 100: ${KMath.gcd(0, 100)}") // Output: 100

    // LCM (Least Common Multiple)
    println("LCM of 12 and 15: ${KMath.lcm(12, 15)}")   // Output: 60
    println("LCM of 0 and 5: ${KMath.lcm(0, 5)}")       // Output: 0

    // Fibonacci (returns BigInteger for large numbers)
    println("Fibonacci(10): ${KMath.fibonacci(10)}")     // Output: 55
    println("Fibonacci(50): ${KMath.fibonacci(50)}")     // Output: 12586269025
}
```

### Collection Extension Functions (Statistics)

```kotlin
import com.jksalcedo.kotlinmathlib.average
import com.jksalcedo.kotlinmathlib.median
import com.jksalcedo.kotlinmathlib.mode

fun main() {
    val numbers = listOf(10, 20, 30, 40, 50)
    val mixedNumbers = listOf(5.5, 10, 2.5, 7.0)
    val dataWithMultipleModes = listOf(1, 2, 2, 3, 4, 4, 5)
    val emptyList = emptyList<Int>()

    // Average
    println("Average of $numbers: ${numbers.average()}") // Output: 30.0

    // Median
    println("Median of [1, 3, 5, 7, 9]: ${listOf(1, 3, 5, 7, 9).median()}") // Output: 5.0
    println("Median of [2, 4, 6, 8]: ${listOf(2, 4, 6, 8).median()}")     // Output: 5.0

    // Mode
    println("Mode of [1, 2, 2, 3, 4, 4, 4, 5, 5, 6]: ${listOf(1, 2, 2, 3, 4, 4, 4, 5, 5, 6).mode()}") // Output: [4]
    println("Mode of $dataWithMultipleModes: ${dataWithMultipleModes.mode()}") // Output: [2, 4]
    println("Mode of empty list: ${emptyList.mode()}") // Output: []
}
```

### Number Extension Functions

```kotlin
import com.jksalcedo.kotlinmathlib.factorial
import com.jksalcedo.kotlinmathlib.isPrime
import com.jksalcedo.kotlinmathlib.power
import com.jksalcedo.kotlinmathlib.randomInRange

fun main() {
    // Factorial (returns BigInteger)
    println("Factorial of 5: ${5.factorial()}")   // Output: 120
    println("Factorial of 20: ${20.factorial()}") // Output: 2432902008176640000

    // isPrime
    println("Is 7 prime? ${7.isPrime()}")       // Output: true
    println("Is 10 prime? ${10.isPrime()}")     // Output: false
    println("Is 97 prime? ${97.isPrime()}")     // Output: true

    // Power (returns BigInteger)
    println("2 to the power of 3: ${2.power(3)}")     // Output: 8
    println("10 to the power of 5: ${10.power(5)}")   // Output: 100000

    // Random In Range
    val minVal = 10
    val maxVal = 20
    println("Random integer between $minVal and $maxVal (inclusive): ${minVal.randomInRange(maxVal)}")
}
```

## Limitations

- **JVM-Specific**: This library is built for the Java Virtual Machine (JVM). It utilizes java.math.BigInteger, which is part of the Java Standard Library. Therefore, it is not directly compatible with non-JVM platforms like Kotlin/Native (e.g., iOS) or Kotlin/JS without an additional compatibility layer or a different BigInteger implementation for those targets.
- **No Android UI Components**: This is a pure Kotlin library focusing on mathematical logic. It does not contain any Android UI components (Views, Activities, etc.).
- **Floating-Point Precision**: While BigInteger handles large integers accurately, statistical functions like average() and median() return Double. Be mindful of standard floating-point precision limitations for extremely large or very small decimal numbers.

## Contributing

Contributions are always welcome! Feel free to open issues for bug reports or feature requests, or submit pull requests with improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
