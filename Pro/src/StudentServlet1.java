import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import portal.Student1;
import portal.StudentDao2;

@WebServlet("/StudentServlet1")
public class StudentServlet1 extends HttpServlet 
{
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
{
response.setContentType("text/html");
//PrintWriter out = response.getWriter();
String course_id= request.getParameter("course_id");
String Stream_name = request.getParameter("Stream_name");
System.out.println(course_id+" "+Stream_name);

Student1 obj=new Student1();
obj.setCourse_id(course_id);
obj.setStream_name(Stream_name);
System.out.println(obj.getCourse_id()+" "+obj.getStream_name());


int n =StudentDao2.save(obj);
System.out.println(n);
/*{
RequestDispatcher req = request.getRequestDispatcher("Student2.jsp");
out.println("<font color=red>Please fill all the fields</font>");
req.include(request, response);
}
else*/
{
RequestDispatcher req = request.getRequestDispatcher("Student3.jsp");
req.forward(request, response);
}

}
}