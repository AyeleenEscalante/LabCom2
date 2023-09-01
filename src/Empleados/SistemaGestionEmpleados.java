package Empleados;
import java.util.ArrayList;
import java.util.Scanner;

// Clase abstracta Empleado
abstract class Empleado {
    private String nombre;
    private int id;
    private double sueldoBase;

    public Empleado(String nombre, int id, double sueldoBase) {
        this.nombre = nombre;
        this.id = id;
        this.sueldoBase = sueldoBase;
    }

    // Método abstracto para calcular el sueldo
    public abstract double calcularSueldo();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}

// Clase EmpleadoPorHoras
class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, int id, double sueldoBase, int horasTrabajadas) {
        super(nombre, id, sueldoBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        return getSueldoBase() * horasTrabajadas;
    }
}

// Clase EmpleadoAsalariado
class EmpleadoAsalariado extends Empleado {
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase) {
        super(nombre, id, sueldoBase);
    }

    @Override
    public double calcularSueldo() {
        return getSueldoBase();
    }
}

// Clase EmpleadoComision
class EmpleadoComision extends Empleado implements Impuesto {
    private double ventasRealizadas;

    public EmpleadoComision(String nombre, int id, double sueldoBase, double ventasRealizadas) {
        super(nombre, id, sueldoBase);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        return getSueldoBase() + (0.1 * ventasRealizadas); // 10% de comisión
    }

    @Override
    public double calcularImpuesto() {
        return 0.15 * calcularSueldo(); // Impuesto del 15%
    }
}

// Interfaz Impuesto
interface Impuesto {
    double calcularImpuesto();
}

// Clase GestorEmpleados
class GestorEmpleados {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    // Método para agregar un empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para modificar el sueldo base de un empleado por ID
    public void modificarSueldoBase(int id, double nuevoSueldoBase) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                empleado.setSueldoBase(nuevoSueldoBase);
                System.out.println("Sueldo base del empleado con ID " + id + " modificado a: $" + nuevoSueldoBase);
                return;
            }
        }
        System.out.println("No se encontró un empleado con ID " + id + ".");
    }

    // Método para modificar el nombre de un empleado por ID
    public void modificarNombre(int id, String nuevoNombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                empleado.setNombre(nuevoNombre);
                System.out.println("Nombre del empleado con ID " + id + " modificado a: " + nuevoNombre);
                return;
            }
        }
        System.out.println("No se encontró un empleado con ID " + id + ".");
    }

    // Método para eliminar un empleado por ID
    public void eliminarEmpleado(int id) {
        empleados.removeIf(empleado -> empleado.getId() == id);
        System.out.println("Empleado con ID " + id + " eliminado.");
    }

    // Método para imprimir la lista de empleados
    public void imprimirListaEmpleados() {
        for (Empleado empleado : empleados) {
            System.out.println("ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre());
        }
    }

    // Método para obtener un empleado por ID
    public Empleado obtenerEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null; // Si no se encuentra el empleado
    }
}

public class SistemaGestionEmpleados {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    agregarEmpleado(scanner, gestor);
                    break;
                case 2:
                    modificarSueldoBase(scanner, gestor);
                    break;
                case 3:
                    modificarNombre(scanner, gestor);
                    break;
                case 4:
                    eliminarEmpleado(scanner, gestor);
                    break;
                case 5:
                    calcularSueldo(scanner, gestor);
                    break;
                case 6:
                    calcularImpuesto(scanner, gestor);
                    break;
                case 7:
                    gestor.imprimirListaEmpleados();
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Modificar sueldo base de empleado");
        System.out.println("3. Modificar nombre de empleado");
        System.out.println("4. Eliminar empleado");
        System.out.println("5. Calcular sueldo de empleado");
        System.out.println("6. Calcular impuesto de empleado");
        System.out.println("7. Imprimir lista de empleados");
        System.out.println("8. Salir");
        System.out.print("Ingrese su elección: ");
    }

    private static void agregarEmpleado(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        System.out.println("Ingrese el sueldo base del empleado: ");
        double sueldoBase = scanner.nextDouble();

        System.out.println("Elija el tipo de empleado:");
        System.out.println("1. Empleado por horas");
        System.out.println("2. Empleado asalariado");
        System.out.println("3. Empleado de comisión");
        int tipoEmpleado = scanner.nextInt();

        switch (tipoEmpleado) {
            case 1:
                try {
                    System.out.println("Ingrese las horas trabajadas: ");
                    int horasTrabajadas = scanner.nextInt();
                    EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras(nombre, id, sueldoBase, horasTrabajadas);
                    gestor.agregarEmpleado(empleadoPorHoras);
                } catch (Exception e) {
                    System.out.println("Error: Ingrese un valor válido para las horas trabajadas.");
                }
                break;
            case 2:
                EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado(nombre, id, sueldoBase);
                gestor.agregarEmpleado(empleadoAsalariado);
                break;
            case 3:
                try {
                    System.out.println("Ingrese las ventas realizadas: ");
                    double ventasRealizadas = scanner.nextDouble();
                    EmpleadoComision empleadoComision = new EmpleadoComision(nombre, id, sueldoBase, ventasRealizadas);
                    gestor.agregarEmpleado(empleadoComision);
                } catch (Exception e) {
                    System.out.println("Error: Ingrese un valor válido para las ventas realizadas.");
                }
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

    private static void modificarSueldoBase(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Ingrese el ID del empleado a modificar sueldo base: ");
        int idModificarSueldo = scanner.nextInt();
        System.out.println("Ingrese el nuevo sueldo base: ");
        double nuevoSueldoBase = scanner.nextDouble();
        gestor.modificarSueldoBase(idModificarSueldo, nuevoSueldoBase);
    }

    private static void modificarNombre(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Ingrese el ID del empleado a modificar nombre: ");
        int idModificarNombre = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea
        System.out.println("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        gestor.modificarNombre(idModificarNombre, nuevoNombre);
    }

    private static void eliminarEmpleado(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Ingrese el ID del empleado a eliminar: ");
        int idEliminar = scanner.nextInt();
        gestor.eliminarEmpleado(idEliminar);
    }

    private static void calcularSueldo(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Ingrese el ID del empleado para calcular sueldo: ");
        int idCalcularSueldo = scanner.nextInt();
        Empleado empleadoSueldo = gestor.obtenerEmpleadoPorId(idCalcularSueldo);
        if (empleadoSueldo != null) {
            double sueldo = empleadoSueldo.calcularSueldo();
            System.out.println("Sueldo de " + empleadoSueldo.getNombre() + ": $" + sueldo);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void calcularImpuesto(Scanner scanner, GestorEmpleados gestor) {
        System.out.println("Ingrese el ID del empleado para calcular impuesto: ");
        int idCalcularImpuesto = scanner.nextInt();
        Empleado empleadoImpuesto = gestor.obtenerEmpleadoPorId(idCalcularImpuesto);
        if (empleadoImpuesto instanceof Impuesto impuestoEmpleado) {
            double impuesto = impuestoEmpleado.calcularImpuesto();
            System.out.println("Impuesto de " + empleadoImpuesto.getNombre() + ": $" + impuesto);
        } else {
            System.out.println("Empleado no encontrado o no es elegible para impuestos.");
        }
    }
}