package Ecommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import Ecommerce.dataAccess.abstracts.UserDao;
import Ecommerce.entities.concretes.User;

public class HibarnateUserDao implements UserDao{
	
	
	//Yaz�lan t�m operasyonlar sim�le ama�l�d�r!!!
	
	
	
	public static List<User> users =new ArrayList<User>();

	public HibarnateUserDao() {
		users = new ArrayList<User>();
	}

	@Override
	public void register(User user) {
		for (User item : users) {
			if (user.getEmail() == item.getEmail()) {
				System.out.println(user.getEmail()+", Bu E-Posta Kay�tl�.");
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
				System.out.println("Say�n "+user.getFirstName()+", Sisteme Giri� Yapt�n�z.");
			}
		}
	}

	@Override
	public void update(User user) {
		// sim�le databasede g�ncelleme
		User userToUpdate = get(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());

	}

	@Override
	public void delete(User user) {
			// sim�le databaseden silme
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
