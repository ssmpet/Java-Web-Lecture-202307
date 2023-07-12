package ch09_cookie_session.users;

import org.mindrot.jbcrypt.BCrypt;

public class UserService {
	public static final int CORRECT_LOGIN = 0;
	public static final int WRONG_PASSWORD = 1;
	public static final int UID_NOT_EXIST = 2;
	
	public int login(String uid, String pwd) {
		UserDao uDao = new UserDao();
		User user = uDao.getUser(uid);
		if (user == null)
			return UID_NOT_EXIST;
		else if (BCrypt.checkpw(pwd, user.getPassword()))
			return CORRECT_LOGIN;
		else
			return WRONG_PASSWORD;
	}
}
