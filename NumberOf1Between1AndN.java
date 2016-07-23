package com.marc.string;

/**
 * @description 题目描述：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * @author marui
 *
 */
public class NumberOf1Between1AndN {
	/**
	 * 思路1：从1开始遍历到N，将其中每一个数中含有“1”的个数加起来.
	 * 效率:时间复杂度为O（N * lgN），N比较大的时候，需要耗费很长的时间
	 */
	public int NumberOf1Between1AndN_Solution1(int n) {
		int count = 0;
		for(int i = 0; i <=n; i++){
			int j = i;
			while(j != 0){
				if(j % 10 == 1)
					count++;
				j = j/10;
			}
		}
		return count;
	}
	
	/**
	 * 思路2：用分治的思想将任意一个n位数不断缩小规模分解成许多个个位数
	 * 
	 * 任意一个n位数中“1”的个位可以分解为两个n-1位数中“1”的个数的和加上一个与最高位数相关的常数C。
	 * 例如，f(12) = f(10 - 1) + f(12 - 10) + 3,其中3是表示最高位为1的数字个数，这里就是10,11,12；
	 * 
	 * 递归方程如下：
	 * if(n1 == 1)
	 * 		f(n) = f(10bit-1) + f(n - 10bit)  + n - 10bit+ 1;
	 * else
	 * 		f(n) = n1*f(10bit-1) + f(n – n1*10bit) + 10bit;
	 * 
	 * 时间复杂度：是O（lg2N）
	 */
	public int NumberOf1Between1AndN_Solution2(int n) {
		int count = 0;
		if(n == 0)
			count = 0;
		else if(n > 1 && n < 10)
			count = 1;
		else{
			int highest = n;	//代表最高位数字
			int bit = 0;
			
			while(highest >= 10){
				highest = highest/10;
				bit++;
			}
			
			int weight = (int)Math.pow(10, bit);	//代表最高位的权重，即最高位一个1代表的大小
			if(highest == 1){
				count = NumberOf1Between1AndN_Solution2(weight-1)
						+ NumberOf1Between1AndN_Solution2(n-weight)
						+ n - weight + 1;
			}
			else{
				count = highest * NumberOf1Between1AndN_Solution2(weight - 1)
						+ NumberOf1Between1AndN_Solution2(n-highest*weight)
						+ weight;
			}
		}
		
		return count;
	}
	
	/**
	 * 思路3：
	 * 1位数的情况：大于等于1的时候，有1个，小于1就没有。
	 * 2位数的情况：
	 * 		N=13,个位数出现的1的次数为2，分别为1和11，十位数出现1的次数为4，分别为10,11,12,13，所以f(N) = 2+4。
	 * 		N=23,个位数出现的1的次数为3，分别为1，11，21，十位数出现1的次数为10，分别为10~19，f(N)=3+10。
	 * n位数的情况：
	 * 		要计算百位上出现1的次数，将由三部分决定：百位上的数字，百位以上的数字，百位一下的数字。
	 * 		如果百位上的数字为0，则百位上出现1的次数仅由更高位决定，比如12013，百位出现1的情况为100~199,1100~1199,2100~2199，…，11100~11199，共1200个。等于更高位数字乘以当前位数，即12 * 100。
	 * 		 如果百位上的数字大于1，则百位上出现1的次数仅由更高位决定，比如12213，百位出现1的情况为100~199,1100~1199,2100~2199，…，11100~11199，12100~12199共1300个。等于更高位数字加1乘以当前位数，即（12 + 1）*100。
	 * 		 如果百位上的数字为1，则百位上出现1的次数不仅受更高位影响，还受低位影响。例如12113，受高位影响出现1的情况：100~199,1100~1199,2100~2199，…，11100~11199，共1200个，但它还受低位影响，出现1的情况是12100~12113，共114个，等于低位数字113+1。
	 * 时间复杂度:仅为O(lgN)
	 */
	public int NumberOf1Between1AndN_Solution3(int n) {
		int count = 0;
		int i = 1;
		int current = 0, after = 0, before = 0;
		while((n/i)!= 0){
			current = ((n/i)%10);
			before = n / (i*10);
			after = n - (n/i)*i;
			
			if(current > 1)
				count = count + (before + 1) * i;
			else if (current == 0)
				count = count + before * i;
			else if(current == 1)
				count = count + before * i + after + 1;
			i = i * 10;
		}
		return count;
	}
}
