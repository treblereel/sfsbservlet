package org.treblereel.sfsbservlet.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.treblereel.sfsbservlet.bean.TestingPassivation;

public class SecondTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondTestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SecondTestServlet");

		TestingPassivation testingPassivation;

		for (int i = 0; i < 1000; i++) {
			testingPassivation = (TestingPassivation) request.getSession().getAttribute("bean" + i);
			System.out.println("TestingObject property of bean: " + i + " : "
					+ testingPassivation.getTestingObject().getTestingProperty());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
