# NQueens
This program displays all the solutions to the n-queens problem

![](http://1.bp.blogspot.com/-X1gkzwx3954/Ve0vDCYKFII/AAAAAAAAASQ/7Q80vjSavqc/s1600/NQueensBacktractExplaination.png)

## Backstory
(From [Wikipedia](https://en.wikipedia.org/wiki/Eight_queens_puzzle)) The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other; thus, a solution requires that no two queens share the same row, column, or diagonal.

The eight queens puzzle is an example of the more general n queens problem of placing n non-attacking queens on an n×n chessboard, for which solutions exist for all natural numbers n with the exception of n = 2 and n = 3.

## Usage
This program takes the argument n, which indicates the size of the chessboard and the ammount of queens to be placed. The result is the ammount of unique solutions to a board of that size.

The program also takes an optional argument -v (Full usage: `java Queens -v [n]` ). This prints the positions of all queens for every possible solution.

## Context
I originally started this project in my data structures class (my only school-related repo on this github account), and have since modified it to not only find the ammount of solutions, but also display each one in verbose mode (-v). I am pretty interested in the logic behind it and plan on expanding on this project to add functionality for various chess pieces.
