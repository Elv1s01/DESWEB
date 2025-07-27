package model.enteties;

public class Discipline {
    private long cod;
    private String name;
    private int workload;
    
    public Discipline(long cod, String name, int workload) {
        this.cod = cod;
        this.name = name;
        this.workload = workload;
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



}
