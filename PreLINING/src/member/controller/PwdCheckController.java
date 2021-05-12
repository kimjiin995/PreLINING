package member.controller;

import java.io.IOException;

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

/**
 * Servlet implementation class PwdCheckController
 */
@WebServlet("/PwdCheckController")
public class PwdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PwdCheckController() {
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

		JoinService service = new JoinServiceImpl();
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher = null;

		String pwd = (String)request.getParameter("pwd");

		String check = (String)request.getParameter("check");
		String id = (String)session.getAttribute("id");
		Member m = service.getMember(id);

		if(m!=null && pwd.equals(m.getPwd())) {
			if(check.equals("edit")) {
				request.setAttribute("m", m);
				dispatcher = request.getRequestDispatcher("/web/member/editForm.jsp");
				if(dispatcher!=null) {
					dispatcher.forward(request, response);
				}
			}
		}	
		else {
			dispatcher = request.getRequestDispatcher
					("/member/PwdCheck_fail.jsp");
			if(dispatcher!=null) {
				dispatcher.forward(request, response);
			}
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
