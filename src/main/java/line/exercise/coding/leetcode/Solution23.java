package line.exercise.coding.leetcode;

import line.exercise.coding.leetcode.struct.ListNode;

/**
 * 直接把所有的链表合并到lists[0]，则第一个链表中的元素会有重复遍历的问题，时间复杂度较高。
 * 考虑使用增量k增加的归并合并方法:
 * k=1, lists[1]->lists[0]; lists[3]->lists[2] ...
 * k=2, lists[2]->lists[0]; ...
 * 需要考虑到奇数长度的情况。
 * 
 * @author line
 * @date 2019年2月11日 下午7:51:33
 */
public class Solution23 {
	public ListNode mergeKLists(ListNode[] lists) {
		int len = lists.length;
		if (lists == null || len == 0)
			return null;
		if (len == 1)
			return lists[0];

		for (int k = 1; k < lists.length; k = k << 1) {
			mergeK(lists, k);
		}

		return lists[0];
	}

	private void mergeK(ListNode[] list, int k) {
		for (int i = 0; i < list.length && i + k < list.length; i = i + k + k) {
			ListNode into = list[i];
			ListNode from = list[i + k];
			list[i] = merge2(into, from);
		}
	}

	/**
	 * 递归合并两个链表left和right
	 */
	private ListNode merge2(ListNode l, ListNode r) {
		if (l == null)
			return r;
		if (r == null)
			return l;

		ListNode head = null;
		if (l.val <= r.val) {
			head = l;
			head.next = merge2(head.next, r);
		} else {
			head = r;
			head.next = merge2(l, head.next);
		}
		return head;
	}
}
