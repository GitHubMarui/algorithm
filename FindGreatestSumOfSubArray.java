package com.marc.string;

/**
 * @description 题目描述:HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 * 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
 * @author marui
 *
 */
public class FindGreatestSumOfSubArray {
	//动态规划问题
	public int FindGreatestSumOfSubArray(int[] array) {
		if(array.length == 0)
			return 0;
		int sum = array[0];		//当前最大的子向量元素和
		int tmpSum = array[0];	//tmpSum如果小于0，子向量重新开始。
		for(int i = 1; i < array.length; ++i){
			tmpSum = tmpSum < 0 ? array[i]:array[i] + tmpSum;
			sum = Math.max(tmpSum, sum);
		}
		return sum;   
    }
}