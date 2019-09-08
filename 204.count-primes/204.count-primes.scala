/*
 * @lc app=leetcode id=204 lang=scala
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.76%)
 * Total Accepted:    265.2K
 * Total Submissions: 891.2K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
object Solution {
    def countPrimes(n: Int): Int = {
        var nums = (2 until n).toList
        
        for(i <- 2 to math.sqrt(n).toInt) {
            nums = nums.filter(j => !(j > i && j % i == 0))
            }
        
        nums.length
    }
}
