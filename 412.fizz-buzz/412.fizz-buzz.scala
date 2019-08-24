/*
 * @lc app=leetcode id=412 lang=scala
 *
 * [412] Fizz Buzz
 *
 * https://leetcode.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (59.97%)
 * Total Accepted:    227K
 * Total Submissions: 378.4K
 * Testcase Example:  '1'
 *
 * Write a program that outputs the string representation of numbers from 1 to
 * n.
 * 
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * 
 * Example:
 * 
 * n = 15,
 * 
 * Return:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */
object Solution {
    def fizzBuzz(n: Int): List[String] = {
        (for {
            i <- 1 to n
        } yield if (i % 15 == 0) {
                "FizzBuzz"
            } else if (i % 5 == 0) {
                "Buzz"
            } else if (i % 3 == 0) {
                "Fizz"
            } else {
                i.toString
            }).toList
}
    }
