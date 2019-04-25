package elisha.project.paymentStrategy;



public class CreditCard extends Card {

	public CreditCard(String cardNum, String name, String cvv, String expDate) 
	{
		super(cardNum, name, cvv, expDate);
		
	}

	@Override
	protected String getType() {
		return "creditCard";
	}
	
	
	

}
