package ServiceFactory;

import service.IstudentService;
import service.StudentServiceImpl;

//connection con=DriverManager.getConnection(url,username,password)
public class StudentServiceFactory {
  private StudentServiceFactory()
    {

    }
private static IstudentService studentService=null;
    public static IstudentService getstudentService()
    {
        //singleton pattern code
        if(studentService==null){
            studentService=new StudentServiceImpl();
        }
        return studentService;
    }
}
