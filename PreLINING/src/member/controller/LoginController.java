package member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.JoinService;
import member.service.JoinServiceImpl;
import model.Member;
import model.Queue;
import model.Shop;
import queue.service.QueueService;
import queue.service.QueueServiceImpl;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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

		JoinService mservice = new JoinServiceImpl();
		ShopService shopservice = new ShopServiceImpl();
		QueueService qservice = new QueueServiceImpl();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Member m = mservice.getMember(id);
		int type = 0;
		String path = "/web/main.jsp";

		if (m != null && pwd.equals(m.getPwd())) {
			Shop s = shopservice.getShop(id); // 가게 주인이 로그인할 때 내 가게 정보 있나 조회용
			Queue q = qservice.getQueue(m.getNickname());
			type = m.getType();
			if(type==2 && s.getId()!=null) {
				String menu = s.getMenu();
				String menulist[] = menu.split(",");
				session.setAttribute("menulist", menulist);
			}
			String s_name = s.getName();
			session.setAttribute("id", id);
			session.setAttribute("memberType", type);
			session.setAttribute("m", m);
			
			session.setAttribute("s_name", s_name);
			session.setAttribute("myshop", s); //가게 주인이 로그인 할때 자기 가게 정보 저장
			if(q != null) {
				boolean flag_qck=true;
				int myqnum = qservice.myQueue(q);
				SimpleDateFormat format1 = new SimpleDateFormat("HH시 mm분");
				s = shopservice.getShop(q.getSnum());
				session.setAttribute("bshopnum",q.getSnum());
				session.setAttribute("flag_qck", flag_qck);
				session.setAttribute("bookshop", s); //예약가게 정보
				session.setAttribute("myqnum", myqnum); // 현재 내 대기열 순위
				session.setAttribute("booktime", format1.format(q.getR_date())); 
				
			}
		}

		dispatcher = request.getRequestDispatcher(path);
		if(dispatcher!=null) {
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
