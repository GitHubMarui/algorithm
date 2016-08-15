import java.util.Arrays;

public class TargetIndex {

	public static void main(String[] args) {
		
	}
	
	private static void getIndex(int[] arr, int target){
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			arr1[i] = arr[i];
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		int num1 =0;
		int num2 = 0;
		int index1 = 0;
		int index2 = 0;
		while(arr[i] + arr[j] != target && i <= j){
			if(arr[i] + arr[j] > target){
				j--;
			}
			if(arr[i] + arr[j] < target){
				i++;
			}
			if(arr[i] + arr[j] == target){
				num1 = arr[i];
				num2 = arr[j];
				break;
			}
		}
		for(int k = 0; k < arr1.length; k++){
			if(arr1[k] == num1){
				index1 = k;
			}
		}
		for(int k = 0; k < arr1.length; k++){
			if(arr1[k] == num2){
				index2 = k;
			}
		}
		System.out.println("index1 = " + index1 + " index2 = " + index2);
	}

}
