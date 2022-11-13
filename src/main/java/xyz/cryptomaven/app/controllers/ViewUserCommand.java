package xyz.cryptomaven.app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.cryptomaven.app.dataLoader.UserManager;
import xyz.cryptomaven.app.models.Coin;
import xyz.cryptomaven.app.models.Coin;
import xyz.cryptomaven.app.models.User;

public class ViewUserCommand implements CommandServlet {
 

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = new User(1, "tom", "m");
		request.setAttribute("userDetails", user);
		return "User details here";
	}


    // Like Singleton Managers, Controllers return singletons
    public static class UserController {
        private static UserController instance = new UserController();
        private UserController() {}
        public static UserController getInstance() {
            return instance;
        }
        public void saveUserCoin(User user, Coin coin) {
            UserManager.getInstance().saveUserCoin(user, coin);
        }

    }
}
