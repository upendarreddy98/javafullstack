package persistence;
import dto.Student;

public interface IstudentDao {
    public String addstudent(Student student);
    public Student searchStudent(Integer sid);
    public String updateStundent(Student student);
    public String deleteStudent(Integer sid);
	public String updateStudent(Student student);
	


}
