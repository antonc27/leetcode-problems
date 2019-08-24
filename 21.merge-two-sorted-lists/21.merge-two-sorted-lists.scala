/*
 * @lc app=leetcode id=21 lang=scala
 *
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (48.46%)
 * Total Accepted:    656.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * Example:
 * 
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
        def mergeRec(list1: ListNode, list2: ListNode, start: ListNode, end: ListNode): ListNode = {
	    (list1, list2) match {
	    	 case (null, null) => start
		 case (l, null) => append(start, end, l)
		 case (null, l) => append(start, end, l)
		 case (l1, l2) => if (l1.x <= l2.x) {
		     val l1Next = l1.next
		     l1.next = null
		     val newStart = append(start, end, l1)
		     mergeRec(l1Next, l2, newStart, l1)
		 } else {
		     mergeRec(l2, l1, start, end)
		 }
	    }
	}
	mergeRec(l1, l2, null, null)
    }

    def append(start: ListNode, end: ListNode, appendee: ListNode) = {
    	if (end == null) {
	   appendee
	} else {
	   end.next = appendee
	   start
	}
    }
}
