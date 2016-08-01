package com.marc.wangyi;

import java.util.Scanner;
/**
 * @description 问题描述：给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，
 * 再按非递减排序，然后用第1个数字减第2个数字，将得到一个新的数字。一直重复这样做，我们很快会停在有“数字黑
 * 洞”之称的6174，这个神奇的数字也叫Kaprekar常数。
 * 
 * 例如，我们从6767开始，将得到
 * 7766 - 6677 = 1089
 * 9810 - 0189 = 9621
 * 9621 - 1269 = 8352
 * 8532 - 2358 = 6174
 * 7641 - 1467 = 6174
 * ... ...
 * 现给定任意4位正整数，请编写程序演示到达黑洞的过程。 
 * 
 * 输入描述：输入给出一个(0, 10000)区间内的正整数N。
 * 输出描述：如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到
 * 6174作为差出现，输出格式见样例。注意每个数字按4位数格式输出。
 * 
 * 
 * @author marui
 *
 */
public class KaprekarNum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String str = Integer.toString(n);
		while((4-str.length() > 0)){
			str = "0" + str;
		}
		if(n % 1111 == 0)
			System.out.println(n + " - " + n + " = 0000");
		else{
			while(n != 6174){
				String num1 = mySort(str, true);
				String num2 = mySort(str, false);
				int v1 = Integer.parseInt(num1);
				int v2 = Integer.parseInt(num2);
				n = v1 - v2;
				str = Integer.toString(n);
				System.out.println(num1 + " - " + num2 + " = " + n);
			}
		}
	}
	
	public static String mySort(String str, boolean x){
		char[] arr = str.toCharArray();
		if(x){
			for(int i = 0; i < arr.length - 1; ++i){
				for(int j = 0; j < arr.length - i - 1; ++j){
					if(arr[j] < arr[j+1]){
						char temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
		}else{
			for(int i = 0; i < arr.length - 1; ++i){
				for(int j = 0; j < arr.length - i - 1; ++j){
					if(arr[j] > arr[j+1]){
						char temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
					}
				}
			}
		}
		return String.valueOf(arr);
	}
}