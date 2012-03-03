package paymentproviders;

public class IDealConsumer {
	
	public String consumerName;
	public String consumerAccount;
	public String consumerCity;
	
	public IDealConsumer(String consumerName, String consumerAccount, String consumerCity){
		this.consumerAccount = consumerAccount;
		this.consumerCity = consumerCity;
		this.consumerName = consumerName;
	}

	@Override
	public String toString() {
		return "IDealConsumer [consumerName=" + consumerName
				+ ", consumerAccount=" + consumerAccount + ", consumerCity="
				+ consumerCity + "]";
	}

}
