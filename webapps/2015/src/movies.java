import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "movies", urlPatterns = "/movies")
public class movies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req, resp);
    }


    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        ResultSet avg = null;

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        HttpSession session = req.getSession(true);
        session.setAttribute("SessionUsername", req.getParameter("name"));

        String username = (String)session.getAttribute("SessionUsername");
        if(username == null) {
            username = "You must enter a username in home section in order to grade";
        }
        out.println(username + "<br/><center>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies?serverTimezone=UTC", "root", "panatmysql_1994");
            statement = connection.createStatement();
            String sqSelect = "SELECT * FROM movie";
            rs = statement.executeQuery(sqSelect);

            List<Movie> movies = new ArrayList<>();
            while(rs.next()) {
                movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getString("year")));
            }
            rs.close();

            String avgRate = "SELECT movie_id, avg(rate) as AVG FROM rates GROUP BY movie_id";
            avg = statement.executeQuery(avgRate);
            List<Double> avgList = new ArrayList<>();
            while(avg.next()) {
                avgList.add(avg.getDouble("AVG"));
            }
            avg.close();

            out.println("<table style=\"width:100%\"");
            for(Movie movie : movies) {
                out.println("<tr><td>" + movie.getId() + "</td><td>" + movie.getTitle() + "</td><td>" + avgList.get(movie.getId() - 1).toString() + "<td/></tr>");
            }
            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("</center><body><html>");
    }

}
