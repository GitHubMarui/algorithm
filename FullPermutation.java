package com.marc.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description 题目描述:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,
 * bca,cab和cba。 结果请按字母顺序输出。 
 * 
 * @author marui
 *
 */
public class FullPermutation {
	
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> result = new ArrayList<String>();
		
		if(str == null || str.length() == 0){
			return result;
		}
		
		Permutation(str.toCharArray(), 0, result);
		Collections.sort(result);	//排序输出
		return result;
	       
    }
	
	public static void Permutation(char[] data, int begin, ArrayList<String> result){
		if(begin == data.length - 1){
			result.add(new String(data));
		}else{
			for(int i = begin; i < data.length; ++i){
				if(i == begin || data[i] != data[begin]){
					swap(data, i, begin);
					Permutation(data, begin + 1, result);
					swap(data, i, begin);
				}
			}
		}
	}

	private static void swap(char[] data, int i, int j) {
		char temp = 0;
		temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		
	}
	
	public static void main(String[] args) {
		String s = "abc";
		Permutation(s);
	}
}
