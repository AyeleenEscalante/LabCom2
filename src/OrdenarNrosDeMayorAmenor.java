import java.util.Scanner;

public class OrdenarNrosDeMayorAmenor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        char continuar;

        do {
            System.out.println("Ingrese 3 números: ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();

            if (num1 >= num2 && num1 >= num3) {
                if (num2 >= num3) {
                    System.out.println("Números ordenados de mayor a menor son: " + num1 + ", " + num2 + ", " + num3);
                } else {
                    System.out.println("Números ordenados de mayor a menor son: " + num1 + ", " + num3 + ", " + num2);
                }
            } else if (num2 >= num1 && num2 >= num3) {
                if (num1 >= num3) {
                    System.out.println("Números ordenados de mayor a menor son: " + num2 + ", " + num1 + ", " + num3);
                } else {
                    System.out.println("Números ordenados de mayor a menor son: " + num2 + ", " + num3 + ", " + num1);
                }
            } else {
                if (num1 >= num2) {
                    System.out.println("Números ordenados de mayor a menor son: " + num3 + ", " + num1 + ", " + num2);
                } else {
                    System.out.println("Números ordenados de mayor a menor son: " + num3 + ", " + num2 + ", " + num1);
                }
            }

            System.out.println("¿Desea realizar otra operación? (S/N)");
            continuar = scanner.next().charAt(0);

            if (continuar == 'N' || continuar == 'n') {
                System.out.println("Gracias,hasta pronto.");
            }

        } while (continuar == 'S' || continuar == 's');
    }
}
