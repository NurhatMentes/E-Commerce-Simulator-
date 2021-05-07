package Ecommerce.dataAccess.abstracts;

import java.util.List;

import Ecommerce.entities.concretes.User;

public interface UserDao {
	void register(User user);
	void login(User user);
	void update(User user);
	void delete(User user);
	User get(int userId);
	List<User> getAll();
}
