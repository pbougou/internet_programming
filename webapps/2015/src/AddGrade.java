import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet(name = "AddGrade", urlPatterns = "/addGrade")
public class AddGrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    protected void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("SessionUsername");

        resp.setContentType("text/html");


        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title> Hello " + username + "</title></head>");

        Connection connection = null;
        Statement statement = null;

        try {
            int movie_id = Integer.parseInt(req.getParameter("movie_id"));
            int rate = Integer.parseInt(req.getParameter("rate"));

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "panatmysql_1994");
            statement = connection.createStatement();
            String insert_query = "insert into rates(movie_id, username, rate) values (" + movie_id + ",'" + username + "'," + rate + ");";
            if (username != null) {
                statement.executeUpdate(insert_query);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }


    }
}
