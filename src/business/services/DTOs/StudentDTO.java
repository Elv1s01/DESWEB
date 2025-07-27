package business.services.DTOs;

public class StudentDTO {
    private long id;
    private String name, email, adress;
    
    public StudentDTO(long id, String name, String email, String adress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
