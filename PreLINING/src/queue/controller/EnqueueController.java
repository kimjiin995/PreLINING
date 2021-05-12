package queue.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class EnqueueController
 */
@WebServlet("/EnqueueController")
public class EnqueueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnqueueController() {
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
		
		/*only 구매자만 대기열 추가 가능*/
		ShopService shopservice = new ShopServiceImpl();
		QueueService qservice = new QueueServiceImpl();
		HttpSession session = request.getSession();
		
		/* 구매자로부터 (nickname, 가게이름, 인원 수)를 파라미터로 받아와야 함 */
		Member m = (Member)session.getAttribute("m");
		Shop s = (Shop) session.getAttribute("shop");
		String s_name = "";
		boolean fromlist = (boolean)session.getAttribute("fromlist");
		if(fromlist) {
			s_name = request.getParameter("s_name");
			s = shopservice.getShopByName(s_name);
			session.setAttribute("shop", s);
		}
		s_name = s.getName();
		String g_name = m.getNickname();
		String g_phone = m.getPhone();
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		
		boolean flag_qck = false;	// 대기열 추가 확인 변수(초기 false)
		
		Queue q = new Queue(0, s_name, g_name, g_phone, pnum, s.getNum(), null);
		qservice.enQueue(q);		// queue 테이블에 해당 대기열 추가
		Queue enq_test = qservice.getQueue(g_name);	// 대기열 신청 확인 객체
		if(enq_test != null) {		// 확인된 대기열이 있으면
			flag_qck = true;	// 추가 완료 true로 표시
		}
		session.setAttribute("bookshop", s);
		session.setAttribute("bshopnum", s.getNum());
		session.setAttribute("flag_qck", flag_qck); 
		String path = "/sendsms";	
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
