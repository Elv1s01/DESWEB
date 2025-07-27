package model.enteties;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private long cod;
    private String name;
    private int workload;
    private List<Student> students = new ArrayList<>();
    
    
    public Discipline(long cod, String name, int workload) {
        this.cod = cod;
        this.name = name;
        this.workload = workload;
    }
    
    public List<Student> getStudents() {
        return students;
    }
    
    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public String toString(){
        return String.format("\nDISCIPLINE COD: %d\nDISCIPLINE NAME: %s\nWORKLOAD: %d", cod, name, workload);
    }

    public void addStudentInDiscipline(Student student){
        students.add(student);
    }
    public void delStudentInDiscipline(Student student){
        students.add(student);
    }


}
