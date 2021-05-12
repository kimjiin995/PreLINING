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

import model.Member;
import model.Queue;
import model.Shop;
import queue.service.QueueService;
import queue.service.QueueServiceImpl;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class DetailQueueController
 */
@WebServlet("/DetailQueueController")
public class DetailQueueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailQueueController() {
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
		
		/*구매자,판매자의 예약 조회*/
		
		QueueService service = new QueueServiceImpl();
		ShopService shopservice = new ShopServiceImpl();
		HttpSession session = request.getSession();
		
		int type = (int)session.getAttribute("memberType");	// 1 : 구매자, 2 : 판매자
		Member m = (Member)session.getAttribute("m");
		int seq_wait = 0;	// 대기 순번 변수
		
		
		if(type == 1) {	// 구매자
			String g_name =m.getNickname();
			Queue q = service.getQueue(g_name);
			if(q==null) {
				seq_wait = 0;
			}else {
				seq_wait = service.myQueue(q);
			}
			session.setAttribute("frominfo", true);
			session.setAttribute("fromlist", false);
			request.setAttribute("q", q);
			request.setAttribute("seq_wait", seq_wait);
		}
		else if(type == 2){ //판매자
			Shop s = shopservice.getShop(m.getId());
			ArrayList<Queue> qlist = service.getByS_Name(s.getName());
			int queue_num = service.totalQueueByS_Name(s.getName());
			shopservice.editQnum(queue_num, s.getName()); //가게에서 방문완료시 shop의 queuenum 업데이트
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
