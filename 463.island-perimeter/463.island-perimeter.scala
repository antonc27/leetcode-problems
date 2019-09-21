/*
 * @lc app=leetcode id=463 lang=scala
 *
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (61.67%)
 * Total Accepted:    148.7K
 * Total Submissions: 240.7K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e.,
 * one or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter
 * of the island.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * Output: 16
 * 
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * 
 * 
 * 
 */
object Solution {
    def islandPerimeter(grid: Array[Array[Int]]): Int = {
        val n = grid.length
        if (n == 0) return 0
        
        val m = grid(0).length
        
        def isInBounds(i: Int, j: Int): Boolean = 0 <= i && i < n && 0 <= j && j < m
        
        def isZero(i: Int, j: Int): Boolean = !isInBounds(i, j) || grid(i)(j) == 0
        
        def countPerim(i: Int, j: Int): Int = {
            (for (p <- -1 to 1; q <- -1 to 1 if p != q && p != -q)
                yield isZero(i + p, j + q)
            ).count(x => x)
        }
        
        (for (i <- 0 until n; j <- 0 until m if grid(i)(j) == 1)
            yield countPerim(i, j)
        ).sum
    }
}
