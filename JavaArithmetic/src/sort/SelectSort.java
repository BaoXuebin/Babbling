package sort;
//ѡ�������ʵ��
public class SelectSort {
	private int count1 = 0;//��¼�Ƚϴ���
	private int count2 = 0;//��¼��������
	public void sort(int[] Array){
		int flag,temp;
		System.out.print("�����ʼ�������ݣ�");
		for(int k=0;k<Array.length;k++){
			System.out.print(Array[k]+" ");
		}
		System.out.println("");
		for(int i=0;i<Array.length;i++){
			flag=i;
			for(int j=i+1;j<Array.length;j++){ //ѡ������һ��������һ�����������±�,��ֵ��flag
				if(Array[flag]>Array[j]){
					flag=j;
				}
				count1++;
			}
			if(flag!=i){//��������Ԫ��
				count2++;
				temp = Array[i];
				Array[i] = Array[flag];
				Array[flag] = temp;
			}
			System.out.print("�����"+(i+1)+"������������");
			for(int k=0;k<Array.length;k++){
				System.out.print(Array[k]+" ");
			}
			System.out.println("");
//			System.out.print("\n");����һ������
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
		SelectSort ss = new SelectSort();
		int[] a = {2,5,19,5,8,10,7,2,8};
		ss.sort(a);
        System.out.println("\n���Ƚ�"+ss.count1+"��");
        System.out.println("������"+ss.count2+"��");
	}

}
