package com.friendsofgroot.app.webservice;

import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.repositories.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ViewUsersCommand implements Command {
    UsersRepository usersRepository;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println("session: " + session);

        List<User> listUsers = usersRepository.findAll( );
        System.out.println("listUsers: " + listUsers);
        if (listUsers != null) {
            session.setAttribute("listUsers", listUsers);
            return "listUsers";
        }

        return null;
    }
}
