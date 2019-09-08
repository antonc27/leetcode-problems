/*
 * @lc app=leetcode id=202 lang=scala
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (46.42%)
 * Total Accepted:    261.9K
 * Total Submissions: 564.2K
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 
 * 
 * 
 * Input: 19
 * Output: true
 * Explanation: 
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 
 */
object Solution {
    def isHappy(n: Int): Boolean = {
        def happy(n: Int, cycle: Set[Int]): Boolean = {
        if (n > 999) {
            happy(squareDigits(n), cycle)
        } else if (n == 1) {
            true
        } else if (cycle.contains(n)) {
            false
        } else {
            val next = squareDigits(n)
            happy(next, cycle + n)
        }
    }
        happy(n, Set())
    }
    
    def squareDigits(a: Int): Int = {
        if (a <= 9) {
            a * a
        } else {
            val rem = a % 10
            rem * rem + squareDigits(a / 10)
        }
    }
}
