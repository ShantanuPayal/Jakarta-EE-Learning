import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentServ")
public class StudentServ extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String Url = "jdbc:mysql://localhost:3306/jdbc";
    private static final String User = "root";
    private static final String Password = "shantanu1";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Url, User, Password);

            // Setting up the query to insert data without specifying the rollno
            PreparedStatement pst = conn.prepareStatement("INSERT INTO student (name, age, address) VALUES (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setString(2, age);
            pst.setString(3, address);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int rollno = generatedKeys.getInt(1);

                    // Retrieving all roll numbers
                    ArrayList<String> rollNumbers = new ArrayList<>();
                    PreparedStatement retrievePst = conn.prepareStatement("SELECT rollno FROM student");
                    ResultSet rs = retrievePst.executeQuery();
                    while (rs.next()) {
                        rollNumbers.add(rs.getString("rollno"));
                    }

                    // Forwarding roll numbers to Report.jsp
                    request.setAttribute("rollNumbers", rollNumbers);
                    RequestDispatcher rd = request.getRequestDispatcher("Report.jsp");
                    rd.forward(request, response);
                }
            } else {
                out.println("<h2>Insert failed</h2>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
