package service;

import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public boolean check(String user, String pass) {
		return userDao.check(user, pass);
	}
}
