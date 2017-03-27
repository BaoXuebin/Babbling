

public class Test {
	public static int intercept(int x1,int y1,int x2,int y2,int x3,int y3){//求截距,坐标变换
		int b = 0;
		if(x1==x2){//斜率不存在
			b = x3;
		}else{
			int k = (y1-y2)/(x1-x2);
			b = y3-k*x3;
		}
		return b;
	}
	public static boolean isCollision(int[][] polygon1,int[][] polygon2){//
		int max1=0,min1=0,max2=0,min2=0,count=0;
		for(int i=0;i<polygon1.length-1;i++){
			for(int j=0;j<polygon1.length-1;j++){
				int b = intercept(polygon1[i][0],polygon1[i][1],polygon1[i+1][0],polygon1[i+1][1],polygon1[j][0],polygon1[j][1]);
				if(b>max1||j==0)
					max1 = b;
				if(b<min1||j==0)
					min1 = b;
			}
//			System.out.println(min1+" "+max1);
			count = 0;
			for(int j=0;j<polygon2.length-1;j++){
				int b = intercept(polygon1[i][0],polygon1[i][1],polygon1[i+1][0],polygon1[i+1][1],polygon2[j][0],polygon2[j][1]);
				if(b>=min1&&b<=max1){
					System.out.println("break");
					break;
				}
				else{
					if(b>max2||j==0)
						max2 = b;
					if(b<min2||j==0)
						min2 = b;
					count++;
					System.out.println(count);
				}
			}
			if(count>=polygon2.length-1&&!(max2>max1&&min2<min1)){
				System.out.println("ddd"+count);
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int[][] polygon1 = {{364,163},{314,163},{414,213},{364,213},{364,163}};
		int[][] polygon2 = {{346,150},{296,150},{396,200},{346,200},{346,150}};
//		int[][] polygon3 = {{119,177},{87,177},{151,229},{119,229},{119,177}};
		System.out.println(isCollision(polygon1, polygon2));
//		System.out.println(intercept(0, 0, 10, 0, 100, 0));
		System.out.println(intercept(598, 378, 548, 378, 548,378));
		System.out.println(2>=polygon2.length-1);
	}
}
