package fibonacciSequence;

public class Fibonacci {
	static int count=0;
	public static double fibonacci(int i){
		if(i<=1){
			count++;
			return 0;
		}
		else if(i==2){
			count++;
			return 1;
		}
		else{
			double a = 0;
			double b = 1;
			double fibNum = 1;
			for(int j=0;j<i-2;j++){
				fibNum = a + b;
				a = b;
				b = fibNum;
				count++;
			}
			return fibNum;
		}
		
	}
	public static void main(String[] args) {
		double tem = fibonacci(10000);
		System.out.println(tem);
		System.out.println(count);
	}

}
