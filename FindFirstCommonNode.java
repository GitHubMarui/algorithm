package com.marc.tree;

/**
 * @description 问题描述：输入两个链表，找出它们的第一个公共结点。
 * 
 * @author marui
 *
 */
public class FindFirstCommonNode {
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null)
			return null;
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		int size1 = 1;
		int size2 = 1;
		while(p1.next != null ){
			p1 = p1.next;
			size1++;
		}
		while(p2.next != null){
			p2 = p2.next;
			size2++;
		}
		p1 = pHead1;
		p2 = pHead2;
		if(size1 > size2){
			for(int i = 0; i < size1 - size2; ++i){
				p1 = p1.next;
			}
		}
		else{
			for(int i = 0; i < size2 - size1; ++i){
				p2 = p2.next;
			}
		}
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;	 
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		
		node2.next = node3;
		
		System.out.println(FindFirstCommonNode(node1, node2).val);
	}
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}