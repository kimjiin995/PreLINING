package queue.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import shop.service.Service;
import shop.service.ServiceImpl;*/
import model.Member;
import model.Queue;
import model.Shop;
import queue.service.QueueService;
import queue.service.QueueServiceImpl;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class SearchQueueController
 */
@WebServlet("/SearchQueueController")
public class SearchQueueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchQueueController() {
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
		QueueService qservice = new QueueServiceImpl();
		HttpSession session = request.getSession();

		int type = (int)session.getAttribute("memberType");	// 1 : 구매자, 2 : 판매자
		int seq_wait = 0;	// 대기 순번 변수

		if(type == 1) {	// 구매자
			Member m = (Member) session.getAttribute("m");
			String g_name = m.getNickname();
			Queue q = qservice.getQueue(g_name);
			seq_wait = qservice.myQueue(q); //현재 내 대기순번
			request.setAttribute("q", q);	
			request.setAttribute("seq_wait", seq_wait);
		}
		else if(type == 2){	// 판매자
			Shop s = (Shop)session.getAttribute("myshop");
			String s_name = s.getName();
			int queue_num = qservice.totalQueueByS_Name(s_name);
			shopservice.editQnum(queue_num, s_name);
			ArrayList<Queue> qlist = qservice.getByS_Name(s_name);
			request.setAttribute("qlist", qlist);
		}

		String path = "/web/queue/queueDetail.jsp";

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
