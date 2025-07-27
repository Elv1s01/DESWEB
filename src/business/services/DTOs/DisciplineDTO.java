package business.services.DTOs;

import java.util.ArrayList;
import java.util.List;

import model.enteties.Student;

public class DisciplineDTO {
    private long cod;
    private String name;
    private int workload;
    private List<Student> students = new ArrayList<>();
    
    
    public DisciplineDTO(long cod, String name, int workload) {
        this.cod = cod;
        this.name = name;
        this.workload = workload;
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


    public List<Student> getStudents() {
        return students;
    }


    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
