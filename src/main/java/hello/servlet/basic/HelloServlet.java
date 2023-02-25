package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet",urlPatterns = "/hello") //서블릿으로 사용하게 등록
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service method");

        System.out.println("HttpServletRequest = " + request);
        System.out.println("HttpServletResponse = " + response);
        /**
         * HttpServletRequest = org.apache.catalina.connector.RequestFacade@3837d7cc
         * HttpServletResponse = org.apache.catalina.connector.ResponseFacade@36f03eba
         * HtpServletRequest,HttpServletResponse 인테페이스를 구현하는 Tomcat의 클래스
          */

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //////////////////////////////////////////////////////////////////////////////////

        //header
//        response.setHeader("Content-Type", "text/plain;charset=utf-8") ==
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        //body
        response.getWriter().write("hello "+username);

    }
}
