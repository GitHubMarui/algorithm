package com.marc.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description 题目描述：在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符。 
 * 输入： 输入有多组数据 ，每一组输入一个字符串。 
 * 输出： 输出第一个只出现一次的字符下标，没有只出现一次的字符则输出-1。 
 * 样例输入： WUUR WW 
 * 样例输出： 1 -1
 * @author marui
 *
 */
public class FirstNotRepeatingChar {
	/**
	 * 思路：因为全部是字母（都是大写或者小写），则可以用一个长度为26的counts数组记录字符串中相应字符出现的个数，
	 * 最后遍历整个字符串找到第一个在counts为1的位置。
	 */
	public int FirstNotRepeatingChar1(String str) {
		if(str.length() == 0)
			return -1;
		char c = 'A';
		if(str.charAt(0) >= 'a')
			c = 'a';
		int[] counts = new int[26];
		for(int i = 0; i < str.length(); i++){
			counts[str.charAt(i)-c]++;
		}
		for(int i = 0; i < str.length(); i++){
			if(counts[str.charAt(i)-c] == 1)
				return i;
		}
		return -1;
    }
	
	/**
	 * 思路：使用hash表
	 */
	public int FirstNotRepeatingChar2(String str) {
		if(str.length() == 0)
			return -1;
		LinkedHashMap map = new LinkedHashMap();
		for(int i = 0; i<str.length(); i++){
			if(map.containsKey(str.charAt(i))){
				int time = (int) map.get(str.charAt(i));
				map.put(str.charAt(i), ++time);
			}else{
				map.put(str.charAt(i), 1);
			}
		}
		for(int i = 0; i < str.length(); i++){
			if((int)map.get(str.charAt(i)) == 1){
				return i;
			}
		}
		
		return -1;
	}
}
