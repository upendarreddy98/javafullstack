package service;

import dao.StudentDaoFactory;
import dto.Student;
import persistence.IstudentDao;

//Persistence logic using JDBC API
public class StudentServiceImpl implements IstudentService{
    private IstudentDao stdDao;
    @Override
    public String addstudent(Student student) {
        stdDao=StudentDaoFactory.getStudentdao();
        return stdDao.addstudent(student);
    }

    @Override
    public Student searchStudent(Integer sid) {
        stdDao=StudentDaoFactory.getStudentdao();
        return stdDao.searchStudent(sid);
    }

    @Override
    public String updateStundent(Student student) {
    	stdDao=StudentDaoFactory.getStudentdao();
        return stdDao.updateStundent(student);
       
    }

    @Override
    public String deleteStudent(Integer sid) {
        stdDao=StudentDaoFactory.getStudentdao();

        return stdDao.deleteStudent(sid);
    }
}
