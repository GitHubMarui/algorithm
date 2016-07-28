package com.marc.huawei;

import java.util.Scanner;

/**
 * @description 问题描述：计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。 
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK， 
 * 则他们的身高满足存在i（1<=i<=K）使得Ti<T2<......<Ti-1<Ti>Ti+1>......>TK。 
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。 
 * 
 * 输入：整数N，一行整数，空格隔开，N位同学身高
 * 输出：最少需要几位同学出列
 * 
 * 样例输入：8 186 186 150 200 160 130 197 200
 * 样例输出：4
 * 
 * @author marui
 *
 */
public class HeChangDui {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  
        int n;  
        n = scanner.nextInt();  
        int height[] = new int[n];  
        //input height  
        for(int i = 0; i < n; i++){  
            height[i] = scanner.nextInt();  
        }//for  
          
        int result = getResult(height);  
        System.out.println(result);  
         
        scanner.close();  
	}
	
	private static int getResult(int array[]){  
        int maxLengthArray[] = new int[array.length];  
        for(int i = 0; i < maxLengthArray.length; i++)  
            maxLengthArray[i] = 1;  
        //update increase  
        for(int i = 1; i < array.length; i++){  
            for(int j = 0; j < i; j++){  
                if(array[i] > array[j] && maxLengthArray[i] < maxLengthArray[j] + 1)  
                    maxLengthArray[i] = maxLengthArray[j] + 1;  
            }  
        }//for  
          
        int minLengthArray[] = new int[array.length];  
        for(int i = 0; i < minLengthArray.length; i++)  
            minLengthArray[i] = 1;  
        //update decrease  
        for(int i = array.length - 2; i >= 0; i--){  
            for(int j = array.length - 1; j > i; j--){  
                if(array[i] > array[j] && minLengthArray[i] < minLengthArray[j] + 1)  
                    minLengthArray[i] = minLengthArray[j] + 1;  
            }  
        }//for  
          
        //find max  
        int maxLength = 0;  
        for(int i = 0; i < maxLengthArray.length; i++)  
            maxLength = maxLength > (maxLengthArray[i] + minLengthArray[i] - 1)? maxLength : (maxLengthArray[i] + minLengthArray[i] - 1);  
              
        return array.length - maxLength;  
    }  
}
