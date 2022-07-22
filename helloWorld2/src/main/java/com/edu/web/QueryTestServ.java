package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/querytest")
public class QueryTestServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id"); // parameter:id 값을 반환
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");

		out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID: " + id + "</p>");
		out.print("<p>비밀번호: " + pwd + "</p>");
		out.print("<p>이름: " + name + "</p>");
		out.print("취미: <ul>");
		for (int i = 0; i < hobby.length; i++) {
			out.print("<li>" + hobby[i] + "</li>");
		}
		out.print("</ul>");
		out.print("<p>성별: " + gender + "</p>");
		out.print("<p>종교: " + religion + "</p>");
		out.print("<p>자기소개: " + introduction + "</p>");
		out.print("<p>질의문자열: " + req.getQueryString()+ "</p>");
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
/*
		String id = req.getParameter("id"); // parameter:id 값을 반환
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");

		out.print("<h3>입력받은 값</h3>");
		out.print("<p>ID: " + id + "</p>");
		out.print("<p>비밀번호: " + pwd + "</p>");
		out.print("<p>이름: " + name + "</p>");
		out.print("취미: <ul>");
		for (int i = 0; i < hobby.length; i++) {
			out.print("<li>" + hobby[i] + "</li>");
		}
		out.print("</ul>");
		out.print("<p>성별: " + gender + "</p>");
		out.print("<p>종교: " + religion + "</p>");
		out.print("<p>자기소개: " + introduction + "</p>");
*/
		// post방식 inputstream으로 들어옴
		ServletInputStream sis = req.getInputStream();
		int len = req.getContentLength();
		byte[] buf = new byte[len];
		sis.read(buf, 0, len);
		String queryString = new String(buf);
		out.print("질의문자열: " + queryString);
		sis.close();
		out.close();
	}
}
