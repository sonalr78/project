import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import portal.Student;
import portal.StudentDao;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet 
{
private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException 
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String Course_Id= request.getParameter("Course_Id");
String Course_Name = request.getParameter("Course_Name");
String Course_Duration = request.getParameter("Course_Duration");
String Course_Fees = request.getParameter("Course_Fees");

Student obj=new Student();
obj.setCourse_Id(Course_Id);
obj.setCourse_Name(Course_Name);
obj.setCourse_Duration(Course_Duration);
obj.setCourse_Fees(Course_Fees);


int n =StudentDao.save(obj);
/*if(Course_Fees.isEmpty())

{
RequestDispatcher req = request.getRequestDispatcher("Student.jsp");
out.println("<font color=red>Please fill all the fields</font>");
req.include(request, response);
}
else*/
{
RequestDispatcher req = request.getRequestDispatcher("Student1.jsp");
req.forward(request, response);
}

}
}
