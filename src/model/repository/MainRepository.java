package model.repository;

public class MainRepository {
    private StudentRepository studentRepository = new StudentRepository();
    private DisciplineRepository disciplineRepository = new DisciplineRepository();

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
    public DisciplineRepository getDisciplineRepository() {
        return disciplineRepository;
    }

}
