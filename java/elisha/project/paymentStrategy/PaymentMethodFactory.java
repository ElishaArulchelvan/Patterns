package elisha.project.paymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentMethodFactory {
	
	public final static Map<String, String> mapOfPaymentMethods = new HashMap<String, String>()
	{
		{
			put("CreditCard", "Credit Card");
			put("DebitCard", "Debit Card");
		}
	};
	
	public final static List<String> listOfPaymentMethods = new ArrayList<>(mapOfPaymentMethods.values());

	public static PaymentMethod getPaymentmethod(String type)
	{
		switch(type) {
		case "creditCard":
			return createCreditCard();
		case "debitCard":
			return createDebitCard();
		}
		throw new IllegalArgumentException();
	}
	
	public static CreditCard createCreditCard()
	{
		return new CreditCard("XXXX", "000000000", "123", "00/00");
		
	}
	
	public static DebitCard createDebitCard()
	{
		return new DebitCard("XXXX", "000000000", "123", "00/00");
		
	}

}
