/*
 * @lc app=leetcode id=53 lang=scala
 *
 * [53] Maximum Subarray
 *
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (44.28%)
 * Total Accepted:    601.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * Example:
 * 
 * 
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Follow up:
 * 
 * If you have figured out the O(n) solution, try coding another solution using
 * the divide and conquer approach, which is more subtle.
 * 
 */
object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
    	//dac(nums, 0, nums.length - 1)

	val initSum = nums(0)
	val list = nums.slice(1, nums.length).toList
	linear(list, initSum, initSum)
    }

    def linear(nums: List[Int], sumIn: Int, sumLeft: Int): Int = nums match {
    	case Nil => sumIn
	case x :: xs => {
	     val newSumLeft = math.max(x, sumLeft + x)
	     linear(xs, math.max(sumIn, newSumLeft), newSumLeft)
	}
    }

    def dac(nums: Array[Int], left: Int, right: Int): Int = {
    	if (left == right) {
	   nums(left)
	} else {
	  val mid = (left + right) / 2
	  val maxLeft = dac(nums, left, mid)
	  val maxRight = dac(nums, mid+1, right)

	  def growLeft(currIdx: Int, currSum: Int): Int = {
	      if (currIdx < left) {
	      	currSum
	      } else {
	      	val sum = nums(currIdx) + currSum
		val recSum = growLeft(currIdx-1, sum)
		max(currSum, sum, recSum)
	      }
	  }

	  def growRight(currIdx: Int, currSum: Int): Int = {
	      if (currIdx > right) {
	      	currSum
	      } else {
	      	val sum = nums(currIdx) + currSum
		val recSum = growRight(currIdx+1, sum)
		max(currSum, sum, recSum)
	      }
	  }
	  
	  val maxComb = growLeft(mid-1, nums(mid)) + growRight(mid+2, nums(mid+1))

	  max(maxLeft, maxRight, maxComb)
	}
    }

    def max(a: Int, b: Int, c: Int) = math.max(math.max(a,b),c)
}
