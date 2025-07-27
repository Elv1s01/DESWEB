package business.services;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReaderService {
    private Scanner in = new Scanner(System.in);

    public String nextLine(){
        return in.nextLine();
    }

    public int nextInt(){
        while (true) {
            try {
                int value = in.nextInt();
                in.nextLine();
                return value;
            } catch (InputMismatchException e) {
                PrinterService.print("\nVOCÊ DIGITOU UM NÚMERO INVÁLIDO, TENTE NOVAMENTE...");
                in.nextLine();
            }
        }
    }
    
}