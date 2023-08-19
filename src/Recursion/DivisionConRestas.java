package Recursion;
import java.util.Scanner;
public class DivisionConRestas {

    public static int division(int dividendo, int divisor) {
        if (divisor == 0) {
            System.out.println("Error: El divisor no puede ser cero, por favor vuelva a intentar.");
            return -1;
        }
        if (dividendo < divisor) {
            return 0;
        }
        return 1 + division(dividendo - divisor, divisor);
    }

    public static int division(int dividendo, int divisor, boolean iterativo) {
        if (iterativo) {
            if (divisor == 0) {
                System.out.println("Error: El divisor no puede ser cero, por favor vuelva a intentar.");
                return -1;
            }
            int cociente = 0;
            while (dividendo >= divisor) {
                dividendo -= divisor;
                cociente++;
            }
            return cociente;
        } else {
            return division(dividendo, divisor);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char seguir;

        do {
            System.out.print("Ingrese el dividendo: ");
            int dividendo = scanner.nextInt();

            System.out.print("Ingrese el divisor: ");
            int divisor = scanner.nextInt();

            int resultadoRecursivo = division(dividendo, divisor);
            if (resultadoRecursivo != -1) {
                System.out.println("División recursiva: " + resultadoRecursivo);
            }

            int resultadoIterativo = division(dividendo, divisor, true);
            if (resultadoIterativo != -1) {
                System.out.println("División iterativa: " + resultadoIterativo);
            }

            System.out.print("¿Desea realizar otra operación? (s/n): ");
            seguir = scanner.next().charAt(0);
        } while (seguir == 's' || seguir == 'S');
    }
}
