package printSpiralCube;

public class PrintArray {
	/**
	 * 打印m行n列的螺旋方阵
	 */
	public void print(int m,int n){
		int[][] pos = new int[m][n];
		int num = 0;
		int x = 0,y = 0;//当前要赋值的坐标
		int down = 0,right = 1,up = 2,left = 3;
		int dir = down;//标记赋值的方向
		int count = 1; //标记是第几圈
		while(num < m*n){
			num++;
			pos[x][y] = num;
			switch(dir){
			case 0://向下赋值
				if(x < m - count){
					x++;
				}else{
					dir = right;
					y++;
				}
				break;
			case 1://向右赋值
				if(y < n-count){
					y++;
				}else{
					dir = up;
					x--;
				}
				break;
			case 2://向上赋值
				if(x > count-1){
					x--;
				}else{
					dir = left;
					y--;
				}
				break;
			case 3://向左赋值
				if(y > count){
					y--;
				}else{
					count++;
					dir = down;
					x++;
				}
				break;
			}
		}
		for(int i=0;i<pos.length;i++){
			for(int j=0;j<pos[i].length;j++){
				System.out.print(String.format("%0"+getWeiShu(m, n)+"d", pos[i][j])+" ");
			}
			System.out.println();
		}
	}
	/*
	 * 打印N*N魔方数   N是奇数
	 */
	public void printCubeNum(int n){
		int[][] cube = new int[n][n];
		int num = 0;
		cube[0][n/2] = num;
		int nextRow = 0;
		int nextLine = n/2;
		int lastRow = 0;
		int lastLine = 0;
		while(num < n*n){
			num ++ ;
			cube[nextRow][nextLine] = num;
			if(nextRow == 0 && nextLine == n-1){
				nextRow = nextRow + 1;
			}else if(nextRow == 0){
				nextRow = n-1;
				nextLine = nextLine + 1;
			}else if(nextLine == n-1){
				nextRow = nextRow - 1;
				nextLine = 0;
			}else{
				nextRow = nextRow - 1;
				nextLine = nextLine + 1;
			}
			if(cube[nextRow][nextLine] != 0){
				nextRow = lastRow + 1;
				nextLine = lastLine;
			}
			lastRow = nextRow;
			lastLine = nextLine;
		}
		for(int i=0;i<cube.length;i++){
			for(int j=0;j<cube[i].length;j++){
				System.out.print(String.format("%0"+getWeiShu(n, n)+"d", cube[i][j])+" ");
			}
			System.out.println();
		}
		
	} 
	public void printYanghuiSj(int n){
		int[][] yanghui = new int[n][];
		for(int i=1;i<=yanghui.length;i++){
			int[] num = new int[i];
			for(int j=0;j<num.length;j++){
				if(j == 0 || j == num.length-1){
					num[j] = 1;
				}else{
					num[j] = yanghui[i-2][j] + yanghui[i-2][j-1];
				}
			}
			yanghui[i-1] = num;
		}
		for(int i=1;i<=yanghui.length;i++){
			for(int j=0;j<yanghui[i-1].length;j++){
				System.out.print(yanghui[i-1][j]+" ");
			}
			System.out.println();
		}
	}
	private int getWeiShu(int m,int n){
		String s = m*n + "";
		return s.length();
	}
	public static void main(String[] args) {
		PrintArray array = new PrintArray();
		array.print(10, 10);
		System.out.println("        ---------------------");
		array.printCubeNum(11);
		System.out.println("        ---------------------");
		array.printYanghuiSj(10);
	}

}
