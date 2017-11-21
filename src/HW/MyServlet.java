package HW;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyServlet extends HttpServlet {

    final private String pass="qwe123";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");

        if(userPassword.equalsIgnoreCase(pass))
        {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<h1>");
            stringBuilder.append("Hello, ");
            stringBuilder.append(userLogin);
            stringBuilder.append("</h1>");
            stringBuilder.append("<br/>");
            stringBuilder.append("<h1>");
            stringBuilder.append("The password is correct");
            stringBuilder.append("</h1>");
            out.println(stringBuilder);
        }
        else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid password");
        }





    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
