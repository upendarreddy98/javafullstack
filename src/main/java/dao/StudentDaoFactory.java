package dao;

import persistence.IstudentDao;
import persistence.StudentDaoImpl;

public class StudentDaoFactory {
    private StudentDaoFactory() {}
    private static IstudentDao studentDao=null;
    public static IstudentDao getStudentdao() {
        if (studentDao == null) {
            studentDao=new StudentDaoImpl();
        }

       return studentDao;

    }
}
