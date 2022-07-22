package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;

@WebServlet("/addMember")
public class AddMemberServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		// 사용자 user_name&user_pass=1234&role=1
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");
		EmpDAO dao = new EmpDAO();
		// get: 수정, post: 입력
		int r;
		if (req.getMethod().toUpperCase().equals("GET")) {
			r = dao.updateMember(name, pass, role);
			if (r < 1) {
				out.println("<script>alert('수정실패!'); location.href='/helloWorld2/html/get.html';</script>");
			} else {
				out.println("<script>alert('수정성공!'); location.href='/helloWorld2/html/get.html';</script>");
			}
		} else {
			r = dao.insertMember(name, pass, role);
			if (r < 1) {
				out.println("<script>alert('등록실패!'); location.href='/helloWorld2/html/post.html';</script>");
			} else {
				out.println("<script>alert('등록성공!'); location.href='/helloWorld2/html/post.html';</script>");
			}
		}

		// DB입력

		resp.getWriter().print("completed");

	}
}
