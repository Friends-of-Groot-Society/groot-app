package com.friendsofgroot.app.webservice;
//import java.time.LocalDateTime;
import java.io.IOException;
//import java.io.PrintWriter; 

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import com.friendsofgroot.app.webservice.LoginWebService;
import com.friendsofgroot.app.webservice.UserWebService;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@Configuration
// Marks this class as configuration
// Specifies which package to scan
//@ComponentScan("com.friendsofgroot.app")
// Enables Spring's annotations
//@WebServlet("/*")
public class RequestHelper   implements WebApplicationInitializer {

		public static void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String uri = request.getRequestURI();
			System.out.println("uri: " + uri);
			switch (uri) {
			case "/serv/coupon":
				CouponServlet c = new CouponServlet();
				c.doPost(request, response);
				System.out.println("coupon");
				break;
			case "/serv/login.do":
				LoginWebService.login(request, response);
				System.out.println("login");
				break;
			case "/serv/logout.do":
				LoginWebService.logout(request, response);
				System.out.println("logout");
				break;
			case "/serv/register.do":
				UserWebService.register(request, response);
				System.out.println("register");
				break;
			case "/serv/update.do":
				UserWebService.update(request, response);
				System.out.println("update");
				break;
			case "/serv/delete.do":
				UserWebService.delete(request, response);
				System.out.println("delete");
				break;
			case "/serv/get.do":
				UserWebService.get(request, response);
				System.out.println("get");
				break;
			case "/serv/getUser.do":
				UserWebService.getUser(request, response);
				System.out.println("getUser");
				break;
			case "/serv/getAll.do":
				UserWebService.getAll(request, response);
				System.out.println("getAll");
				break;
			default:
				UserWebService.getAll(request, response);
				System.out.println("default");
				break;
			}
		}
	/**
	 * Configure the given {@link ServletContext} with any servlets, filters, listeners
	 * context-params and attributes necessary for initializing this web application. See
	 * examples {@linkplain WebApplicationInitializer above}.
	 *
	 * @param servletContext the {@code ServletContext} to initialize
	 * @throws ServletException if any call against the given {@code ServletContext}
	 *                          throws a {@code ServletException}
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//			ctx.register(Config.class);
		ctx.setServletContext(servletContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("RequestHelper", new DispatcherServlet(ctx));
		servlet.addMapping("/serv/serv/*");
		servlet.setLoadOnStartup(1);

		ServletRegistration.Dynamic coupon = servletContext.addServlet("CouponServlet", new DispatcherServlet(ctx));
		coupon.addMapping("/serv/coupon");
		coupon.setLoadOnStartup(1);
	}
}
