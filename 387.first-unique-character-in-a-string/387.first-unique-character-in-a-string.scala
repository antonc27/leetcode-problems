/*
 * @lc app=leetcode id=387 lang=scala
 *
 * [387] First Unique Character in a String
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 *
 * algorithms
 * Easy (50.61%)
 * Total Accepted:    312.4K
 * Total Submissions: 617.3K
 * Testcase Example:  '"leetcode"'
 *
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * 
 * 
 * 
 * 
 * Note: You may assume the string contain only lowercase letters.
 * 
 */
object Solution {
    def firstUniqChar(s: String): Int = {
        def buildMap(s: List[Char], map: Map[Char, Int]): Map[Char, Int] = s match {
            case Nil => map
            case c :: xc => 
                buildMap(xc, map updated (c, map.getOrElse(c, 0) + 1))
        }
        
        val map = buildMap(s.toList, Map())
        
        def find(s: List[Char], index: Int): Int = s match {
            case Nil => -1
            case c :: xc =>
                if (map(c) == 1) {
                    index
                } else {
                    find(xc, index + 1)
                }
        }
        
        find(s.toList, 0)
    }
}
