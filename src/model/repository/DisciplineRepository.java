package model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import business.services.PrinterService;
import model.enteties.Discipline;

public class DisciplineRepository {
    private List<Discipline> disciplines = new ArrayList<>();

    public List<Discipline> getDisciplines() {
        return disciplines;
    }
    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
    }
    public void delDiscipline(Discipline discipline){
        disciplines.remove(discipline);
    }
    public void updateDiscipline(Discipline discipline){
        Scanner in = new Scanner(System.in);
        PrinterService.print("\nNEW NAME: ");
        discipline.setName(in.nextLine());
        PrinterService.print("NEW EMAIL:");
        discipline.setWorkload(in.nextInt());
        in.close();
    }

    public void list(){
        PrinterService.print("\nDISCIPLINAS CADASTRADAS---------");
        int num = 1;
        for (Discipline discipline : disciplines) {
            PrinterService.printf("%d - %s --- id:%d\n", num, discipline.getName(), discipline.getCod());
            num++;
        }
    }


    
}
