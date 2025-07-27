package business.services;

import java.util.ArrayList;
import java.util.List;

import business.services.DTOs.DisciplineDTO;
import business.services.DTOs.StudentDTO;
import model.enteties.Discipline;
import model.enteties.Student;
import model.repository.DisciplineRepository;
import model.repository.MainRepository;
import model.repository.StudentRepository;

public class RegistrationService {
    private MainRepository mainRepository = new MainRepository();
    private ReaderService readerService = new ReaderService();
    
    public void studentRegistration(Student student){
        mainRepository.getStudentRepository().addStudent(student);
    }
    public void disciplineRegistration(Discipline discipline){
        mainRepository.getDisciplineRepository().addDiscipline(discipline);
    }
    public void studentInDisciplineRegistration(){
        int choice2;
        while (true) {
           mainRepository.getStudentRepository().list();
           int choice1 = readerService.nextInt();
           if (choice1 > 0 && choice1 <= mainRepository.getStudentRepository().getStudents().size()) {
                PrinterService.print("\nESCOLHA UMA ENTRE AS DISCIPLINAS CADSTRADAS:");
                mainRepository.getDisciplineRepository().list();
                choice2 = readerService.nextInt();
                if(choice2 > 0 && choice2 <= mainRepository.getDisciplineRepository().getDisciplines().size()){
                    Student student = mainRepository.getStudentRepository().getStudents().get(choice1-1);
                    mainRepository.getDisciplineRepository().getDisciplines().get(choice2-1).addStudentInDiscipline(student);
                    break;
                }
           }
           PrinterService.print("POR FAVOR, INFORME AS INFORMAÇÕES CORRETAMENTE. TENTE NOVAMENTE...");
        }
    }

    public void showListReagistration(){
        PrinterService.print("DADOS DOS REGISTROS DOS ESTUDANTES E SUAS RESPECTIVAS DISCIPLINAS--------\n");
        List<Discipline> disciplines = mainRepository.getDisciplineRepository().getDisciplines();
        if (disciplines.isEmpty()) {
            PrinterService.print("NÃO HÁ DISCIPLINAS CADASTRADAS AINDA.");
        }
        for (Discipline discipline : disciplines) {
            PrinterService.printf("DISCIPLINA - %s\n", discipline.getName());
            discipline.list();
        }
    }

    public void delStudentToDiscipline(){
        StringBuilder sb = new StringBuilder();
        List<Discipline> disciplines = mainRepository.getDisciplineRepository().getDisciplines();
        StudentRepository students = mainRepository.getStudentRepository();
        PrinterService.print("\nVAMOS RETIRAR UM ESTUDANTE CADASTRADO DE UMA DISCIPLINA.");
        PrinterService.print("\nQUAL ESTUDANTE VOCÊ DESEJA REMOVER DE UMA DISCIPLINA:");
        students.list();
        PrinterService.print("SELECIONE O NÚMERO DO ESTUDANTE:");
        int choice = readerService.nextInt();
        while (choice < 1 || choice > students.getStudents().size()) {
            PrinterService.print("DIGITE UMA OPÇÃO VÁLIDA, POR FAVOR.");
            choice = readerService.nextInt();
            readerService.nextLine();
        }
        int num = 1;
        Student choiceStudent = students.getStudents().get(choice-1);
        sb.append("O ALUNO ");
        sb.append(choiceStudent.getName());
        sb.append("ESTÁ CADASTRADO NAS SEGUINTES DISCIPLINAS:\n");
        for (Discipline discipline : disciplines) {
          if (discipline.getStudents().contains(choiceStudent)) {
            sb.append(num);
            sb.append("-");
            sb.append(discipline.getName());
            sb.append("-");
            sb.append(discipline.getCod());
            num++;
          }
        }
        PrinterService.print(sb.toString());
        PrinterService.print("\nDIGITE O CÓDIGO DA DISCIPLINA QUE DESEJA REMOVER O ESTUDANTE:");
        boolean validation = true;
        while (validation) {
            long cod = readerService.nextInt();
            for (Discipline discipline : disciplines) {
                if (discipline.getCod() == cod) {
                    discipline.delStudentInDiscipline(choiceStudent);
                    validation = false;
                    break;
                }
            }
            if (validation == false) {
                break;
            }
            PrinterService.print("O CÓDIGO NÃO SE ENCONTRA ENTRE AS DISCIPLINAS. TENTE NOVAMENTE.");
            readerService.nextLine();
        }
       
    }

