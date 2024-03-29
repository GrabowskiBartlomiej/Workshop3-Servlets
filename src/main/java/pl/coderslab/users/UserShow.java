package pl.coderslab.users;

import pl.coderslab.util.User;
import pl.coderslab.util.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserShow", urlPatterns = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();

        User userToView = userDao.read(id);

        request.setAttribute("user", userToView);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
    }
}
