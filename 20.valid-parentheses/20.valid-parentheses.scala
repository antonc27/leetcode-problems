/*
 * @lc app=leetcode id=20 lang=scala
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (37.06%)
 * Total Accepted:    669.6K
 * Total Submissions: 1.8M
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * 
 * Input: "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: "{[]}"
 * Output: true
 * 
 * 
 */
object Solution {
    def isValid(s: String): Boolean = {
        val brackets = Map('(' -> ')', '{' -> '}', '[' -> ']')

	def check(str: List[Char], stack: List[Char]): Boolean = {
	    str match {
	    	case Nil => stack.isEmpty
		case c :: xc => {
		     if (brackets.contains(c)) {
		     	check(xc, c :: stack)
		     } else if (!stack.isEmpty && brackets(stack.head) == c) {
		       check(xc, stack.tail)
		     } else {
		       false
		     }
		}
	    }
	}

	check(s.toList, List())
    }
}
