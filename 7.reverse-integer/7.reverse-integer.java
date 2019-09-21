/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.48%)
 * Total Accepted:    808.1K
 * Total Submissions: 3.2M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 * 
 */
class Solution {
    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        
        if (x < 0) {
            return -reverse(-x);
        }
        
        int reverse = 0;
        int rem = 0;
        int tmp = 0;
        while (x > 0) {
            rem = x % 10;
            if (reverse != 0) {
                tmp = reverse * 10;
                // check overflow
                if (tmp/10 != reverse) return 0;
                reverse = tmp;
            }
            tmp = reverse + rem;
            // check overflow
            if (tmp-rem != reverse) return 0;
            reverse = tmp;
            x /= 10;
        }
        return reverse;
    }
}
