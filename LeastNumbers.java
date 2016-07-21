package com.marc.string;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 * @description 题目描述:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4。
 * 
 * @author marui
 *
 */
public class LeastNumbers {
	/**
	 * 
	 * @description 思路：要求数组中最小的k个数，最容易想到的就是利用冒泡排序的思想，每一轮排序把
	 * 剩余数组中最小的一个数字放到前面已排序的后面，只要进行K轮即可
	 * 
	 * 时间复杂度为O(kn)
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
		if(input == null)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>(k);
		if(k > input.length)
			return list;
		int temp;
		for(int i = 0; i < k; i++){
			for(int j = i+1; j < input.length; j++){
				if(input[i] > input[j]){
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
			list.add(input[i]);
		}
		
		return list;
	}
	
	/**
	 * 
	 * @description 思路：利用快速排序划分的思想，每一次划分就会有一个数字位于以数组从小到达排列的的最终位置index；
	 * 位于index左边的数字都小于index对应的值，右边都大于index指向的值；
	 * 所以，当index > k-1时，表示k个最小数字一定在index的左边，此时，只需要对index的左边进行划分即可；
	 * 当index < k - 1时，说明index及index左边数字还没能满足k个数字，需要继续对k右边进行划分； 
	 * 
	 * 时间复杂度为O(n)，
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		if(input == null)
			return null;
		ArrayList<Integer> list = new ArrayList<Integer>(k);
        if(k > input.length)
            return list;
        int low = 0;
        int high = input.length - 1;
        int index = partition(input,low,high);
        while(index != k-1){
            if(index > k-1){
                high = index - 1;
            }else{
                low = index + 1;
            }
            index = partition(input,low,high);
        }
       for(int i = 0; i < k; i++){
           list.add(input[i]);
       }
        return list;
		
	}

	private int partition(int[] input, int low, int high) {
		int pivot = input[low];
        while(low < high){
            while(low < high && input[high] >= pivot) high--;
            input[low] = input[high];
            while(low < high && input[low] <= pivot) low++;
            input[high] = input[low];
        }
        input[low] = pivot; 
        return low;
	}
	
	/**
	 * 
	 * @description 思路：先创建一个大小为k的数据容器来存储最小的k个数字，从输入的n个整数中一个一个读入放入该容器中，
	 * 如果容器中的数字少于k个，按题目要求直接返回空；
	 * 如果容器中已有k个数字，而数组中还有值未加入，此时就不能直接插入了，而需要替换容器中的值。按以下步骤进行插入： 
	 * 1.先找到容器中的最大值；
	 * 2.将待查入值和最大值比较，如果待查入值大于容器中的最大值，则直接舍弃这个待查入值即可；如果待查入值小于容器中的最小值，则用这个待查入值替换掉容器中的最大值；
	 * 3.重复上述步骤，容器中最后就是整个数组的最小k个数字。
	 * 
	 * 对于这个容器的实现，可以使用最大堆的数据结构，最大堆中，根节点的值大于它的子树中的任意节点值。
	 * Java中的TreeSet类实现了红黑树的功能，它底层是通过TreeMap实现的，TreeSet中的数据会按照插入数据自动升序排列（按自然顺序）。
	 * 因此我们直接将数据依次放入到TreeSet中，数组就会自动排序。 
	 * 
	 * 时间复杂度为O(nlogn)
	 */
	public ArrayList<Integer> GetLeastNumbers_Solution3(int[] input, int k) {
		if(input == null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>(k);
        if(k > input.length)
            return list;
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(int i = 0 ; i < input.length; i++){
            tree.add(input[i]);
        }
        int i = 0;
        for(Integer elem : tree){
            if(i >= k)
                break;
            list.add(elem);
            i++;
        }
        return list;
	}
}