    public void delStudent(){
        List<Student> students = mainRepository.getStudentRepository().getStudents();
        PrinterService.print("ESCOLHA ENTRE OS ALUNOS CADASTRADOS PARA DELETAR.\n");
        mainRepository.getStudentRepository().list();
        PrinterService.print("\nESCOLHA ENTRE OS ESTUDANTES QUAL DESEJA REMOVER:");
        while (true) {
            int choice = readerService.nextInt();
            if (choice > 0 && choice <= students.size()) {
                mainRepository.getStudentRepository().delStudent(students.get(choice-1));
                break;
            }
            PrinterService.print("DIGITE UMA OPÇÃO DENTRE AS LISTADAS, POR FAVOR.");
        }
        PrinterService.print("ESTUDANTE REMOVIDO COM SUCESSO.");
    }
    
    public void delDiscipline(){
        DisciplineRepository disciplineRepository = mainRepository.getDisciplineRepository();
        PrinterService.print("ESCOLHA UMA ENTRE AS DISCIPLINAS PARA DELETAR.\n");
        disciplineRepository.list();
        PrinterService.print("ESCOLHA UMA ENTRE AS DISCIPLINAS LISTADAS PARA APAGAR.");
        while (true) {
            int choice = readerService.nextInt();
            if (choice > 0 && choice <= disciplineRepository.getDisciplines().size()) {
                disciplineRepository.delDiscipline(disciplineRepository.getDisciplines().get(choice-1));
                break;
            }
            PrinterService.print("POR FAVOR, DIGITE UMA OPÇÃO VÁLIDA. TENTE NOVAMENTE.");
        }
        PrinterService.print("\nDISCIPLINA REMOVIDA COM SUCESSO.");
    }
    public MainRepository getMainRepository() {
        return mainRepository;
    }
    
    public void updateDiscipline(){
        DisciplineRepository disciplineRepository = mainRepository.getDisciplineRepository();
        PrinterService.print("ESCOLHA UMA ENTRE AS SEGUINTES DISCIPLINAS PARA ATUALIZAR.");
        disciplineRepository.list();
        while (true) {
            PrinterService.print("------>");
            int choice = readerService.nextInt();
            if (choice > 0 && choice <= disciplineRepository.getDisciplines().size()) {
                disciplineRepository.getDisciplines().get(choice-1).update();
                break;
            }
            PrinterService.print("\nPOR FAVOR, DIGITE UMA OPÇÃO VÁLIDA. TENTE NOVAMENTE.");
        }
    }

    public void updateStudent(){
        StudentRepository studentRepository = mainRepository.getStudentRepository();
        PrinterService.print("ESCOLHA UM ENTRE OS ESTUDANTES CADASTRADOS PARA ATUALIZAR.\n");
        studentRepository.list();
        while (true) {
            PrinterService.print("------>");
            int choice = readerService.nextInt();
            if (choice > 0 && choice <= studentRepository.getStudents().size()) {
                studentRepository.getStudents().get(choice-1).update();
                break;
            }
            PrinterService.print("\nPOR FAVOR, DIGITE UMA OPÇÃO VÁLIDA. TENTE NOVAMENTE.");
        }
    }

    public List<StudentDTO> conversionStudentToDTO(){
        List<StudentDTO> studentDTOs = new ArrayList<>();
        List<Student> students = mainRepository.getStudentRepository().getStudents();
        for (Student student : students) {
            studentDTOs.add(new StudentDTO(student.getId(), student.getName(), student.getEmail(), student.getAdress()));
        }
        return studentDTOs;
    }

    public List<DisciplineDTO> conversionDisciplineToDTO(){
        List<DisciplineDTO> disciplineDTOs = new ArrayList<>();
        List<Discipline> disciplines = mainRepository.getDisciplineRepository().getDisciplines();
        for (Discipline discipline : disciplines) {
            disciplineDTOs.add(new DisciplineDTO(discipline.getCod(), discipline.getName(), discipline.getWorkload()));
        }
        return disciplineDTOs;
    }
    
}
