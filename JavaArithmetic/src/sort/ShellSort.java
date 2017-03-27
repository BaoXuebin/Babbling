package sort;

public class ShellSort {
	private int count1 = 0;//��¼�Ƚϴ���
	private int count2 = 0;//��¼��������
	public void sort(int[] Array){
		int i,j,h;
		int r,temp;
		int x=0;
		System.out.println("��ʼ�������ݣ�");
		for(int k=0;k<Array.length;k++){
			System.out.print(Array[k]+" ");
		}
		System.out.println("");
		for(r=Array.length/2;r>=1;r/=2){//r��ʾ����ĳ��ȣ���Ҫ�Ƚ���֮��ļ��
			for(i=r;i<Array.length;i++){
				temp = Array[i];
				j = i-r;
				while(j>=0&&temp<Array[j]){
					Array[j+r]=Array[j];
					j-=r;
					count1++;
					count2++;
				}
				count1++;
				Array[j+r]=temp;
			}
			x++;
			System.out.print("��"+x+"�������");
			for(h=0;h<Array.length;h++){
				System.out.print(Array[h]+" ");
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
		ShellSort ss = new ShellSort();
		int[] a = {2,5,19,5,8,10,7,2,8};
		ss.sort(a);
		System.out.println("\n���Ƚ�"+ss.count1+"��");
        System.out.println("������"+ss.count2+"��");
	}

}
