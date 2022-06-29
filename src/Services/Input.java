/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import java.util.Scanner;

public class Input {

    private static final Scanner LEER = new Scanner(System.in).useDelimiter("\n");

    public static String askString(String message) {
        System.out.print(message);
        return LEER.next();
    }

    public static Integer askInteger(String message) {
        System.out.print(message);
        return LEER.nextInt();
    }

    public static Double askDouble(String message) {
        System.out.print(message);
        return LEER.nextDouble();
    }
    
    public static Integer askPositiveInteger(String message){
        Integer value;
        System.out.println(Constants.ASK_POSITIVE_VALUE);
        do {
            value = askInteger(message);
            
        } while (0 >= value);
        return value;
    }
    
    
    public static Double askPositiveDouble(String message){
        Double value;
        System.out.println(Constants.ASK_POSITIVE_VALUE);
        do {
            value = askDouble(message);
            
        } while (0 >= value);
        return value;
    }

}
