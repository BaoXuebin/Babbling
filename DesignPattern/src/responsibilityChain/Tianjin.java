package responsibilityChain;

import java.util.ArrayList;

public class Tianjin implements Handler {
	private Handler handler;//存放当前处理者后继的handler接口变量
	private ArrayList<String> numberList;//存放号码
	public Tianjin() {
		numberList = new ArrayList<String>();
		numberList.add("津AKS987");
		numberList.add("津H67983");
		numberList.add("津FMS347");
		numberList.add("津C56977");
	}
	@Override
	public void handleRequest(String number) {
		if(numberList.contains(number))
			System.out.println("车牌"+number+"属于天津地区");
		else{
			System.out.println("车牌"+number+"不属于天津地区");
			if(handler!=null)
				handler.handleRequest(number);
		}
	}

	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}

}
