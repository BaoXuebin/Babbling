//ð�������㷨��������̴���
package sort;

public class BubbleSort {//ð������

	/**
	 * @param args
	 */
	private int count=0;
	public void sort(int[] Array){
		int temp;
		System.out.println("��ʼ�������ݣ�");
		for(int k=0;k<Array.length;k++){
			System.out.print(Array[k]+" ");
		}
		System.out.println("");
		for(int i=1;i<Array.length;i++){
			for(int j=0;j<Array.length-i;j++){
				if(Array[j]>Array[j+1]){
					temp=Array[j];
					Array[j]=Array[j+1];
					Array[j+1]=temp;
					count++;
				}
			}
			System.out.print("��"+i+"����������");
			for(int k=0;k<Array.length;k++){
				System.out.print(Array[k]+" ");
			}
			System.out.println("");
			if(isSuccess(Array)){
				System.out.print("�����������ݣ�");
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
		int[] a ={9,8,7,6,5,4,3,2,1};
		BubbleSort bs = new BubbleSort();
		bs.sort(a);
		System.out.println("");
		System.out.println("��������"+bs.count+"�αȽϴ�С");
	}

}
