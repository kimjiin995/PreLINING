package shop.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shop;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class ShopListController
 */
@WebServlet("/ShopListController")
public class ShopListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopListController() {
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

		ShopService service = new ShopServiceImpl();
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		ArrayList<Shop> list1 = new ArrayList<Shop>();
		ArrayList<Shop> list2 = new ArrayList<Shop>();
		String path = "web/shop/shopList.jsp";
		String search = request.getParameter("search"); // 검색어를 통해 리스트 보여줄 때
		String category = request.getParameter("category"); //카테고리 링크를 통해 리스트 보여줄 때
		session.setAttribute("fromlist", true);
		session.setAttribute("frominfo", false);
		String flag= "0";

		if(search != null){ //검색어를 통해 shopList로 진입하는 경우
				list1 = service.getShopsBySearch(search);
				request.setAttribute("slistbysearch", list1); //검색어 별로 검색된 리스트
				session.setAttribute("getsearch", search);
				if(list1.size()==0) {
					flag= "1";
					request.setAttribute("flag", flag);
				}
		}
		else if(category != null){ //category 이미지를 클릭하여 접속하는 화면
			list2 = service.getShopsByCategory(category);
			request.setAttribute("slistbycategory", list2); //카테고리 별로 검색된 리스
			session.setAttribute("getcategory", category);
			if(list2.size()==0) {
				flag= "1";
				request.setAttribute("flag", flag);
			}
		}else {// 그냥 메인화면 보여줄 때
			list1 = service.getShopsByQnum();
			list2 = service.getShopsByscoreavg();
			request.setAttribute("slistbyqnum", list1); // 메인에서 핫플 보여주기 위한 리스트
			request.setAttribute("slistbyscore", list2); // 메인에서 평점 높은 가게 보여주기 위한 리스트
		}
		
		dispatcher = request.getRequestDispatcher(path); //메인화면으로
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
