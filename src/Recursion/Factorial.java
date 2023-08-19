package Recursion;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char seguir;

        do {
            System.out.print("Ingrese un número para calcular su factorial: ");
            int numero = scanner.nextInt();

            int factorialRecursivo = calcularFactorial(numero);
            long factorialIterativo = calcularFactorial((long) numero);

            System.out.println("Factorial usando recursión: " + factorialRecursivo);
            System.out.println("Factorial usando iteración: " + factorialIterativo);

            System.out.print("¿Desea calcular otro factorial? (s/n): ");
            seguir = scanner.next().charAt(0);
        } while (seguir == 's' || seguir == 'S');
    }

    public static int calcularFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * calcularFactorial(num - 1);
    }

    public static long calcularFactorial(long num) {
        long factorial = 1;
        for (long i = 1; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }
}



