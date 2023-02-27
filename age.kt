// Version: 1.0

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main() {
    println("Enter your date of birth (format: DD/MM/YYYY): ")
    val inputDate = readLine() ?: ""

    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val birthDate = try {
        LocalDate.parse(inputDate, dateFormatter)
    } catch (ex: Exception) {
        println("Invalid date format. Please enter date in the format DD/MM/YYYY.")
        return
    }

    val age = ChronoUnit.YEARS.between(birthDate, LocalDate.now())
    println("You are $age years old.")

    val nextBirthday = birthDate.withYear(LocalDate.now().year)
            .takeIf { it.isAfter(LocalDate.now()) } ?: birthDate.withYear(LocalDate.now().year + 1)

    val daysToBirthday = ChronoUnit.DAYS.between(LocalDate.now(), nextBirthday)
    println("There are $daysToBirthday days until your next birthday.")

}

// Version: 1.0.2
// Here's an optimized version of the program in Kotlin:
// Changes made:
// Used LocalDate and ChronoUnit classes from java.time package instead of java.util.Calendar class, 
// which are more modern and recommended for date-time calculations in Java/Kotlin.
// Used try-catch block to catch DateTimeParseException instead of checking date format manually.
// Calculated age and days to next birthday using ChronoUnit.YEARS.between and ChronoUnit.DAYS.between methods respectively instead of manual calculation.
// Reduced code duplication by calculating thisYearBirthday only once and using it to calculate nextBirthday.

import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun main() {
    print("Enter your date of birth (format: DD/MM/YYYY): ")
    val inputDate = readLine()

    val birthDate = try {
        LocalDate.parse(inputDate, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    } catch (e: Exception) {
        println("Invalid date format. Please enter date in the format DD/MM/YYYY.")
        return
    }

    val age = ChronoUnit.YEARS.between(birthDate, LocalDate.now())
    println("You are $age years old.")

    val thisYearBirthday = LocalDate.of(LocalDate.now().year, birthDate.month, birthDate.dayOfMonth)
    val nextBirthday = if (thisYearBirthday < LocalDate.now()) thisYearBirthday.plusYears(1) else thisYearBirthday
    val daysToNextBirthday = ChronoUnit.DAYS.between(LocalDate.now(), nextBirthday)
    println("There are $daysToNextBirthday days until your next birthday.")
}
