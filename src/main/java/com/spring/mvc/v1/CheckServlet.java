package com.spring.mvc.v1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("나이 확인중...");
        //요청시 전달된 form데이터를 읽어줌
        //http://127.0.0.1:8181/check?age=33 중에 33을 읽어온다.
        String ageStr = req.getParameter("age");
        System.out.println(ageStr);

        int age = Integer.parseInt(ageStr);
        // age가 33보다 큰면 성인 : 아니면 미성년자 (3항연산자)
        String msg = (age > 19) ? "성인" : "미성년자";
        System.out.println("msg = " + msg);

        //HTML 렌더링
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        //HTML을 그릴 펜
        PrintWriter w = resp.getWriter();
        w.println("<html>");
        w.println(" <head>");
        w.println("</head>");
        w.println("<body>");

        for (int i = 0; i < 3; i++) {
            w.println("<h1>당신은 "+ msg + "입니다.");
        }


        w.println("</body>");
        w.println("<html>");
    }
}
