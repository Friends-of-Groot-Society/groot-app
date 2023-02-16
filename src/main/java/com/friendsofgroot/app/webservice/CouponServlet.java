package com.friendsofgroot.app.webservice;

import com.friendsofgroot.app.webservice.AverageModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/coupon")
public class CouponServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        	response.getWriter().print("SUPERSALE");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//        response.getWriter().print("SUPERSALE_POST");
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));

        AverageModel model = new AverageModel();
        int result = model.calculateAverage(num1, num2);
        request.setAttribute("result", result);

       String coupon = request.getParameter("coupon");
       request.setAttribute("discount","Discount for coupon "+coupon+" is 50%" );

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("response.jsp");
//        requestDispatcher.forward(request, response);
       request.getRequestDispatcher("/response.jsp").forward(request,response);
    }
}