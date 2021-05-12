package shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Queue;
import model.Shop;
import queue.service.QueueService;
import queue.service.QueueServiceImpl;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class ShopDetailController
 */
@WebServlet("/ShopDetailController")
public class ShopDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopDetailController() {
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
		QueueService qservice = new QueueServiceImpl(); //QueueDao
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		session.setAttribute("fromlist", false);
		session.setAttribute("frominfo", false);
		int num =Integer.parseInt( request.getParameter("num")); // shopList.jsp에서 가게 하나를 클릭할때 num값을 받아와서 이를 통해 Shop 객체 하나 얻는 것
		Shop s = shopservice.getShop(num);
		String menulist[] = new String[3];
		if(s != null) {
			String menu = s.getMenu();
			menulist = menu.split(",");
		}
		
		//다시 로그인 했을 때 예약한 가게 있는지 확인
		Member m = (Member)session.getAttribute("m");
		String g_name = m.getNickname();
		
		if(s.getId()==m.getId()) { 
			session.setAttribute("myshop", s);
		}
		Queue q = qservice.getQueue(g_name);
		boolean flag_qck = false;
		
		if(q != null) {		// 확인된 대기열이 있으면
			flag_qck = true; // 예약상태(true)로 변경
			int bshopnum = 0;
			if(q.getS_name().equals(s.getName())) { //대기열 가게 이름과 현재 shopDetail의 가게이름이 같으면
				bshopnum = s.getNum();
				int myqnum = qservice.myQueue(q);
				Shop bookshop = shopservice.getShop(bshopnum);
				session.setAttribute("bookshop", bookshop); //예약 가게
				session.setAttribute("myqnum", myqnum);
				session.setAttribute("bshopnum", bshopnum); //예약 가게 num
			}
		}	
		session.setAttribute("flag_qck", flag_qck);
		session.setAttribute("menulist", menulist);
		session.setAttribute("shop", s);
		session.setAttribute("shopnum", s.getNum());

		dispatcher = request.getRequestDispatcher("/web/shop/shopDetail.jsp");
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
