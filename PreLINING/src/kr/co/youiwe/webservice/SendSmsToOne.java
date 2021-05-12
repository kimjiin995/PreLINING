package kr.co.youiwe.webservice;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.youiwe.webservice.SendSms.CEncrypt;
import model.Member;
import model.Queue;
import model.Shop;
import queue.service.QueueService;
import queue.service.QueueServiceImpl;

/**
 * Servlet implementation class SendSmsToOne
 */
@WebServlet("/SendSmsToOne")
public class SendSmsToOne extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSmsToOne() {
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

      String smsID= "kimjiin2329";   
      String smsPW="zz4051";


      ServiceSMSSoapProxy sendsms = new ServiceSMSSoapProxy();
      HttpSession session = request.getSession();
      int type = (int)session.getAttribute("memberType");
      String s_name ="";
      if(type==1) {
         Shop s = (Shop) session.getAttribute("shop");
         s_name = s.getName();
      }
      else if(type==2) {
         s_name = (String)session.getAttribute("s_name");
      }
         QueueService qservice = new QueueServiceImpl();
         ArrayList<String> list = qservice.selectOne(s_name);
         if(list.size()!=0) {
            String g_name = list.get(0);
            String g_phone = list.get(1);
            
            try{
               String senderPhone= "01023293695";
               String receivePhone= g_phone;
               String smsContent= g_name + "님 예약하신 '" + s_name  + "' 의  "
                     + "해당순번이 되었습니다. 늦지 않게 방문해주시기 바랍니다.";
               String test1 = (smsID+smsPW+receivePhone);
               CEncrypt encrypt = new CEncrypt("MD5",test1);
               java.lang.String send=sendsms.sendSMS(smsID,encrypt.getEncryptData(), senderPhone, receivePhone, smsContent);
               System.out.println("결과코드:"+send);
         
            }catch(Exception e){
               System.out.println("Exception in main:" +e);
            }
         }
      
      String path = "/web/queue/deqCheck.jsp";   
      RequestDispatcher dispatcher = request.getRequestDispatcher(path);
      if(dispatcher != null) {
         dispatcher.forward(request, response);
      }
   }

   class CEncrypt
   {
      MessageDigest md;
      String strSRCData = "";
      String strENCData = "";

      public CEncrypt(){}
      //인스턴스 만들 때 한방에 처리할 수 있도록 생성자 중복시켰습니다. 
      public CEncrypt(String EncMthd, String strData)
      {
         this.encrypt(EncMthd, strData);
      }

      //암호화 절차를 수행하는 메소드입니다.
      public void encrypt(String EncMthd, String strData)
      {
         try
         {
            MessageDigest md = MessageDigest.getInstance(EncMthd); // "MD5" or "SHA1"
            byte[] bytData = strData.getBytes();
            md.update(bytData);

            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for(int i =0;i<digest.length;i++)
            {
               strENCData = sb.append(Integer.toString((digest[i]&0xff) + 0x100, 16).substring(1)).toString();
            }
         }catch(NoSuchAlgorithmException e)
         {
            System.out.print("암호화 알고리즘이 없습니다.");
         };

         //나중에 원본 데이터가 필요할지 몰라서 저장해 둡니다.
         strSRCData = strData;
      }

      //접근자 인라인 함수(아니, 메소드)들입니다.
      public String getEncryptData(){return strENCData;}
      public String getSourceData(){return strSRCData;}

      //데이터가 같은지 비교해주는 메소드입니다.
      public boolean equal(String strData)
      {
         //암호화 데이터랑 비교를 하던, 원본이랑 비교를 하던 맘대로....
         if(strData == strENCData) return true;
         return false;
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