package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.services.PrinterService;
import model.enteties.Student;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void delStudent(Student student){
        students.remove(student);
    }
    public void updateStudent(Student student){
        Scanner in = new Scanner(System.in);
        PrinterService.print("\nNEW NAME: ");
        student.setName(in.nextLine());
        PrinterService.print("NEW EMAIL:");
        student.setEmail(in.nextLine());
        System.out.println("NEW ADRESS:");
        student.setAdress(in.nextLine());
        in.close();
    }

    public void list(){
        PrinterService.print("\nESTUDANTES CADASTRADOS---------");
        int num = 1;
        for (Student student : students) {
            PrinterService.printf("%d - %s --- id:%d\n", num, student.getName(), student.getId());
            num++;
        }
    }
    
}
