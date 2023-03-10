package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;


/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        System.out.println("[복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username="+name);
        }

        // 파라미터 이름 모두 조회
        System.out.println("파라미터 이름 모두 조회   Enumeration<String> parameterNames = request.getParameterNames()");
        Enumeration<String> parameterNames = request.getParameterNames();
        parameterNames.asIterator().forEachRemaining(s -> System.out.println("s = " + s));

        // 파라미터를 Map으로 조회
        System.out.println("파라미터 이름 모두 조회 Map<String, String[]> parameterMap = request.getParameterMap()");
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((s, strings) -> System.out.println("s ="+s));
        response.getWriter().write("ok");
    }
}