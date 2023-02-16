package com.friendsofgroot.app.webservice;

import com.friendsofgroot.app.models.User;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@Configuration
// Marks this class as configuration
// Specifies which package to scan
//@ComponentScan("com.friendsofgroot.app")
// Enables Spring's annotations
@WebServlet("/serv/*")
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MasterServlet() {
		super();
		System.out.println("masterServlet: /servproject1");

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		setAccessControlHeaders(response);
//		PrintWriter writer = response.getWriter();
//		writer.write("test response from myServlet");
		User u = new User();
		HttpSession sess = request.getSession();
		sess.setAttribute("user", u );
		sess.setMaxInactiveInterval(3600);
		sess.setAttribute("m-owner", "{'username', 'tom'},{'ordernum','222'}");
		System.out.println("MasterServlet: " + sess.getAttribute("m-owner"));
		System.out.println("MasterServlet: " + sess.getAttribute("user"));

		RequestHelper.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// for Preflight
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setAccessControlHeaders(resp);
		resp.setStatus(HttpServletResponse.SC_OK);
	}
//
	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, HEAD, OPTIONS");
	}
// https://chrome.google.com/webstore/detail/moesif-orign-cors-changer/digfbfaphojjndkpccljibejjbppifbc?hl=en-US

}
