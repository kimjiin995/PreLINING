package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import model.Board;

/**
 * Servlet implementation class EditBoardController
 */
@WebServlet("/EditBoardController")
public class EditBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		BoardService boardservice = new BoardServiceImpl();
		HttpSession session = request.getSession();
		int bnum = 0;
		int score = 0;
		String content = null;
		int memeberType = (int)session.getAttribute("memberType");
		if(memeberType==1) {
			bnum = Integer.parseInt(request.getParameter("bnum"));
			score = Integer.parseInt(request.getParameter("score"));
			content = request.getParameter("content");
		}
		else if(memeberType==2) {
			bnum = Integer.parseInt(request.getParameter("bnum"));
			content = request.getParameter("content");
		}

		Board b = boardservice.getBoard(bnum);

		b.setContent(content);
		b.setScore(score);
		boardservice.editBoard(b);
		
		response.sendRedirect(request.getContextPath()+"/web/shop/shopDetail.jsp");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
