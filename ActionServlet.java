package iCalGenerator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActionServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String url = request.getParameter("url");
			if(url.substring(0,4).equals("plan"))
				url = "http://www." + url;
			ParseUzSite web = new ParseUzSite(url);
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println(web.printEvents());
		}catch(Exception e) { response.getWriter().print("bad url address"); }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
