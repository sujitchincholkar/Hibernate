package com.bridgelabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.bridgelabz.DAO.UserDao;
import com.bridgelabz.model.User;

/**
 * Servlet implementation class EmailValidator
 */
public class EmailValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailValidator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		JSONObject object=new JSONObject();
		PrintWriter out=response.getWriter();
		response.setContentType("application/json");
		System.out.println(email);
		try {
			object.put("exist",false);
		if(email!=null){
			User user=UserDao.isExist(email);
			if(user!=null){
				object.put("exist",true);
			}else{
				object.put("exist",false);
			}
		}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(object);
		out.print(object);
	
	}
}
