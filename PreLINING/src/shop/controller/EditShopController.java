package shop.controller;

import java.io.IOException;
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
 * Servlet implementation class EditShopController
 */
@WebServlet("/EditShopController")
public class EditShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditShopController() {
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
		HttpSession session = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		Shop s = shopservice.getShop(num);
		String menu = (request.getParameter("menu1")+","
				+request.getParameter("menu2")+","
				+request.getParameter("menu3"));
		String []categoryarr = request.getParameterValues("category");
		String category = "";
		for(int i=0; i < categoryarr.length; i++ ) {
			category += categoryarr[i]+",";
		}

		s.setMenu(menu);
		s.setLocation(request.getParameter("location"));
		s.setPhone(request.getParameter("phone"));
		s.setContent(request.getParameter("content"));
		s.setCategory(category);
		
		shopservice.editShop(s);
		
		String caterotylist[] = category.split(",");
		session.setAttribute("caterotylist", caterotylist);
		String menulist[] = menu.split(",");
		session.setAttribute("menulist", menulist);
		session.setAttribute("shop", s);
		response.sendRedirect(request.getContextPath()+"/web/shop/shopDetail.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
