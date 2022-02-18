package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		GameShopHelper gsh = new GameShopHelper();
		String act = request.getParameter("doThisToItem");

		String path = "/viewAllGamesServlet";
		if (act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Game gameToDelete = gsh.searchForGameById(tempId);
				gsh.deleteGame(gameToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a game");
			}
		} else if (act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Game itemToEdit = gsh.searchForGameById(tempId);
				request.setAttribute("gameToEdit", itemToEdit);
				path = "/edit-game.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to Select a Game");
			}
		} else if (act.equals("Add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);

	}

}
