package Ecommerce;
import Ecommerce.business.concretes.UserManager;
import Ecommerce.business.validaitons.emailValidaitons.RegaxEmailConfirmation;
import Ecommerce.dataAccess.concretes.HibarnateUserDao;
import Ecommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User(1,"Nurhat","Menteþ","123456","nurhat@gmail.com");
		
		UserManager manager = new UserManager(new HibarnateUserDao(), new RegaxEmailConfirmation());
			manager.register(user);
		   manager.login(user);
	}

}
