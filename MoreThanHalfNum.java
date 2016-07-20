package com.marc.string;

/**
 * @description 题目描述:数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 
 * @author marui
 *
 */

public class MoreThanHalfNum {
	public static int MoreThanHalfNum_Solution(int [] array) {
		if(array.length == 0)
			return 0;
		int count = 0;
		int num = 0;
		for(int i = 0; i < array.length; i++){
			if(count == 0){
				num = array[i];
				count++;
			}else{
				if(array[i] != num){
					count--;
				}else{
					count++;
				}
			}
		}
		
		count = 0;
        //检查该值是否有效
		for(int i = 0; i < array.length; i++){
			if(array[i] == num)
				count++;
		}
		
		if(count * 2 <= array.length)
			return 0;
		
		return num;
		
    }
	
	public static void main(String[] args) {
		int[] array = new int[]{1,2,3,2,4,2,5,2,3};
		System.out.println(MoreThanHalfNum_Solution(array));
	}
}
