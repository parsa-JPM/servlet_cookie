import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String userID = "parsa";
    private final String password = "1234";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("pwd");

        if (userID.equals(user) && this.password.equals(password)) {
            Cookie loginCookie = new Cookie("user", user);
            //setting expire time
            loginCookie.setMaxAge(30 * 60);
            resp.addCookie(loginCookie);
            resp.sendRedirect("/LoginSuccess.jsp");
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            PrintWriter writer = resp.getWriter();
            writer.println("<h1 style='color:red'>user or pass is incorrect</h2>");
            dispatcher.include(req, resp);
        }
    }
}
