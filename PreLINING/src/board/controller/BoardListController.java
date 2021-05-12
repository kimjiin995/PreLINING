package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Buffer;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import model.Board;
import model.Shop;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/BoardListController")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardListController() {
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

		ShopService shopservice = new ShopServiceImpl();
		BoardService boardservice = new BoardServiceImpl();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;

		Shop s = (Shop)session.getAttribute("shop");
		ArrayList<Board> boardlist = boardservice.getAllByS_name(s.getName());
		ArrayList<Board> boardbuffer = new ArrayList<Board>();
		float scoreavg=0;
		int i=0;
		
		if(boardlist.size()!=0) {
			scoreavg=boardservice.getAvgScoreByS_name(s.getName());
			shopservice.editScore(scoreavg, s.getName());
			s = shopservice.getShop(s.getNum());
			
			for(i=0; i<boardlist.size(); i++) {
				if(boardlist.get(i).getParent() != 0) {
					boardbuffer.add(boardlist.get(i));
					boardlist.remove(i);
					i--;
				}	
			}

			int size = boardlist.size()+boardbuffer.size();
			for(i=0; i < size; i++) {
				for(int j=0; j<boardbuffer.size();j++) {
					if(boardlist.get(i).getNum()==boardbuffer.get(j).getParent()) {
						if(i == size-1) {
							boardlist.add(boardbuffer.get(j));
						}else
							boardlist.add(i+1,boardbuffer.get(j));
					}
				}
			}
		}


		session.setAttribute("shop", s);
		request.setAttribute("boardlist", boardlist);

		dispatcher = request.getRequestDispatcher("/web/board/boardList.jsp");
		if(dispatcher != null) 
			dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
