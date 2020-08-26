package com.wellsfargo.fsd.ck.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.ck.entity.KitDetail;
import com.wellsfargo.fsd.ck.entity.ProductMaster;
import com.wellsfargo.fsd.ck.exception.CkException;
import com.wellsfargo.fsd.ck.service.KitService;
import com.wellsfargo.fsd.ck.service.KitServiceImpl;
import com.wellsfargo.fsd.ck.service.ProductMasterService;
import com.wellsfargo.fsd.ck.service.ProductMasterServiceImpl;

@WebServlet({"/user","/newuser","/showproducts","/addnewitem","/deleteitem","/showkit","/placeorder","/saveorder","/ordersummary"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitService ks;
	private ProductMasterService pms;
	/*
	private KitDao kitDAO;
	private ProductMasterDao productMasterDao;

	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}
*/
	public void init(ServletConfig config) {
		/*
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config. getServletContext().getInitParameter("jdbcPassword");
		
		this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword); */
		
		this.ks = new KitServiceImpl();
		this.pms = new ProductMasterServiceImpl();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
	//	System.out.println(action);
		//String action = request.getParameter("action");
		
		String viewName = "";
		try {
			switch (action) {
			case "/newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "insertuser":
				viewName = insertNewUser(request, response);
				break;
			case "/showproducts":
				viewName = showAllProducts(request, response);
				break;	
			case "/addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "/deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "/showkit":
				viewName = showKitDetails(request, response);
				break;
			case "/placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "/saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;	
			case "/ordersummary":
				viewName = showOrderSummary(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	
	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("id"));
        double amount=Double.parseDouble(request.getParameter("amount"));
        System.out.println("kitID="+Integer.parseInt(request.getParameter("kitid")));
        KitDetail kd = new KitDetail();
        
        System.out.println(Integer.parseInt(request.getParameter("kitid")));
        kd.setId(1);
        kd.setCoronaKitId(Integer.parseInt(request.getParameter("kitid")));
        System.out.println(Integer.parseInt(request.getParameter("kitid")));
        kd.setProductId(id);
        System.out.println(Integer.parseInt(request.getParameter("id")));
        kd.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        System.out.println(Integer.parseInt(request.getParameter("quantity")));
        kd.setAmount (amount*(kd.getQuantity()));
       
        String view="";
                        
        try {
        	 ks.validateAndAdd(kd);
             request.setAttribute("msg", "Item Got Added!");
        	List<ProductMaster> pm = pms.getAllItems();
            request.setAttribute("items", pm);
            view="showproductstoadd.jsp";
        } catch (CkException e) {
            request.setAttribute("errMsg", e.getMessage());
            view="errPage.jsp";
        }
        return view;
    }

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) {
        
        String view="";
        
        try {
            List<ProductMaster> pm = pms.getAllItems();
            request.setAttribute("items", pm);
            view="showproductstoadd.jsp";
        } catch (CkException e) {
            request.setAttribute("errMsg", e.getMessage());
            view="errPage.jsp";
        }
        
        return view;
    }

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		
		return "newuser.jsp";
	}
}