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
            PrinterService.print("\n1 - CADASTRAR ESTUDANTE.\n2 - CADASTRAR DISCIPLINA.\n3 - CADASTRAR ESTUDANTE NA DISCIPLINA.\n4 - LISTAR.\n5 - SAIR.");
            PrinterService.print("\nESCOLHA UMA ENTRE AS OPÇÕES:");

            int option = readerService.nextInt();

            while (option < 0 || option > 5) {
                option = readerService.nextInt();
            }

            switch (option) {
                case 1:
                    menuOption.studentRegistration();
                case 2:
                    menuOption.disciplineRegistration();
                case 3:
                    menuOption.studentInDisciplineRegistration();
                
                case 4:

                case 5:
                    
            }


            
            
        }


    }


    
}
