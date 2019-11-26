/*
 * @lc app=leetcode id=146 lang=scala
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (27.11%)
 * Total Accepted:    389.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */
import scala.collection.mutable

class LRUCache(capacity: Int) {

  private var head: Option[Node] = None
  private var tail: Option[Node] = None
  private var size = 0

  private var keysToValues: Map[Int, Int] = Map()
  private var keysToNodes: Map[Int, Node] = Map()

  def put(key: Int, value: Int): Unit = {
    if (!keysToValues.contains(key) && size == capacity) {
      removeTail()
    }

    keysToValues = keysToValues.updated(key, value)

    updateOrInsertForKey(key)
  }

  def get(key: Int): Int = {
    keysToValues.get(key) match {
      case Some(value) => {
        updateNodeForKey(key)
        value
      }
      case None => -1
    }
  }

  private class Node(val value: Int, var prev: Option[Node] = None, var next: Option[Node] = None)

  private def updateHead(node: Node): Unit = {
    head match {
      case Some(thing) if node != thing =>
        node.next = Some(thing)
        node.prev = None

        thing.prev = Some(node)
      case None =>
        tail = Some(node)
    }

    head = Some(node)
  }

  private def updateOrInsertForKey(key: Int): Unit = {
    if (keysToNodes.contains(key)) {
      updateNodeForKey(key)
    } else {
      val newNode = new Node(key)
      updateHead(newNode)

      keysToNodes = keysToNodes.updated(key, newNode)
      size += 1
    }
  }

  private def updateNodeForKey(key: Int): Unit = {
    val node = keysToNodes(key)

    if (size <= 1 || head.contains(node)) return;

    if (node.prev.isDefined) node.prev.get.next = node.next
    if (node.next.isDefined) node.next.get.prev = node.prev

    var newTail = tail
    if (tail.isDefined && node == tail.get) {
      newTail = tail.get.prev
    }

    updateHead(node)
    tail = newTail
  }

  private def removeTail(): Unit = {
    tail match {
      case Some(thing) => {
        val key = thing.value

        keysToValues = keysToValues - key
        keysToNodes = keysToNodes - key
        size -= 1

        if (thing.prev.isDefined) {
          thing.prev.get.next = None
          tail = thing.prev
        } else {
          head = None
          tail = None
        }
      }
      case None => None
    }
  }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
