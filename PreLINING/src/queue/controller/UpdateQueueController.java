package queue.controller;

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
 * Servlet implementation class updateQueueController
 */
@WebServlet("/UpdateQueueController")
public class UpdateQueueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQueueController() {
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
		
		QueueService qservice = new QueueServiceImpl();
		ShopService shopservice = new ShopServiceImpl();		
		HttpSession session = request.getSession(false);
		boolean fromlist = (boolean)session.getAttribute("fromlist");
		boolean frominfo = (boolean)session.getAttribute("frominfo");
		String path="";
		Shop s = (Shop)session.getAttribute("shop");
		String s_name = s.getName();
		int queue_num = qservice.totalQueueByS_Name(s_name);
		
		Member m = (Member)session.getAttribute("m");
		
		Queue q = qservice.getQueue(m.getNickname());
		if(q!=null) {
			int myqnum = qservice.myQueue(q);
			session.setAttribute("myqnum", myqnum);
		}
		shopservice.editQnum(queue_num, s_name);
		s = shopservice.getShopByName(s_name);
		
		if(fromlist) {
			String category = (String)session.getAttribute("getcategory");
			String search = (String)session.getAttribute("getsearch");
			if(search != null) {
				path = "/ShopListController?search="+search;
			}
			else if(category != null) {
				path = "/ShopListController?category="+category;
			}
		}
		else if(frominfo) {
			path = "/DetailQueueController";
		}else {
			path = "/ShopDetailController?num="+s.getNum(); 
		}

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
