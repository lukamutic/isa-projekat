package isa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import isa.dao.AdDtoDao;
import isa.dao.UserDao;
import isa.entity.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
 
    public UserServlet() {
        super();
        userDao = new UserDao();
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
			save(request, response);
			getLogin(request, response);
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
			
		case "login":
			login(request, response);
			break;
			
		case "logout":
			logout(request, response);
			break;
	
		default:
			break;
		}	
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setRole("user");
		user.setActive(true);
		userDao.save(user);		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.delete(id);		
	}

	private void getForDelete(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-delete.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("user", userDao.getById(id));
		dispatcher.forward(request, response);	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));		
		userDao.update(id, user);		
	}

	private void getForUpdate(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-update.jsp");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("user", userDao.getById(id));
		dispatcher.forward(request, response);			
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		request.setAttribute("list", userDao.list());
		dispatcher.forward(request, response);		
	}
	
	private void displayError(Exception err,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
		request.setAttribute("message", err.getMessage());
		dispatcher.forward(request, response);		
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		User user = userDao.login(email, password);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-login.jsp");
		
		if(user != null) {
			request.getSession().setAttribute("user", user);
			dispatcher = request.getRequestDispatcher("ad-list.jsp");
			request.setAttribute("ads", new AdDtoDao().list());
		} 
		
		dispatcher.forward(request, response);		
	}
	
	private void getLogin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-login.jsp");
		dispatcher.forward(request, response);			
	}

}
