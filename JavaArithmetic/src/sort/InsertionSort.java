package sort;
//插入排序法的实现
public class InsertionSort {
	private int count1 = 0;//记录比较次数
	private int count2 = 0;//记录交换次数
	public void sort(int[] Array){
		int value;//用来表示要作比较的元素的值
		int temp;
		System.out.print("输出起始数组数据：");
		for(int k=0;k<Array.length;k++){
			System.out.print(Array[k]+" ");
		}
		System.out.println("");
		for(int i=1;i<Array.length;i++){//从第二个元素开始遍历数组
			value = Array[i];
			for(int j=0;j<i;j++){
				while(Array[j]>value&&j<i){
					temp = Array[j];
					Array[j] = Array[i];
					Array[i] = temp;
					j++;
					count1++;
					count2++;
				}
				count1++;
			}
			System.out.print("输出第"+i+"步的排序结果：");
			for(int k=0;k<Array.length;k++){
				System.out.print(Array[k]+" ");
			}
			System.out.println("");
			if(isSuccess(Array)){
				System.out.print("最终数组数据：");
				System.out.println("");
				for(int k=0;k<Array.length;k++){
					System.out.print(Array[k]+" ");
				}
				break;
			}
		}
	}
	private boolean isSuccess(int[] Array){
		for(int i=0;i<Array.length-1;i++){
			if(Array[i]>Array[i+1])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] a = {2,5,19,5,8,10,7,2,8};
		is.sort(a);
		System.out.println("\n共比较"+is.count1+"次");
        System.out.println("共交换"+is.count2+"次");
	}

}
