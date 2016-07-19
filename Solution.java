package com.marc.string;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public ArrayList<String> Permutation(String str) {
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
}
