package Ecommerce.business.validaitons.emailValidaitons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Ecommerce.business.abstracts.EmailConfirmationService;

public class RegaxEmailConfirmation implements EmailConfirmationService {
	
	private static final String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	
	@Override
	public boolean emailConfirming(String email) {
		Pattern pattern = Pattern.compile(emailPattern,Pattern.CASE_INSENSITIVE);
		Matcher emailMacher = pattern.matcher(email);
		
		if (emailMacher.matches()) {
			 System.out.println("E-Posta Doðrulandý.");
			 return true;
		}
		
		return false;
		
	}
}
