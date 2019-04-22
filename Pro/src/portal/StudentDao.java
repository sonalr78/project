package portal;
import java.sql.*;

import portal.Student;
import portal.StudentDao;

public class StudentDao 
{
public static Connection getConnection()
{
Connection con=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
}
catch(Exception e)
{System.out.println(e);}
return con;
}

public static int save(Student obj)
{
int status=0;
try{
Connection con=StudentDao.getConnection();
PreparedStatement ps=con.prepareStatement ("insert into Course "+" (Course_Id,Course_Name,Course_Duration,Course_Fees) values (?,?,?,?)");
ps.setString(1, obj.getCourse_Id());
ps.setString(2, obj.getCourse_Name());
ps.setString(3, obj.getCourse_Duration());
ps.setString(4, obj.getCourse_Fees());

status=ps.executeUpdate();
con.close();
}
catch(Exception ex){ex.printStackTrace();}
return status;
}
}

