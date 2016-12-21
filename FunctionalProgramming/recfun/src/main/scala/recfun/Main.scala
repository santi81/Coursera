package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {

    if(c == 0 || c == r ) 1 else pascal(c-1, r-1) + pascal(c, r-1)
  }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
    @tailrec
    def checkIsBalanced(subString: List[Char], openCountAcc: Int) : Boolean = {
      if (subString.isEmpty) true
      else if(subString.head == '(') checkIsBalanced(subString.tail, openCountAcc + 1)
      else if(subString.head == ')') openCountAcc >0 && checkIsBalanced(subString.tail, openCountAcc - 1)
      else checkIsBalanced(subString.tail, openCountAcc)
      }
    checkIsBalanced(chars, 0)
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

    def checkSubCount(amount: Int, subset: List[Int]): Int = {

      if (amount == 0) 1
      else if (amount < 0) 0
      else if (amount > 0 && subset.length < 1) 0
      else checkSubCount(amount - subset.head, subset) + checkSubCount(amount, subset.tail)
    }
    checkSubCount(money, coins)
  }
  }
