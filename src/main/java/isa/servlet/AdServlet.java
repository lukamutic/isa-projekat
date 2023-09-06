package isa.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isa.dao.AdDao;
import isa.dao.AdDtoDao;
import isa.dao.CategoryDao;
import isa.dao.UserDao;
import isa.entity.Ad;
import isa.entity.User;

@WebServlet("/AdServlet")
public class AdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AdDao adDao;
 
    public AdServlet() {
        super();
        adDao = new AdDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processingRequest(request, response);
		} catch (ClassNotFoundException e) {
			displayError(e, request, response);
		} catch (SQLDataException e) {
			displayError(e, request, response);
		} catch (ServletException e) {
			displayError(e, request, response);
		} catch (IOException e) {
			displayError(e, request, response);
		} catch (SQLException e) {
			displayError(e, request, response);
		} catch (ParseException e) {
			displayError(e, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processingRequest(request, response);
		} catch (ClassNotFoundException e) {
			displayError(e, request, response);
		} catch (SQLDataException e) {
			displayError(e, request, response);
		} catch (ServletException e) {
			displayError(e, request, response);
		} catch (IOException e) {
			displayError(e, request, response);
		} catch (SQLException e) {
			displayError(e, request, response);
		} catch (ParseException e) {
			displayError(e, request, response);
		}
	}
		
	private void processingRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException, ParseException {
		
		String action = request.getParameter("action");
		if(action == null)
			action = "list";
		
		switch (action) {
			
		case "save":
			save(request, response);
			list(request, response);
			break;
			
		case "list":
			if(request.getParameter("search") != null)
				search(request, response);
			else
				list(request, response);		
			break;
			
		case "get-for-update":
			getForUpdate(request, response);		
			break;
			
		case "update":
			update(request, response);
			list(request, response);
			break;
			
		case "get-for-delete":
			getForDelete(request, response);		
			break;
			
		case "get-ad-new":
			getAdNew(request, response);		
			break;
			
		case "delete":
			delete(request, response);
			list(request, response);
			break;
			
		default:
			break;
		}	
	}
	
	private void getAdNew(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		CategoryDao categoryDao = new CategoryDao();
		request.setAttribute("categories", categoryDao.list());
		UserDao userDao = new UserDao();
		User user = userDao.getById(2);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-new.jsp");
		dispatcher.forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ParseException {
		
		Ad ad = new Ad();
		ad.setUserId(Integer.parseInt(request.getParameter("userId")));
		ad.setCategoryId(Integer.parseInt(request.getParameter("category")));		
		
		LocalDate ld = LocalDate.parse(request.getParameter("date"));		
		ad.setDate(Date.valueOf(ld));
		
		ad.setTitle(request.getParameter("title"));
		ad.setDescription(request.getParameter("description"));
		ad.setPrice(Double.parseDouble(request.getParameter("price")));
		ad.setActive(Boolean.parseBoolean(request.getParameter("active")));
		
		adDao.save(ad);		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		adDao.delete(id);		
	}

	private void getForDelete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-delete.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("ad", adDao.getById(id));
		dispatcher.forward(request, response);	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		Ad ad = new Ad();	
		ad.setId(Integer.parseInt(request.getParameter("id")));
		ad.setUserId(Integer.parseInt(request.getParameter("userId")));
		//ad.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
		ad.setDate(Date.valueOf(request.getParameter("date")));
		ad.setTitle(request.getParameter("title"));
		ad.setDescription(request.getParameter("description"));
		ad.setPrice(Double.parseDouble(request.getParameter("price")));
		//ad.setActive(Boolean.parseBoolean(request.getParameter("active")));
		System.out.println(ad);
		adDao.update(ad.getId(), ad);		
	}

	private void getForUpdate(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		CategoryDao categoryDao = new CategoryDao();
		request.setAttribute("categories", categoryDao.list());
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-update.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("ad", adDao.getById(id));
		dispatcher.forward(request, response);			
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-list.jsp");
		request.setAttribute("ads", new AdDtoDao().list());		
		dispatcher.forward(request, response);		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ad-list.jsp");
		String keyWord = (String) request.getAttribute("search");
		System.out.println(keyWord);
		request.setAttribute("ads", new AdDtoDao().search(keyWord));		
		dispatcher.forward(request, response);		
	}
	
	private void displayError(Exception err,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		request.setAttribute("message",err.fillInStackTrace());
		dispatcher.forward(request, response);		
	}
}
