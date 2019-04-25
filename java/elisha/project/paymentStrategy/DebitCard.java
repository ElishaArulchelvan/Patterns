package elisha.project.paymentStrategy;

public class DebitCard extends Card {

	public DebitCard(String cardNum, String name, String cvv, String expDate) {
		super(cardNum, name, cvv, expDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getType() 
	{
		return "debitCard";
	}
	
	

}
