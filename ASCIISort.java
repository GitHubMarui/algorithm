package com.marc.huawei;

import java.util.Scanner;

/**
 * @description 问题描述：Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照
 * 大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙。
 * 
 * 输入：Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * 输出：Lily的所有图片按照从小到大的顺序输出
 * 
 * 样例输入：Ihave1nose2hands10fingers
 * 样例输出：0112Iaadeeefghhinnnorsssv
 * 
 * @author marui
 *
 */
public class ASCIISort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			System.out.println(quickSort(input));
      }
      scanner.close();
	}
	
	private static String quickSort(String s) {
        char[] chars = s.toCharArray();
        quickSort(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void quickSort(char[] chars, int beg, int end) {
        if (beg < end) {
            int lo = beg;
            int hi = end;
            char pivot = chars[lo];

            while (lo < hi) {
                while (lo < hi && chars[hi] >= pivot) {
                    hi--;
                }

                chars[lo] = chars[hi];

                while (lo < hi && chars[lo] <= pivot) {
                    lo++;
                }

                chars[hi] = chars[lo];
            }

            chars[lo] = pivot;

            quickSort(chars, beg, lo - 1);
            quickSort(chars, lo + 1, end);

        }
    }
}
