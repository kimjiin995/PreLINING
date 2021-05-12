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
 * Servlet implementation class AddBoardController
 */
@WebServlet("/AddBoardController")
public class AddBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBoardController() {
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
		Board b = new Board();
		
		String g_name = request.getParameter("g_name");
		String s_name = request.getParameter("s_name");
		String content = request.getParameter("content");
		int memberType = (int)session.getAttribute("memberType");
		if(memberType==1) {
			int score = Integer.parseInt(request.getParameter("score"));
			b = new Board(0, g_name, s_name, null, content, score,0);
			boardservice.addBoard(b);
		}
		else if(memberType==2) { //댓글의 bnum을 받아와서 parent에 넣어서 어느 댓글의 대댓글인지 정보 저장
			try {
				int parent = Integer.parseInt(request.getParameter("parent"));
				b = new Board(0, g_name, s_name, null, content, 0, parent);
				boardservice.addBoard(b);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}

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
