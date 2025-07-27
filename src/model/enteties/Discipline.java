package model.enteties;

import java.util.ArrayList;
import java.util.List;

import business.services.PrinterService;
import business.services.ReaderService;

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

    public void list(){
        int num = 1;
        if (students.isEmpty()) {
            PrinterService.print("NÃO HÁ ESTUDANTES MATRICULADOS NESSA MÁTERIA AINDA.");
        }
        for (Student student : students) {
            PrinterService.printf("%d - %s --- id:%d\n", num, student.getName(), student.getId());
            num++;
        }
    }

    public void update(){
        ReaderService readerService = new ReaderService();
        PrinterService.print("VAMOS ATUALIZAR A SUA DISCIPLINA.");
        PrinterService.print("DIGITE O NOVO NOME DA DISCIPLINA:");
        String name = readerService.nextLine();
        PrinterService.print("\nDIGITE A NOVA CARGA HORÁRIA DA DISCIPLINA:");
        int workload = readerService.nextInt();
        readerService.nextLine();
        PrinterService.print("\nDIGITE O NOVO CÓDIGO:");
        long cod = readerService.nextInt();
        setName(name);
        setWorkload(workload);
        setCod(cod);
        PrinterService.print("A DISCIPLINA FOI ATUALIZADA COM SUCESSO.");
    }


}
