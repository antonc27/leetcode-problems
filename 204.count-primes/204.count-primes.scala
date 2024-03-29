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
    	if (n == 0) return 0;
	
	var isPrime = Array.fill[Boolean](n)(true)
	isPrime(0) = false
	isPrime(n - 1) = false

	var nextPrime = 2
	while (nextPrime != 0 && nextPrime * nextPrime < n) {
	    (nextPrime * nextPrime until n by nextPrime).foreach { p =>
	         isPrime(p - 1) = false
	    }
	    val nextPrimeIdx = isPrime.drop(nextPrime).indexWhere(x => x)
	    nextPrime = if (nextPrimeIdx == -1) {
	    	0
	    } else {
	        nextPrime + nextPrimeIdx + 1
	    }
	}
        
	isPrime.count(x => x)
    }
}
