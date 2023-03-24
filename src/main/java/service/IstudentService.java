package service;

import dto.Student;

public interface IstudentService {
    public Student searchStudent(Integer sid);
    public String updateStundent(Student student);
    public String deleteStudent(Integer sid);

	//public String addstudent(Student student);
	public String addstudent(Student student);
}
