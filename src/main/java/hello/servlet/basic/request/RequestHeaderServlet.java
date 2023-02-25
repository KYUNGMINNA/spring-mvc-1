package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet",urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }
    // start line 정보
    private void printStartLine(HttpServletRequest request) {
        /** http://localhost:8080/request-header?username=aaa&useranme=bbbb */
        System.out.println("--- REQUEST  : STRART LINE   start ---");

        // get, post 등 http 메서드
        System.out.println("request.getMethod() = " + request.getMethod());

        // HTTP/1.1
        System.out.println("request.getProtocol() = " + request.getProtocol());

        // http
        System.out.println("request.getScheme() = " + request.getScheme());

        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());

        // /request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());

        // username=aaa&username=bbb
        System.out.println("request.getQueryString() = " + request.getQueryString());

        // https 사용 유무
        System.out.println("request.isSecure() = " + request.isSecure());

        System.out.println("--- REQUEST - STRART LINE  - end ---\n");
    }

    // Header 모든 정보
    private void printHeaders(HttpServletRequest request) {
        /** http://localhost:8080/request-header?username=aaa&useranme=bbbb */
        System.out.println("--- Headers  한 번에 모든 헤더 정보 다 조회- start ---");

        /* 옛날 방식
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
              String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + request.getHeader(headerName));
        }
        */

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " = " + request.getHeader(headerName)));
        System.out.println("--- Headers - end ---\n");
    }

    // Header 편리한 조회
    private void printHeaderUtils(HttpServletRequest request) {
        /** http://localhost:8080/request-header?username=aaa&useranme=bbbb */
        System.out.println("--- Header 각각 조회 start ---");

        // Host 헤더
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName());

        // Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        // getLocale을 통해 조회하면 가장 우선순위가 높은 최상단의 locale 조회
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));

        System.out.println("request.getLocale() = " + request.getLocale());

        System.out.println();
        System.out.println("[Cookie 편의 조회]");

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }

        System.out.println();
        System.out.println("[Content 편의 조회]");

        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---\n");
    }

    // 기타 정보
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");

        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());

        System.out.println();
        System.out.println("[Local 정보]");

        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());
        System.out.println("--- 기타 조회 end ---\n");
    }
}
