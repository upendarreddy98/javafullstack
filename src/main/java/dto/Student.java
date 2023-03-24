package dto;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID=1L;
  private String sid;
    private String sname;
    private String sage;
    private String saddress;

    public String getSid() {
        return sid;
    }

    public void setSid(String i) {
        this.sid = i;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String i) {
        this.sage = i;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Student{" +sid+" "+
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                '}';
    }
}
