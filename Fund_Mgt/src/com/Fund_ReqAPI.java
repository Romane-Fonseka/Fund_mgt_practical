package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fund_Reqst;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;

/**
 * Servlet implementation class Fund_ReqAPI
 */
@WebServlet("/Fund_ReqAPI")
public class Fund_ReqAPI extends HttpServlet {
	Fund_Reqst fundObj = new Fund_Reqst();
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fund_ReqAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		{ 
			 String output = fundObj.insertFund_Reqst(
			request.getParameter("rName"), 
			request.getParameter("fundingC"), 
			request.getParameter("project"), 
			request.getParameter("email"),
			request.getParameter("Phone"), 
			request.getParameter("address"),
			request.getParameter("AccNo")); 
			response.getWriter().write(output); 
			}
	
	}
	
	private static Map<String, String> getParasMap(HttpServletRequest request) {
		Map<String, String> map =  new HashMap<String, String>();          
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			
			scanner.close();
			
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			} 
					
		}
		 
		catch (Exception e) 
		 { 
		 } 
		return map;
	}
	
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map<String, String> paras = getParasMap(request); 
		
		String output = fundObj.updateFund_ReqstString(
		paras.get("hidItemIDSave").toString(), 
		paras.get("rName").toString(), 
		paras.get("project").toString(), 
		paras.get("email").toString(), 
		paras.get("phone").toString(),
		paras.get("address").toString(),
		paras.get("AccNo").toString()); 
		response.getWriter().write(output); 
		} 


	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//
		Map<String, String> paras = getParasMap(request); 
		 String output = fundObj.deleteFund_Reqst(paras.get("UserID").toString()); 
		response.getWriter().write(output); 
	}

}
