package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Game;

/**
 * Servlet implementation class EditGameServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GameShopHelper gsh = new GameShopHelper();
		String publisher = request.getParameter("publisher");
		String gameName = request.getParameter("gameName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Game toUpdate = gsh.searchForGameById(tempId);
		toUpdate.setPublisher(publisher);
		toUpdate.setGameName(gameName);
		gsh.updateItem(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
