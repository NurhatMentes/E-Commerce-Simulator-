package Ecommerce.business.concretes;

import java.util.List;

import Ecommerce.business.abstracts.EmailConfirmationService;
import Ecommerce.business.abstracts.UserService;
import Ecommerce.dataAccess.abstracts.UserDao;
import Ecommerce.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private EmailConfirmationService emailConfirmation;
	
	
	public UserManager(UserDao userDao, EmailConfirmationService emailConfirmation) {
		super();
		this.userDao = userDao;
		this.emailConfirmation = emailConfirmation;
	}

	@Override
	public void register(User user) {
		if(user.getEmail()==null || user.getFirstName()==null ||  user.getLastName()==null || user.getPassword()==null) {
			System.out.println("Lütfen Boş alanlari giriniz. ");
			return;
		}
		else if(user.getPassword().length()<6) {
			System.out.println("Şifreniz 6 karakterden küçük olamaz."+ user.getPassword().length());
			return;
		}
		else if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Adınız ve soyadiniz iki karakterden küçük olamaz."+ user.getFirstName().length()+ " "+user.getLastName().length());
			return;
		}
		else if(this.emailConfirmation.emailConfirming(user.getEmail())==false) {
			System.out.println("Lütfen E-Postanızı düzeltiniz"+ user.getEmail());
			return;
		}
		else {
			System.out.println("Sayın "+user.getFirstName()+" "+user.getLastName()+", Kaydınız Başarılı. Aramıza Hoş Geldiniz.");
			emailConfirmation.emailConfirming(user.getEmail());
		}
	}

	@Override
	public void login(User user) {
		if (!user.getEmail().isEmpty()&&!user.getPassword().isEmpty()) {
			this.userDao.login(user);
			System.out.println("sisteme giriş yapıldı");
		}
		else {
			System.out.println("sisteme giriş başarısız");
		}
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
