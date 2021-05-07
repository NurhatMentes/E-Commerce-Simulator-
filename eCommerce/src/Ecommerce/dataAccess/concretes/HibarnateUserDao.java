package Ecommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Ecommerce.dataAccess.abstracts.UserDao;
import Ecommerce.entities.concretes.User;

public class HibarnateUserDao implements UserDao{
	
	
	//Yazýlan tüm operasyonlar simüle amaçlýdýr!!!
	
	
	
	public static List<User> users =new ArrayList<User>();

	public HibarnateUserDao() {
		users = new ArrayList<User>();
	}

	@Override
	public void register(User user) {
		for (User item : users) {
			if (user.getEmail() == item.getEmail()) {
				System.out.println(user.getEmail()+", Bu E-Posta Kayýtlý.");
			}
			else {
				users.add(user);
			}
		}
	}

	@Override
	public void login(User user) {
		for (User item : users) {
			if (user.getEmail() == item.getEmail()) {
				System.out.println("Sayýn "+user.getFirstName()+", Sisteme Giriþ Yaptýnýz.");
			}
		}
	}

	@Override
	public void update(User user) {
		// simüle databasede güncelleme
		User userToUpdate = get(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());

	}

	@Override
	public void delete(User user) {
			// simüle databaseden silme
		User deletedUser = users.stream().filter(x -> x.getId() == user.getId()).findFirst().get();
		users.remove(deletedUser);

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
