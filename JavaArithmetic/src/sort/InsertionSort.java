package sort;
//�������򷨵�ʵ��
public class InsertionSort {
	private int count1 = 0;//��¼�Ƚϴ���
	private int count2 = 0;//��¼��������
	public void sort(int[] Array){
		int value;//������ʾҪ���Ƚϵ�Ԫ�ص�ֵ
		int temp;
		System.out.print("�����ʼ�������ݣ�");
		for(int k=0;k<Array.length;k++){
			System.out.print(Array[k]+" ");
		}
		System.out.println("");
		for(int i=1;i<Array.length;i++){//�ӵڶ���Ԫ�ؿ�ʼ��������
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
			System.out.print("�����"+i+"������������");
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
		InsertionSort is = new InsertionSort();
		int[] a = {2,5,19,5,8,10,7,2,8};
		is.sort(a);
		System.out.println("\n���Ƚ�"+is.count1+"��");
        System.out.println("������"+is.count2+"��");
	}

}
