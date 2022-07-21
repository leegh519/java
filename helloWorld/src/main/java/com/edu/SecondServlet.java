package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second.do")
public class SecondServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req : 요청정보 객체

		// resp : 응답정보 객체
		// 응답문서 타입=html, 인코딩 utf=8로 설정
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter(); // 출력스트림
		out.print("<h3>Hello, I'm servlet</h3>");
		out.print("<h3>안녕하세요. 서블릿입니다</h3>");
	}

}
