package presentation.controller;

import business.services.PrinterService;
import business.services.ReaderService;
import business.services.RegistrationService;
import model.enteties.Discipline;
import model.enteties.Student;

public class MenuOption {
    
    RegistrationService registrationService = new RegistrationService();
    ReaderService readerService = new ReaderService();

    public void studentRegistration(){

        PrinterService.print("\nVAMOS CADASTRAR UM NOVO ESTUDANTE.");
        PrinterService.print("DIGITE O ID DO ESTUDANTE:");
        long cod = readerService.nextInt();
        PrinterService.print("DIGITE O NOME DO ESTUDANTE:");
        String name = readerService.nextLine();
        PrinterService.print("DIGITE O EMAIL DO ESTUDANTE:");
        String email = readerService.nextLine();
        PrinterService.print("DIGITE O ENDEREÇO DO ESTUDANTE:");
        String adress = readerService.nextLine();
        registrationService.studentRegistration(new Student(cod, name, email, adress));
    }

    public void disciplineRegistration(){

        PrinterService.print("\nVAMOS CADASTRAR UM NOVA DISCIPLINA.");
        PrinterService.print("DIGITE O CÓDIGO DA DISCIPLINA:");
        long cod = readerService.nextInt();
        PrinterService.print("DIGITE O NOME DA DISCIPLINA:");
        String name = readerService.nextLine();
        PrinterService.print("DIGITE A CARGA HORÁRIA DA DISCIPLINA:");
        int workload = readerService.nextInt();
        registrationService.disciplineRegistration(new Discipline(cod, name, workload));
    }

    public void studentInDisciplineRegistration(){
        PrinterService.print("\nVAMOS CADASTRAR UM ESTUDANTE EM UMA DISCIPLINA.");
        PrinterService.print("ESCOLHA UM ENTRE OS ESTUDANTES CADASTRADOS.");
        registrationService.studentInDisciplineRegistration();
        PrinterService.print("\nESTUDANTE CADASTRADO COM SUCESSO NA DISCIPLINA.");
    }

    public void showListReagistration(){
        PrinterService.print("------------------------------------------\n");
        registrationService.showListReagistration();
        PrinterService.print("\n------------------------------------------");
    }

    public void delStudentToDiscipline(){
        //PrinterService.print("VAMOS DELETAR UM ALUNO DE UMA DISCIPLINA.");
        registrationService.delStudentToDiscipline();
    }
    public void delStudent(){
        PrinterService.print("VAMOS DELETAR UM ESTUDANTE CADASTRADO.");
    }
    
}
