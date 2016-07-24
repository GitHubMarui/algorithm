package com.marc.num;

import java.net.DatagramPacket;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.text.html.MinimalHTMLWriter;

/**
 * @description 题目描述:把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 
 * @author marui
 *
 */
public class UglyNumber {
	/**
	 * 思路：因为已有的丑数是按顺序存在数组中的。对乘以2而言，肯定存在某一个丑数T2，排在它之前的每一个丑数乘以2得到的
	 * 结果都会小于已有最大的丑数，在它之后的每一个丑数乘以2得到的结果都会太大。我们只需要记下这个丑数的位置，同时每次
	 * 生成新的丑数的时候，去更新这个T2。对乘以3和5而言，存在着同样的T3和T5。
	 */
	public static int GetUglyNumber_Solution(int index) {
		if(index == 0)
            return 0;
		
		int[] data = new int[index];
		for(int i = 0; i < index; i++)
			data[i] = 0;
		data[0] = 1;
		
		int num_2 = 0;
		int num_3 = 0;
		int num_5 = 0;
		
		int n = 1;
		
		while(n < index){
			data[n] = min(data[num_2]*2, data[num_3]*3, data[num_5]*5);
			while(data[num_2]*2 <= data[n])
				num_2++;
			while(data[num_3]*3 <= data[n])
				num_3++;
			while(data[num_5]*5 <= data[n])
				num_5++;
			n++;
		}
		
        return data[index-1];
    }

	private static int min(int i, int j, int k) {
		int t = i < j ? i : j;
		return t < k ? t : k;
	}
	
	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(100));
	}
	
}
