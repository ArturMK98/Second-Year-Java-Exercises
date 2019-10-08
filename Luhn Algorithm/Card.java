/**
 * 	- This class is used to check if a credit card number is valid or not
 * 	  using the Luhn algorithm.
 */

public class Card {
	
	private String number;
	
	public Card(String number) {
		
		this.number = number;
	}
	
	public String isValid() {
		
		int sum = 0;
		boolean alternate = false;
		for (int i = number.length() - 1; i >= 0; i--) {
			
			int num = Integer.parseInt(number.substring(i,  i + 1));
			
			if (alternate) {
				
				num *= 2;
				
				if (num > 9) {
					
					num = (num % 10) + 1;

				}
			}
			
			sum += num;	
			alternate = !alternate;

		}
		
		if (sum % 10 == 0) {
			
			return "VALID";
			
		} else {
			
			return "INVALID";
		}
	}
}
