package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServiceFactory.StudentServiceFactory;
import dto.Student;
import service.IstudentService;
@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() 
    {
        super();
       
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			doProcess(request,response);
	}

	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doProcess(request,response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		IstudentService stdService=StudentServiceFactory.getstudentService();
		System.out.println("Request URI::"+request.getRequestURI());
		System.out.println("Request URI::"+request.getPathInfo());
		if(request.getRequestURI().endsWith("addform")) 
		{
			//String sid=request.getParameter("sid");
			String sage=request.getParameter("sage");
			String sname=request.getParameter("sname");
			String saddr=request.getParameter("saddr");
			
			Student student =new Student();
			student.setSage(sage);
			student.setSname(sname);
			student.setSaddress(saddr);
			
			String status=stdService.addstudent(student);
			PrintWriter out=response.getWriter();
				if(status.equals("success"))
				{
					out.println("<h1 style='color:green;text-align:center;'>REGISTER SUCCESSFULL</h1>");
				
				}
				else {
					out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAILED</h1>");
					
				}
				out.close();	
			
		}
		if(request.getRequestURI().endsWith("searchform")) {
			String Ssid=request.getParameter("sid");
			Student student=stdService.searchStudent(Integer.parseInt(Ssid));
			PrintWriter out=response.getWriter();
			if(student!=null){
				out.println("<body>");
				out.println("<center>");
				out.println("<table border='1'>");
				//out.println("<tr><th>SID</th><td>"+Ssid+"</td></tr>");
				out.println("<tr><th>NAME</th><td>"+student.getSname()+"</td></tr>");
				out.println("<tr><th>AGE</th><td>"+student.getSage()+"</td></tr>");
			
				out.println("<tr><th>Address</th><td>"+student.getSaddress()+"</td></tr>");
				out.println("</center");
			
				out.println("</body>");
				
			}
	
		else {
			out.println("<h1 style='color:red;text-align:center;'>No SID</h1>");
			
		}
		out.close();
		}
		
		if(request.getRequestURI().endsWith("deleteform"))
		{
			String ssid=request.getParameter("sid");
			String status=stdService.deleteStudent(Integer.parseInt(ssid));
			PrintWriter out=response.getWriter();
			if(status.equals("success")){
				out.println("<body>");
				out.println("<center>");
				out.println("<h1 style='color:green;texat-align:center;'>Record Deleted Successfully</h1>");
			
				out.println("</center");
			
				out.println("</body>");
				
			}
	
		else if(status.equals("not found")) {
			out.println("<body>");
			out.println("<h1 style='color:red;text-align:center;'>Record NOT FOUND</h1>");
			out.println("</body>");
			
		}
		else {
			out.println("<h1 style='color:red;text-align:center;'>Record Not Deleted Successfully</h1>");
		out.close();
		}
			
			
		}
		
		if(request.getRequestURI().endsWith("editform")) {
			String sid=request.getParameter("sid");
			Student student=stdService.searchStudent(Integer.parseInt(sid));
			PrintWriter out=response.getWriter();
			if(student!=null)
			{
				out.println("<body>");
				out.println("<center>");
				out.println("<form metho='POST' action='./controller/updateRecord'");
				out.println("<table>");
				
				out.println("<tr><th>ID</th><td>"+student.getSid()+"</td></tr>");
				out.println("<input type='hidden' name='sid' value='"+student.getSid()+"'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='sname' value='"+student.getSname()
				+"'/></td></tr><br/>");
				out.println("<tr><th>AGE</th><td><input type='text' name='sage' value='"+student.getSage()
				+"'/></td></tr><br/>");
				out.println("<tr><th>Address</th><td><input type='text' name='saddr' value='"+student.getSaddress()
				+"'></td></tr><br/>");
				out.println("<tr><td><td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			}
			else {
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record Not Available for given id::"+sid+"</h1>");
				out.println("</body>");
				
			}
			out.close();
			
		}
		if(request.getRequestURI().endsWith("updateRecord")) {
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String sage=request.getParameter("sage");
			String saddr=request.getParameter("saddr");
			System.out.println(sid);
			PrintWriter out=response.getWriter();
			System.out.println(sname);
			System.out.println(sage);
			System.out.println(saddr);
			Student student=new Student();
			//student.setSid(Integer.parseInt(sid));
			student.setSid(sid);
			student.setSname(sname);
			student.setSage(sage);
			student.setSaddress(saddr);
			String status=stdService.updateStundent(student);
			if(status.equals("success"))
			{
				out.println("<h1 style='color:green;text-align:center;'>Student record Updated Successfully</h1>");
			
			}
			else {
				out.println("<h1 style='color:red;text-align:center;'>REGISTRATION Not updated FAILED</h1>");
				
			}
				
	out.close();
			
		}
		
		
	}
	

}
