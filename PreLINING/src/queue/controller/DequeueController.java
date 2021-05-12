package queue.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import log.service.LogService;
import log.service.LogServiceImpl;
import model.Member;
import model.Queue;
import queue.service.QueueService;
import queue.service.QueueServiceImpl;

/**
 * Servlet implementation class DequeueController
 */
@WebServlet("/DequeueController")
public class DequeueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DequeueController() {
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
		LogService logservice = new LogServiceImpl();
		HttpSession session = request.getSession();
		int type = (int)session.getAttribute("memberType");
		boolean flag_qck = false;
		boolean complete = false;
		boolean frominfo = (boolean)session.getAttribute("frominfo");
		session.setAttribute("frominfo", frominfo);
		
		int qnum = 0;
		String g_name = "";
		Member m = (Member) session.getAttribute("m");
		Queue q = new Queue();
		
		if(type == 1) {	// 구매자일 때
			flag_qck = (boolean)session.getAttribute("flag_qck");
			g_name = m.getNickname();
			q = qservice.getQueue(g_name);
			qnum = q.getNum();
		}
		
		else if(type == 2) {	// 판매자일 때
			int log = Integer.parseInt(request.getParameter("log"));
			qnum = Integer.parseInt(request.getParameter("qnum"));//Queue의 num
			g_name = request.getParameter("g_name");			// 가게로부터 고객 이름 파라미터로 받아옴
			q = qservice.getQueue(g_name);
			if(log==1)
				logservice.addLog(q); //방문완료시 해당 q 객체를 log에 저장(log==1일 때만)
		}

		qservice.deQueue(qnum);		// queue테이블에 해당 대기열 삭제
		Queue deq_test = qservice.getQueue(g_name);	// 대기열 삭제 확인 객체
		
		if(deq_test==null) {	// 확인된 대기열이 없으면
			flag_qck = false;	// 삭제 완료 false로 표시
			if(type==2) { //판매자이면서 log=1일때가 방문완료(log=0은 방문취소)
				complete=true; 
			}
		}
		session.removeAttribute("myqnum");
		session.removeAttribute("mypnum");
		session.removeAttribute("bookshop");
		
		session.setAttribute("flag_qck", flag_qck);
		request.setAttribute("complete", complete);
		
		String path;
		if(flag_qck==false || complete==true) {
			path="/SendSmsToOne";
		}
		else {
		path = "/web/queue/deqCheck.jsp";
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
