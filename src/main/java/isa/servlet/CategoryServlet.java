package isa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isa.dao.CategoryDao;
import isa.entity.Category;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;
 
    public CategoryServlet() {
        super();
        categoryDao = new CategoryDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processingRequest(request, response);
		} catch (ClassNotFoundException e) {
			displayError(e, request, response);
		} catch (ServletException e) {
			displayError(e, request, response);
		} catch (IOException e) {
			displayError(e, request, response);
		} catch (SQLException e) {
			displayError(e, request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processingRequest(request, response);
		} catch (ClassNotFoundException e) {
			displayError(e, request, response);
		} catch (ServletException e) {
			displayError(e, request, response);
		} catch (IOException e) {
			displayError(e, request, response);
		} catch (SQLException e) {
			displayError(e, request, response);
		}
	}
		
	private void processingRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		String action = request.getParameter("action");
		if(action == null)
			action = "list";
		
		switch (action) {
			
		case "save":
			Category category = new Category();
			category.setName(request.getParameter("name"));
			categoryDao.save(category);
			list(request, response);
			break;
			
		case "list":
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
			
		case "delete":
			delete(request, response);
			list(request, response);
			break;
	
		default:
			break;
		}	
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		categoryDao.delete(id);		
	}

	private void getForDelete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-delete.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("category", categoryDao.getById(id));
		dispatcher.forward(request, response);	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Category category = new Category(id, name);
		categoryDao.update(id, category);		
	}

	private void getForUpdate(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-update.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("category", categoryDao.getById(id));
		dispatcher.forward(request, response);			
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("category-list.jsp");
		request.setAttribute("list", categoryDao.list());
		dispatcher.forward(request, response);		
	}
	
	private void displayError(Exception err,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		request.setAttribute("message", err.getMessage());
		dispatcher.forward(request, response);		
	}
}
