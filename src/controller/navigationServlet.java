package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
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
		
		CarHelper ch = new CarHelper();
		String act = request.getParameter("doThisToCar").toLowerCase();
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car carToEdit = ch.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				getServletContext().getRequestDispatcher("/edit-car.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
			}
		}
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Car carToDelete = ch.searchForCarById(tempId);
				ch.deleteCar(carToDelete);
			} catch (NumberFormatException e) {
				System.out.println("No car selected");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
			}
		}
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
	}

}
