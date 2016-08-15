import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class MyTree {
	public static void main(String[] args) {
		int curSum = 0;
		LinkedList list = new LinkedList();
		
		Tree node1 = new Tree(5);
		Tree node2 = new Tree(4);
		Tree node3 = new Tree(8);
		Tree node4 = new Tree(11);
		Tree node5 = new Tree(13);
		Tree node6 = new Tree(4);
		Tree node7 = new Tree(7);
		Tree node8 = new Tree(2);
		Tree node9 = new Tree(5);
		Tree node10 = new Tree(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		node3.left = node5;
		node3.right = node6;
		node6.left = node9;
		node6.right = node10;
		
		getPath(node1, 22, curSum, list);
		
		
		
	}
	
	private static void getPath(Tree root, int target, int curSum, LinkedList list){
		if(root == null)
			return;
		
		curSum += root.data;
		list.add(root.data);
		
		if(root.left == null && root.right == null && curSum == target){
			System.out.println("Path");
			Iterator iterator = list.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next() + " ");
			}
		}
		
		if(root.left != null)
			getPath(root.left, target, curSum, list);
		if(root.right != null)
			getPath(root.right, target, curSum, list);
		curSum -= root.data;
		list.pollLast();
	}
	
}
