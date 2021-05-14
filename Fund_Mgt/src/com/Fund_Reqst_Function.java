/**
 * 
 */
package com;

import java.sql.Date;

//import javax.print.attribute.standard.Media;
//import javax.print.attribute.standard.MediaSize;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;//com.sun.jersey.*;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//import fund_management.Fund_req;
import model.Fund_Reqst;
import model.insertFund_Reqst;


/**
 * @author Asus

 *
 */

@Path("/Fund_Reqst")
public class Fund_Reqst_Function {
	
	Fund_Reqst fundObj = new Fund_Reqst();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readFund_Reqst() {
		return fundObj.readFund_Reqst();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String insertFund_Reqst(String Fund_ReqstData) {
		
		//Convert the input string to a JSON object
		JsonObject fundObj = new JsonParser().parse(Fund_ReqstData).getAsJsonObject();
		
				//Read the values from the JSON object
			 
				String rName = fundObj.get("ResercherName").toString();
				String fundingC = fundObj.get("FundingCompany").toString();
				String project = fundObj.get("ProjectName").toString();
				String email = fundObj.get("Email").toString();
				String Phone = fundObj.get("ContactNo").toString();
				String address = fundObj.get("Address").toString();
				String AccNo = fundObj.get("AccountNo").toString();
			 
				String output = fundObj.insertFund_Reqst(rName,  fundingC,  project, email, Phone, address, AccNo);
			 
				return output;
				
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateFund_Reqst(String Fund_ReqstData) {
		
		//Convert the input string to a JSON object
		JsonObject fundObj = new JsonParser().parse(Fund_ReqstData).getAsJsonObject();
		//Read the values from the JSON object
		//String rName = fundobj.insertFund_ReqstData("ResercherName").toString();
		
		String rName = fundObj.get("ResercherName").getAsString();
		String fundingC = fundObj.get("FundingCompany").toString();
		String project = fundObj.get("ProjectName").toString();
		String email = fundObj.get("Email").toString();
		String Phone = fundObj.get("ContactNo").toString();
		String address = fundObj.get("Address").toString();
		String AccNo = fundObj.get("AccountNo").toString();
	 
		String output = fundObj.updateFund_Reqst(rName, fundingC, project, email, Phone, address, AccNo);
	 
		return output;
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String deleteFund_Reqst(String Fund_ReqstData)
	{
		//Convert the input string to a JSON object
		JsonObject fundObj = new JsonParser().parse(Fund_ReqstData).getAsJsonObject();
		//Read the values from the JSON object
	 
		Integer UserID = fundObj.get("UserID").getAsInt();
	 
		String output = fundObj.deleteFund_Reqst(UserID);
	 
		return output;
	
	}
	

}
