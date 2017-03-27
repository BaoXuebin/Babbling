package sort;

public class QuickSort {
	private int count1 = 0;//记录比较次数
	private int count2 = 0;//记录交换次数
	public void sort(int[] Array){
		
	}
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] a = {2,5,19,5,8,10,7,2,8};
		qs.sort(a);
        System.out.println("\n共比较"+qs.count1+"次");
        System.out.println("共交换"+qs.count2+"次");

	}

}
