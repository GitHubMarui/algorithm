package com.marc.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description 问题描述：给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 
 * 输入：整数N，后续N个名字
 * N个字符串，每个表示一个名字
 * 输出：每个名称可能的最大漂亮程度
 * 
 * 样例输入：2 zhangsan lisi
 * 样例输出：192 101
 * 
 * 
 * @author marui
 *
 */
public class PiaoLiangDu {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int n=scanner.nextInt();
		scanner.nextLine();
		  
		int flag,len=0;
		int start,end;
		  
		int count[];      //  统计名字每个字母的个数
		int sum[]=new int[n];  //每个name的“漂亮度”
		char s[];     //name
		for(int i=0; i<n; i++){
			s = scanner.nextLine().toLowerCase().toCharArray();
			Arrays.sort(s);
			len =s.length;
			flag=0; start=0; end=0;
		   
			count=new int[len];
			while(end<len){    //  统计排序后名字每个字母的个数
				while( end<len && s[start]==s[end]) 
					end++;
				count[flag++] = end - start;
				start = end;   
		   }
		   Arrays.sort(count);   // 个数最多的字母=26，依次递减
		   for(int j=len-1; j>0&&count[j]!=0;j--)
			   sum[i]+=(26+j-len+1)*count[j];
		}
		for(int i=0; i<n; i++) 
			System.out.println(sum[i]);
	}
}