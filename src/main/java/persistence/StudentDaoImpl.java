package persistence;
import dto.Student;
import persistence.upendarreddy.jdbcutil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IstudentDao {
    Connection connection=null;
    PreparedStatement pstmt=null;
    ResultSet resultSet=null;
    Student student=null;
    @Override
    public String addstudent(Student student) {
        String sqlInsertQuery="Insert into student values(?,?,?,?)";

        try {
            //object injected from the jdbcutil file.
            connection=jdbcutil.getjdbcConnection();

            if(connection!=null)
            {
                pstmt=connection.prepareStatement(sqlInsertQuery);
            }
            if(pstmt!=null){
            	pstmt.setString(1,student.getSid());
                pstmt.setString(2,student.getSname());
                pstmt.setString(3,student.getSage());
                pstmt.setString(4,student.getSaddress());
                int rowAffected =pstmt.executeUpdate();
                if(rowAffected==1)
                {
                    return "success";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "failure";
    }

    @Override
    public Student searchStudent(Integer sid) {
    	String sqlSelectQuery = "select sname,sage,saddr from student where id=?";
    	Student student=null;
        //object injected from the jdbcutil file.
     
        try {
        	   connection = jdbcutil.getjdbcConnection();

            if (connection != null) {
                pstmt = connection.prepareStatement(sqlSelectQuery);
            }
            if (pstmt != null) {
                pstmt.setInt(1, sid);

            }
            if(pstmt!=null)
            {
                resultSet=pstmt.executeQuery();
            }
            if(resultSet!=null)
            {
                if(resultSet.next())
                {
                    student=new Student();
                    //copy result set data to student object
                    //resultSet.getInt(1);
                    student.setSid(resultSet.getString(1));
                    student.setSname(resultSet.getString(2));
                    student.setSage(resultSet.getString(3));
                    student.setSaddress(resultSet.getString(4));
                    return student;
                }
            }
        } catch (SQLException | IOException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

   // @Override
//    public String updateStundent(Student student){
//        return null;
//    }

    @Override
    public String deleteStudent(Integer sid) {
        String sqlInsertQuery="delete from student where id=?";

        try {
            //object injected from the jdbcutil file.
            connection=jdbcutil.getjdbcConnection();

            if(connection!=null)
            {
                pstmt=connection.prepareStatement(sqlInsertQuery);
            }
            if(pstmt!=null){
               pstmt.setInt(1,sid);
                int rowAffected =pstmt.executeUpdate();
                if(rowAffected==1)
                {
                    return "success";
                }
                else{
                    return "not found";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "failure";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "failure";
    }

    @Override
	public String updateStudent(Student student) {
		String sqlUpdateQuery = "update student set name=?,age=?,address=? where id=?";
		try {
			 connection=jdbcutil.getjdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setString(3, student.getSage());
				pstmt.setString(4, student.getSaddress());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} 
		catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}

	@Override
	public String updateStundent(Student student) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
