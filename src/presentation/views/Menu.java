package presentation.views;

import business.services.PrinterService;
import business.services.ReaderService;
import presentation.controller.MenuOption;

public class Menu {
    PrinterService printerService = new PrinterService();
    ReaderService readerService = new ReaderService();
    MenuOption menuOption = new MenuOption();


    public void showMenu(){
        while (true) {
            PrinterService.print("-----MENU PARA CADASTRO-----");
            PrinterService.print("\n1 - CADASTRAR ESTUDANTE.\n2 - CADASTRAR DISCIPLINA.\n3 - CADASTRAR ESTUDANTE NA DISCIPLINA.\n4 - LISTAR.\n5 - DELETAR ESTUDANTE DE UMA DISCIPLINA.\n6 - DELETAR ESTUDANTE.\n7 - DELETAR DISCIPLINA.\n8 - EDITAR DISCIPLINA.\n9 - EDITAR ESTUDANTE.\n10 - SAIR.");
            PrinterService.print("\nESCOLHA UMA ENTRE AS OPÇÕES:");

            int option = readerService.nextInt();

            while (option < 0 || option > 10) {
                PrinterService.print("DIGITE UMA OPÇÃO VÁLIDA POR FAVOR");
                option = readerService.nextInt();
            }

            switch (option) {
                case 1:
                    menuOption.studentRegistration();
                    break;
                case 2:
                    menuOption.disciplineRegistration();
                    break;
                case 3:
                    menuOption.studentInDisciplineRegistration();
                    break;
                case 4:
                    menuOption.showListReagistration();
                    break;
                case 5:
                    menuOption.delStudentToDiscipline();
                case 6:
                    menuOption.delStudent();
                    break;
                case 7:
                    menuOption.delDiscipline();
                    break;
                case 8:
                    menuOption.updateDiscipline();
                    break;
                case 9:
                    menuOption.updateStudent();
                    break;
                default:
                    break;
            }
            if (option == 10) {
                PrinterService.print("OBRIGADO PELA PREFERÊNCIA DOS NOSSOS SERVIÇOS ESCOLARES!");   
                break;
            }
        }
    } 
}
