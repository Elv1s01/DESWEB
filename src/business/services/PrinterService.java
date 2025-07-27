package business.services;

public class PrinterService {

    public static void print(String str){
        System.out.println(str);
    }
    public static void printf(String str, Object... object){
        System.out.printf(str, object);

    }
    
}
