package pl.coderslab.users;

import pl.coderslab.util.User;
import pl.coderslab.util.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();

        User user = new User(email,name,password);
        userDao.create(user);

        request.setAttribute("users",userDao.findAll());

        getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);


    }
}