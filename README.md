# IDEA EDU course project

## Project
This is the *Amazing Numbers (Java)* project that is part of Hyperskill platform from Jetbrains Academy.

Purpose of the project is to learn Java OOP basics and to get more familiar with its ecosystem.

## Technologies

- Java 17

## Project description
Program which will provide some useful information about a natural number.

How to run: 
### Examples

Main menu
```shell
Supported requests:
- enter a natural number to know its properties;
- enter two natural numbers to obtain the properties of the list:
  * the first parameter represents a starting number;
  * the second parameter shows how many consecutive numbers are to be printed;
- two natural numbers and properties to search for;
- a property preceded by minus must not be present in numbers;
- separate the parameters with one space;
- enter 0 to exit.
```

Example 1
```shell
Enter a request: 5

Properties of 5
        even: false
        odd: true
        buzz: false
        duck: false
        palindromic: true
        gapful: false
        spy: true
        square: false
        sunny: false
        jumping: true
        happy: false
        sad: true
        
Enter a request: 1 10

               1 is odd, palindromic, spy, square, jumping, happy
               2 is even, palindromic, spy, jumping, sad
               3 is odd, palindromic, spy, sunny, jumping, sad
               4 is even, palindromic, spy, square, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
               8 is even, palindromic, spy, sunny, jumping, sad
               9 is odd, palindromic, spy, square, jumping, sad
              10 is even, duck, jumping, happy

Enter a request: 1 5 -odd

               2 is even, palindromic, spy, jumping, sad
               4 is even, palindromic, spy, square, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               8 is even, palindromic, spy, sunny, jumping, sad
              10 is even, duck, jumping, happy

Enter a request: 1 5 -even

               1 is odd, palindromic, spy, square, jumping, happy
               3 is odd, palindromic, spy, sunny, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
               9 is odd, palindromic, spy, square, jumping, sad

Enter a request: 1 5 -odd -even gapful

The request contains mutually exclusive properties: [-ODD, -EVEN]
There are no numbers with these properties.

Enter a request: 1 5 odd square -odd

The request contains mutually exclusive properties: [-ODD, ODD]
There are no numbers with these properties.

Enter a request: 1 5 sunny square

The request contains mutually exclusive properties: [SQUARE, SUNNY]
There are no numbers with these properties.

Enter a request: 1 5 -sunny -square

               2 is even, palindromic, spy, jumping, sad
               5 is odd, palindromic, spy, jumping, sad
               6 is even, palindromic, spy, jumping, sad
               7 is odd, buzz, palindromic, spy, jumping, happy
              10 is even, duck, jumping, happy
```


## Project status
Completed 8/8 stages