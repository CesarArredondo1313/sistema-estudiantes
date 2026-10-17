
import java.util.ArrayList; //permite la creacion de listas dinamicas
import java.util.Scanner; //permite el uso de la clase Scanner para leer datos desde la consola

public class Main { //clase principal en la que se ejecuta el programa

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in); //crea un objeto Scanner para leer datos del usuario
        ArrayList<Estudiante> estudiantes = new ArrayList<>(); //crea una lista dinamica para almacenar objetos de tipo Estudiante

        int opcion; //variable para almacenar la opcion elegida por el usuario

        do { //bucle del programa que permite diferentes opciones hasta que el usuario decida salir
            System.out.println("\n=== GESTION DE ESTUDIANTES ==="); //titulo y opciones del menu
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Verificar aprobacion");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            opcion = teclado.nextInt(); //almacena la opcion elegida por el usuario
            teclado.nextLine(); //limpia el buffer del scanner para evitar problemas al leer cadenas de texto

            switch (opcion) { //estructura de control que permite ejecutar diferentes bloques de codigo segun la opcion elegida

                case 1: //opcion para registrar un nuevo estudiante
                    System.out.print("Nombre del estudiante: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Matricula: ");
                    int matricula = teclado.nextInt();

                    System.out.print("Promedio (0-100): ");
                    double promedio = teclado.nextDouble();
                    teclado.nextLine();

                    Estudiante nuevo =
                        new Estudiante(nombre, matricula, promedio); //crea un nuevo objeto Estudiante con los datos ingresados por el usuario

                    estudiantes.add(nuevo); //agrega el nuevo estudiante a la lista de estudiantes. Instanciación de objetos

                    System.out.println("Estudiante registrado.");
                    break;

                case 2: //opcion para mostrar la informacion de todos los estudiantes registrados
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados."); //mensaje que se muestra si la lista de estudiantes esta vacia
                    } else {
                        for (Estudiante alumno : estudiantes) {
                            alumno.mostrarInformacion(); //llama al metodo mostrarInformacion() de cada estudiante
                        }
                    }
                    break;

                case 3: //opcion para verificar la aprobación de los estudiantes
                    if (estudiantes.isEmpty()) {
                        System.out.println("No hay estudiantes registrados.");
                    } else {
                        for (Estudiante alumno : estudiantes) {
                            alumno.verificarAprobacion();
                        }
                    }
                    break; 

                case 4: //opcion para salir del programa
                    System.out.println("Programa finalizado.");
                    break;

                default: //opcion no valida
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 4);

        teclado.close(); //cierra el objeto Scanner para liberar recursos
    }
}

class Estudiante { //clase que representa a un estudiante con atributos y metodos para manejar su informacion. declaración de clases

    String nombre;
    int matricula;
    double promedio;

    public Estudiante(String nombre, int matricula, double promedio) { //contructor que inicializa al ser llamado con los valores proporcionados por el usuario. Uso de constructores
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public void mostrarInformacion() { //metodo que muestra la informacion del estudiante. Uso de métodos
        System.out.println("\nNombre: " + nombre);
        System.out.println("Matricula: " + matricula);
        System.out.println("Promedio: " + promedio);
        System.out.println("--------------------");
    }

    public void verificarAprobacion() { //metodo que verifica la aprobación del estudiante
        if (promedio >= 70) {
            System.out.println(nombre + " aprobo.");
        } else {
            System.out.println(nombre + " no aprobo.");
        }
    }
}
