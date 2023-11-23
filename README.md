# IDEA EDU course project

## Project
This is the *Amazing Numbers (Java)* project that is part of Hyperskill platform from Jetbrains Academy.

Purpose of the project is to learn Java OOP basics and to get more familiar with its ecosystem.

## Technologies

- Java 17

## Project description
Program which will provide some useful information about a natural number.

To add...

## Changelog
10.11.2023
- Ask user for number
- Check if it's natural, if not raise error
- Calculate whether number is `odd` or `even` and print message
- Check also if number is a `Buzz` number
- Print explanations regarding number being `Buzz`
- Completed stage 1

13.11.2023
- Add a new method which checks if number is a `Duck`
- A `Duck` number is any number which contains a `0` (zero)
- Added new fields to store state of each natural number, whether it's `odd/even/buzz/duck`
- Instead of all the print statements, there is one method which prints all the necessary info regarding the number object.
- Completed stage 2

13.11.2023
- Rework a bit the user input
- Added main program loop, program exits if user inputs `0`
- Added new method for checking if number is a `palindrome`
- Completed stage 3

17.11.2023
- Had to refactor majority of the code to be more object oriented as my initial solution was not progressing well the future stages
- Split functionality into different classes
- Added new method for checking if number is `Gapful`
- Completed stage 4

23.11.2023
- Adding new method for checking if number is `Spy`
- Now, in the input you can pass any property, e.g `9 3 odd` will check and return 3 numbers which are `ODD` starting from the number 9
- Added error handling to inform user on incorrect property
- Completed stage 5

23.11.2023
- Adding more input validations:
  - if property inputs have mutual exclusivity, abort the request and warn the user
  - e.g input `9 3 odd even` will fail as `odd and even` are exclusive properties
- Now program will warn the user when multiple incorrect properties are being entered.

## Project status

Completed 5/8 stages