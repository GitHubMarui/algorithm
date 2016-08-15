import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.Stack;

public class Lujing {
	private static void getMinWay(int[][] way){
		int[][] minNum = new int[way.length][way[0].length];
		minNum[0][0] = way[0][0];
		
		//第一列最小路径
		for(int i = 1; i < minNum.length; i++){
			minNum[i][0] = way[i][0] + minNum[i - 1][0];
		}
		
		//第一行最小路径
		for(int i = 1; i < minNum[0].length; i++){
			minNum[0][i] = way[0][i] + minNum[0][i - 1];
		}
		
		for(int i = 1; i < minNum.length; i++){
			for(int j = 1; j < minNum[0].length; j++){
				minNum[i][j] = Math.min(way[i][j] + minNum[i-1][j], way[i][j] + minNum[i][j-1]);
			}
		}
		
//		for(int i = 0; i < minNum.length; i++)
//		{
//			for(int j = 0; j < minNum[0].length; j++){
//				System.out.print(minNum[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println("最小路径值为" + minNum[way.length - 1 ][way[0].length - 1]);
		
		//返回最小路径
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		stack1.push(way.length - 1);
		stack2.push(way[0].length - 1);
		
		int i = way.length - 1;
		int j = way[0].length - 1;
		
		while(i >= 0 && j >= 0){
			
			//当达到第一行边界时
			if(i == 0 && j > 0){
				stack1.push(0);
				stack2.push(j - 1);
				j--;
				continue;
			}
			//当达到第一列边界时
			if(j == 0 && i > 0){
				stack1.push(i - 1);
				stack2.push(0);
				i--;
				continue;
			}
			
			//到达起点
			if(i == 0 && j == 0){
				stack1.push(i);
				stack2.push(j);
				break;
			}
			
			//判断从哪个路径到达的
			if(minNum[i][j - 1] + way[i][j] == minNum[i][j]){
				
				stack1.push(i);
				stack2.push(j - 1);
				i = i;
				j = j - 1;
			}
			if(minNum[i - 1][j] + way[i][j] == minNum[i][j]){
				stack1.push(i - 1);
				stack2.push(j);
				i = i - 1;
				j = j;
			}
		}
		System.out.println("路径为：");
		while(!stack1.isEmpty() && !stack2.isEmpty()){
			System.out.println(stack1.pop() + " " + stack2.pop());
		}
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		getMinWay(a);
	}
}
