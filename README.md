## Here's an example program in Swift that calculates a person's age and the number of days until their next birthday:

## This program will prompt the user for their date of birth, and then it will calculate current age, the day of the week you were born on, and the number of days until your next birthday.

## To use the program, simply run it in a Android Studio, Intelli-J IDE or vscode editor environment and follow the prompts.

# Version: 1.0.2
## Here's an optimized version of the program in Kotlin:
## Changes made:
## Used LocalDate and ChronoUnit classes from java.time package instead of java.util.Calendar class, which are more modern and recommended for date-time calculations in Java/Kotlin. Used try-catch block to catch DateTimeParseException instead of checking date format manually. Calculated age and days to next birthday using ChronoUnit.YEARS.between and ChronoUnit.DAYS.between methods respectively instead of manual calculation. Reduced code duplication by calculating thisYearBirthday only once and using it to calculate nextBirthday.


## Ray C. Turner


