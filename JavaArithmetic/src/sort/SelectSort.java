package sort;
//选择排序的实现
public class SelectSort {
	private int count1 = 0;//记录比较次数
	private int count2 = 0;//记录交换次数
	public void sort(int[] Array){
		int flag,temp;
		System.out.print("输出起始数组数据：");
		for(int k=0;k<Array.length;k++){
			System.out.print(Array[k]+" ");
		}
		System.out.println("");
		for(int i=0;i<Array.length;i++){
			flag=i;
			for(int j=i+1;j<Array.length;j++){ //选出除第一个外最大的一个数的数组下标,赋值给flag
				if(Array[flag]>Array[j]){
					flag=j;
				}
				count1++;
			}
			if(flag!=i){//交换数组元素
				count2++;
				temp = Array[i];
				Array[i] = Array[flag];
				Array[flag] = temp;
			}
			System.out.print("输出第"+(i+1)+"步的排序结果：");
			for(int k=0;k<Array.length;k++){
				System.out.print(Array[k]+" ");
			}
			System.out.println("");
//			System.out.print("\n");增加一个换行
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
		SelectSort ss = new SelectSort();
		int[] a = {2,5,19,5,8,10,7,2,8};
		ss.sort(a);
        System.out.println("\n共比较"+ss.count1+"次");
        System.out.println("共交换"+ss.count2+"次");
	}

}
