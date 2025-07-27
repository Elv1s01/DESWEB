package model.enteties;

import business.services.PrinterService;
import business.services.ReaderService;

public class Student {
    private long id;
    private String name, email, adress;
    
    public Student(long id, String name, String email, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String toString(){
        return String.format("\nID: %d\nNAME: %s\nEMAIL: %s\nADRESS: %s", id, name, email, adress);
    }

     public void update(){
        ReaderService readerService = new ReaderService();
        PrinterService.print("VAMOS ATUALIZAR OS DADOS DO SEU ESTUDANTE.");
        PrinterService.print("DIGITE O NOVO NOME");
        String name = readerService.nextLine();
        PrinterService.print("\nDIGITE O NOVO EMAIL DO ESTUDANTE:");
        String email = readerService.nextLine();
        PrinterService.print("\nDIGITE O NOVO ENDEREÇO:");
        String adress = readerService.nextLine();
        PrinterService.print("\nDIGITE O NOVO ID DO ESTUDANTE:");
        long id = readerService.nextInt();

        setName(name);
        setEmail(email);
        setAdress(adress);
        setId(id);
        PrinterService.print("O ESTUDANTE FOI ATUALIZADO COM SUCESSO.");
    }
     
}
