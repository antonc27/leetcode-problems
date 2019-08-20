/*
 * @lc app=leetcode id=1 lang=scala
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (44.42%)
 * Total Accepted:    2M
 * Total Submissions: 4.6M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 */
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    	def twoSumRec(numsList: List[Int], index: Int, map: Map[Int, Int]): Array[Int] = numsList match {
	    case Nil => Array()
	    case n :: ns => if (map.contains(n)) {
	    	 Array(map(n), index)
	    } else {
	         val newMap = map + (target - n -> index)
		 twoSumRec(ns, index + 1, newMap)
	    }
	}
	twoSumRec(nums.toList, 0, Map())
    }
}
