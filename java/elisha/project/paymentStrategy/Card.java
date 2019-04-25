package elisha.project.paymentStrategy;

import java.text.MessageFormat;

public abstract class Card implements PaymentMethod{

	private final String cardNum;
	private final String name;
	private final String cvv;
	private final String expDate;
	
	protected abstract String getType();
	
	
	public Card(String cardNum, String name, String cvv, String expDate) {
		super();
		this.cardNum = cardNum;
		this.name = name;
		this.cvv = cvv;
		this.expDate = expDate;
	}


	@Override
	public void pay(int euro) {
		
		System.out.println("The amount paid: ");
	}
	
	public String toString() {
        return MessageFormat.format("{0} card[name = {1}, number = {2}, CVV = {3}, expiration = {4}]", getType(), name, cardNum, cvv, expDate);
    }
	
	
	
}
