package org.treblereel.sfsbservlet.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.treblereel.sfsbservlet.bean.TestingPassivation;
import org.treblereel.sfsbservlet.domain.TestingObject;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("TestServlet");

		InitialContext ic;
		TestingPassivation testingPassivation;

		try {
			ic = new InitialContext();
			for (int i = 0; i < 1000; i++) {

				testingPassivation = (TestingPassivation) ic.lookup("java:global/sfsbservlet/TestingPassivationBean");
				// testingPassivation.setTestingObject(new TestingObject(" it is
				// in this building"));
				// request.getSession().setAttribute("bean",
				// testingPassivation);

				testingPassivation.setTestingObject(new TestingObject("bean" + i));
				request.getSession().setAttribute("bean" + i, testingPassivation);

			}
		} catch (NamingException e) {
			e.printStackTrace();
		}

		response.sendRedirect("/sfsbservlet/SecondTestServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
