package gal.uvigo.esei.aed1.cubirds.iu;

import java.util.Scanner;

public class IU {

    private final Scanner keyboard;

    public IU() {
        keyboard = new Scanner(System.in);
    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    public int readNumber(String msg) {
        boolean repeat;
        int toret = 0;

        do {
            repeat = false;
            System.out.print(msg);
            try {
                toret = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException exc) {
                repeat = true;
            }
        } while (repeat);

        return toret;
    }

    public String readString(String msg) {
        String toret;
        System.out.print(msg);
        toret = keyboard.nextLine();
        return toret;
    }

    public void displayMessage(String msg) {
        System.out.println(msg);
    }

}
