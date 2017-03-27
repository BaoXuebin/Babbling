package mathquestion;


public class CrossRiver { 
	public static int countStep=0;
	private boolean success=false;
	private int peopleNum1=0;
	private int peopleNum2=0;
	private int[] allStep= new int[20];
	private int[] PeopleNum;
	private int[][] BoatNum={{1,0},{0,1},{2,0},{0,2},{1,1}};
	CrossRiver(){
		for(int i=0;i<allStep.length;i++){
			allStep[i]=-1;
		}
	}
	public void setPeopleNum(int i,int j){
		this.peopleNum1=i;
		this.peopleNum2=j;
	}
	public void setPeopleNum(int[] Array){
		this.PeopleNum=Array;
	}
	public void setBoatNum(int[][] Array){
		this.BoatNum=Array;
	}
	public int[] getPeopleNum(){
		return PeopleNum;
	}
	public int[][] getBoatNum(){
		return BoatNum;
	}
	public void go(int[] Array,int i){ //�ɺ�
		Array[0]=Array[0]-BoatNum[i][0];
		Array[1]=Array[1]-BoatNum[i][1];
		Array[2]=Array[2]+BoatNum[i][0];
		Array[3]=Array[3]+BoatNum[i][1];
	}
	public void back(int[] Array,int i){ //����
		Array[0]=Array[0]+BoatNum[i][0];
		Array[1]=Array[1]+BoatNum[i][1];
		Array[2]=Array[2]-BoatNum[i][0];
		Array[3]=Array[3]-BoatNum[i][1];
    }
	public boolean wanCheng(int[] Array,int peopleNum1,int peopleNum2){
		if(Array[0]==0&&Array[1]==0&&Array[2]==peopleNum1&&Array[3]==peopleNum2){
			return true;
		}	
		return false;
	}
	public int[] count(int num){//iΪ�������
		int[] count = new int[20];
		for(int i=0;i<count.length;i++){
			if(i==num) 
				count[i]++;
		}		
		return count;	
	}
	public void crossRiver(int[] Array,int num,int maxNum){
		for(int i=0;i<5;i++){
			int[] temp = new int[4];
         	for(int k=0;k<4;k++){
				temp[k]=Array[k];
			}
			countStep++;
			if(num%2==1){	
				go(temp, i);
			}	
			else{
				back(temp, i);
			}	
			if(wanCheng(temp,peopleNum1,peopleNum2)){
				success=true;
				allStep[num-1]=i;
				System.out.println(countStep);
				System.out.print(num+"���������,");
				System.out.println("����ɺ������");
				getAllStep();
			}
			else{
				if(num<maxNum){
					if(notKill(temp)&&!isNegative(temp)){	
						allStep[num-1]=i;
						crossRiver(temp, num+1,maxNum);
					}
				}
			}
		}
	}
	private void getAllStep(){
		for(int i=0;i<20;i++){
			if(allStep[i]!=-1){
				if(i%2==0)//�ɺ����
					System.out.println("��"+(i+1)+"��:"+BoatNum[allStep[i]][0]+"�����ˣ�"+BoatNum[allStep[i]][1]+"�����˶ɺ�");
				else if(i%2==1)//
					System.out.println("��"+(i+1)+"��:"+BoatNum[allStep[i]][0]+"�����ˣ�"+BoatNum[allStep[i]][1]+"�����˷���");
			}
		}	
	}
	private boolean isNegative(int[] Array){//�ж������ڵ����Ƿ�Ϊ�������Ƿ���true���񷵻�false
		if(Array[0]<0||Array[1]<0||Array[2]<0||Array[3]<0)
			return true;
		return false;
	}
	private boolean notKill(int[] Array){//
		if((Array[0]>=Array[1]||Array[0]==0)&&(Array[2]>=Array[3]||Array[2]==0))
			return true;
		return false;
	}
	public static void main(String[] args) {
		CrossRiver a = new CrossRiver();
		int i=1;
		System.out.println("���ˡ����˹������⣺");
		int[] A={3,3,0,0};
		a.setPeopleNum(3,3);
		a.setPeopleNum(A);
		do{
			a.crossRiver(A, 1,i);
			i++;
		}while(!a.success);
		
	}

}
