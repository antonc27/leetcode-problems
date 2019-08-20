/*
 * @lc app=leetcode id=206 lang=scala
 *
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (56.27%)
 * Total Accepted:    655K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Reverse a singly linked list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * 
 * 
 * Follow up:
 * 
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
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
    def reverseList(head: ListNode): ListNode = {
	//reverseListRec(head, null)
	reverseListIter(head)
    }

    def reverseListRec(curr: ListNode, reversed: ListNode): ListNode = curr match {
	    case null => reversed
	    case _ => {
	    	 var node = new ListNode(curr.x)
		 node.next = reversed
		 reverseListRec(curr.next, node)
	    }
	}

    def reverseListIter(head: ListNode): ListNode = {
    	var curr: ListNode = head
	var reversed: ListNode = null
	while (curr != null) {
	    var node = curr.next
	    curr.next = reversed
	    reversed = curr
	    curr = node
	}
	reversed
    }
}
