package responsibilityChain;

public class Application {
	public static void main(String[] args) {
		Handler beijing,shanghai,tianjin;
		beijing = new Beijing();
		shanghai = new Shanghai();
		tianjin = new Tianjin();
		beijing.setNextHandler(shanghai);
		shanghai.setNextHandler(tianjin);
		beijing.handleRequest("æ©AKS987");
		beijing.handleRequest("ΩÚAKS987");
		beijing.handleRequest("ª¶AKS987");
		beijing.handleRequest("¡…AKS987");
	}

}
