package responsibilityChain;

import java.util.ArrayList;

public class Beijing implements Handler {
	private Handler handler;//��ŵ�ǰ�����ߺ�̵�handler�ӿڱ���
	private ArrayList<String> numberList;//��ź���
	public Beijing() {
		numberList = new ArrayList<String>();
		numberList.add("��AKS987");
		numberList.add("��H67983");
		numberList.add("��FMS347");
		numberList.add("��C56977");
	}
	@Override
	public void handleRequest(String number) {
		if(numberList.contains(number))
			System.out.println("����"+number+"���ڱ�������");
		else{
			System.out.println("����"+number+"�����ڱ�������");
			if(handler!=null)
				handler.handleRequest(number);
		}
	}

	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}

}
