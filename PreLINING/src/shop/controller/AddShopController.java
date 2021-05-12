package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Shop;
import shop.service.ShopService;
import shop.service.ShopServiceImpl;

/**
 * Servlet implementation class AddShopController
 */
@WebServlet("/AddShopController")
public class AddShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopController() {
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
		Shop s = new Shop();
		
		String img="";
		String menu="";
		String category = "";
		int maxsize = 1024*1024*10;
		MultipartRequest multi = null;
		String uploadPath = 
				"C:\\eclipse\\workspace_web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\webapps\\shop_img\\";
		try {
			multi = new MultipartRequest(request, uploadPath, maxsize, "utf-8",
					new DefaultFileRenamePolicy());
			menu = (multi.getParameter("menu1")+","
					+multi.getParameter("menu2")+","
					+multi.getParameter("menu3"));
			String []categoryarr = multi.getParameterValues("category");

			for(int i=0; i < categoryarr.length; i++ ) {
				category += categoryarr[i]+",";
			}
			
			s.setId(multi.getParameter("id"));
			s.setName(multi.getParameter("name"));
			s.setMenu(menu);
			s.setLocation(multi.getParameter("s_addr"));//location에서 변경
			s.setPhone(multi.getParameter("phone"));
			s.setContent(multi.getParameter("content"));
			s.setCategory(category);
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String file1 = (String) files.nextElement();
				img = multi.getOriginalFileName(file1);
				File file = multi.getFile(file1);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		s.setImg("/shop_img/" + img);
		shopservice.addShop(s);
		s = shopservice.getShop(s.getId());
		String caterotylist[] = category.split(",");
		session.setAttribute("caterotylist", caterotylist);
		String menulist[] = menu.split(",");
		session.setAttribute("menulist", menulist);
		session.setAttribute("myshop", s);
		session.setAttribute("shop", s);
		
		response.sendRedirect(request.getContextPath()+"/web/main.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
