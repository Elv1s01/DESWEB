package business.services;

import model.enteties.Discipline;
import model.enteties.Student;
import model.repository.MainRepository;

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
    
    public MainRepository getMainRepository() {
        return mainRepository;
    }
    

    
}
