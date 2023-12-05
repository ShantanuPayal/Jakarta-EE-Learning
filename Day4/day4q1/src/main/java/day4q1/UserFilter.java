package day4q1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebFilter("/UserServ")
public class UserFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String username = request.getParameter("uname");
            FileWriter fw = new FileWriter("e:\\user.txt"); 
            fw.write(username);
            
            fw.append(username,1,2);
            fw.close();
      

            chain.doFilter(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
