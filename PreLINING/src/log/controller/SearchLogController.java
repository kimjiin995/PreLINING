package log.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Log;
import model.Member;
import model.Shop;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;
import log.service.LogService;
import log.service.LogServiceImpl;

/**
 * Servlet implementation class SearchLogController
 */
@WebServlet("/SearchLogController")
public class SearchLogController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchLogController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		ShopService shopservice = new ShopServiceImpl();
		LogService logservice = new LogServiceImpl();
		HttpSession session = request.getSession();

		Member m = (Member)session.getAttribute("m");
		String g_name = m.getNickname();
		ArrayList<Log> loglist = logservice.getByG_Name(g_name);
		ArrayList<Shop> vlist = new ArrayList<Shop>();
		if(loglist.size() != 0) {
			for(int i=0; i < loglist.size(); i++) {
				Shop s = shopservice.getShop(loglist.get(i).getSnum());
				vlist.add(s);
			}
		}
		session.setAttribute("vlist", vlist);

		String path = "/web/log/logList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
