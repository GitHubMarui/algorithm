package com.marc.num;

/**
 * @description 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007 
 * 输入描述：题目保证输入的数组中没有的相同的数
 * 数据范围：对于%50的数据,size<=10^4，对于%75的数据,size<=10^5，对于%100的数据,size<=2*10^5
 * 
 * 输入例子：1,2,3,4,5,6,7,0
 * 输出例子：7
 * 
 * @author marui
 *
 */
public class InversePairs {
	
	/**
	 * 
	 * 思路：把数组分解成两个长度为2的子数组，先用两个指针分别指向两个子数组的末尾，并每次比较两个指针指向的数字。
	 * 如果第一个子数组中的数字大于第二个子数组中的数字，则构成逆序对，并且逆序对的数目等于第二个子数组中剩余数字的个数。
	 * 如果第一个数组中的数字小于或等于第二个数组中的数字，则不构成逆序对。一次比较的时候，我们都把较大的数字从后往前复制
	 * 到一个辅助数组中去，确保辅助数组中的数字是递增排序的。在把较大的数字复制到辅助数组之后，把对应的指针向前移动一位，接下来进行下一轮比较。 
	 */
	public int InversePairs(int [] array) {
		if(array == null || array.length < 1)
			return 0;
		int[] copy = new int[array.length];
		System.arraycopy(array, 0, copy, 0, array.length);
		
        return inversePairsCore(array, copy, 0, array.length-1);
    }

	private int inversePairsCore(int[] array, int[] copy, int start, int end) {
		if(start >= end){
			copy[start] = array[start];
			return 0;
		}
		int mid = (end - start)/2;
		int left = inversePairsCore(array, copy, start, start + mid);
		int right = inversePairsCore(array, copy, start+mid+1, end);
		
		int i = mid;// 前半段的最后一个数字的下标
		int j = end; // 后半段最后一个数字的下标
		int indexCopy = end;// 开始拷贝的位置
		int count = 0;// 逆序数对
		
		while(i >= start && j >= mid+1){
			if(array[i] > array[j]){
				copy[indexCopy--] = array[i--];
				count += (j - mid);
			}else{
				copy[indexCopy--] = array[j--];
			}
		}
		
		while(i >= start){
			copy[indexCopy--] = array[i--];
		}
		while(j >= mid+1){
			copy[indexCopy--] = array[j--];
		}
		
		return (count + left + right);
	}
}
