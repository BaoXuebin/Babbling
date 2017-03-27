package responsibilityChain;

public class Application {
	public static void main(String[] args) {
		Handler beijing,shanghai,tianjin;
		beijing = new Beijing();
		shanghai = new Shanghai();
		tianjin = new Tianjin();
		beijing.setNextHandler(shanghai);
		shanghai.setNextHandler(tianjin);
		beijing.handleRequest("��AKS987");
		beijing.handleRequest("��AKS987");
		beijing.handleRequest("��AKS987");
		beijing.handleRequest("��AKS987");
	}

}
