import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Simulador_Vida {
    
    private static Scanner scanner = new Scanner(System.in);

    private static final int Num_Estados = 5;
    private static final int Salud_Inicial = 100;
    private static final int Dinero_Inicial = 100;
    private static final int Felicidad_Inicial = 100;
    private static final int Estres_Inicial = 0;
    private static final int Sueño_Inicial = 0; 

    private static final int Max_Valor = 100;
    private static final int Min_Valor = 0;

    private static int Salud = Salud_Inicial;
    private static int Dinero = Dinero_Inicial;
    private static int Felicidad = Felicidad_Inicial;
    private static int Estres = Estres_Inicial;
    private static int Sueño = Sueño_Inicial;

    private static final int Opcion_Chambear = 1;
    private static final int Opcion_Descansar = 2;
    private static final int Opcion_Comer = 3;
    private static final int Opcion_Estudiar = 4;
    private static final int Opcion_Salir = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> personaje = new HashMap<>();
        personaje.put("nombre", "");
        personaje.put("edad", 0);
        personaje.put("genero", "");
        personaje.put("profesion", "");

        System.out.print("Introduce tu nombre: ");
        personaje.put("nombre", scanner.nextLine());

        System.out.print("Introduce tu edad: ");
        personaje.put("edad", scanner.nextInt());
        scanner.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Introduce tu género: ");
        personaje.put("genero", scanner.nextLine());

        System.out.print("Introduce tu profesión: ");
        personaje.put("profesion", scanner.nextLine());

        System.out.println("\n¡Comencemos la simulación!\n"); 

        while (true) {
            System.out.println("Estado actual de " +personaje.get("nombre")+ ":");
            mostrarEstado();

            System.out.println("\nOpciones disponibles");
            System.out.println("1. Chambear");
            System.out.println("2. Descansar");
            System.out.println("3. Comer");
            System.out.println("4. Estudiar");

            System.out.println("Elija la opcion que desea:\n");
            int opcion = 0;

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: ingrese un numero valido:");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case Opcion_Chambear:
                    Chambear();
                    break;
                case Opcion_Descansar:
                    Descansar();
                    break;
                case Opcion_Comer:
                    Comer();
                    break;
                case Opcion_Estudiar:
                    Estudiar();
                    break;
                case Opcion_Salir:
                    System.out.println("¡Gracias por jugar!");
                    System.exit(0);
                default:
                    System.out.println("Error: Introduce una opción válida.");
                    break;
            }

            if (Salud <= Min_Valor || Dinero <= Min_Valor || Felicidad <= Min_Valor || Estres >= Max_Valor || Sueño >= Max_Valor ) {
                System.out.println("¡Has perdido! Tu personaje ha llegado a un estado crítico.");
                System.exit(0);
            }

            System.out.println();
        }
    }

    private static void mostrarEstado() {
                System.out.println("Salud: " + Salud);
                System.out.println("Dinero: " + Dinero);
                System.out.println("Felicidad: " + Felicidad);
                System.out.println("Estres:" + Estres);
                System.out.println("Sueño: " +  Sueño);
        }
    private static void Chambear() {
        try{
            System.out.println("\nEn donde quieres trabajar?");
            System.out.println("1. Colector de buseta");
            System.out.println("2. Lanchero en playa Morrocoy");
            System.out.println("3. Malandro");
            System.out.println("Elija la opcion que desea:\n");
            int opcion = 0;
            opcion = scanner.nextInt();
            if (opcion == 1){
                Dinero += 15;
                Salud -= 10;
                Sueño += 10;
                System.out.println();
                System.out.println("Tuviste buena suerte al decidir trabajar en la ruta Lara-Branger-Centro, conseguiste plata para personalizar la encava.");
            } else if (opcion == 2){
                Dinero += 30;
                Felicidad +=20;
                Salud -=12;
                Estres += 10;
                Sueño +=30;
                System.out.println();
                System.out.println("Se te accidento la lancha por falta de gasolina, pero por suerte te conseguiste con lacava y te regalo una nueva.");
            } else if (opcion == 3){
                Salud -=1000;
                System.out.println();
                System.out.println("Te pegaron 3 tiros por andar de pajuo, dos en el pecho y una en la cabeza.");
            }
        } catch (Exception e) {
            System.out.println("Error ingrese un numero valido: " + e.getMessage());
            scanner.nextLine();
        }
    }
    private static void Descansar() {
        try{
            System.out.println("\nQue deseas hacer en tu hora de descanso?");
            System.out.println("1. Dormir");
            System.out.println("2. Desarmar un ventilador");
            System.out.println("3. Ver un juego de la vinotinto");
            System.out.println("Elija la opcion que desea:\n");
            int opcion = 0;
            opcion = scanner.nextInt();
            if (opcion == 1){
                Salud += 20;
                Sueño -= 15;
                Estres -= 10;
                System.out.println();
                System.out.println("Dormiste fino, soñaste que la vinotinto ganaba el mundial y que derrocaban a Maduro.");
            } else if (opcion == 2){
                Salud -=15;
                Estres += 10;
                Sueño -=15;
                System.out.println();
                System.out.println("Te electrocutaste, pero eso te dio mas energia.");
            } else if (opcion == 3){
                Felicidad -=10;
                Salud +=10;
                Estres += 10;
                System.out.println();
                System.out.println("Se fue el cable porque esta lloviendo, Viva Venezuela.");
            }
        
        } catch (Exception e) {
            System.out.println("Error ingrese un numero valido: " + e.getMessage());
            scanner.nextLine();
        }
    }   
        

    private static void Comer() {
        try{
            System.out.println("\n¿Que deseas Comer?");
            System.out.println("1. Pasta con Carne molida y jugo de guayaba");
            System.out.println("2. Sushi con Coca cola");
            System.out.println("3. Arroz con pollo y jugo de parchita");
            System.out.println("Elija la opcion que desea:\n");
            int opcion = 0;
            opcion = scanner.nextInt();
            if (opcion == 1){
                Salud += 20;
                Felicidad += 15;
                Dinero -= 10;
                Sueño += 20;
                System.out.println();
                System.out.println("La mejor decision, feliz y lleno por tremendo manjar.");
            } else if (opcion == 2){
                Salud -=80;
                Estres += 40;
                Dinero -=60;
                Felicidad -=40;
                System.out.println();
                System.out.println("El pescado y los camarones tenian mas parasitos que una rata, te enfermaste por andar de sifrino, el sushi no sirve.");
            } else if (opcion == 3){
                Felicidad +=10;
                Salud +=10;
                Dinero -= 25;
                Estres +=10;
                System.out.println();
                System.out.println("sabroso pero quedaste con hambre y se acabo el jugo gracias a que la parchita no rinde.");
            }
        } catch (Exception e) {
            System.out.println("Error ingrese un numero valido: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void Estudiar() {
        try{
            System.out.println("\n¿En que universidad deseas estudiar?");
            System.out.println("1. Universidad Jose Antonio Paez");
            System.out.println("2. Universidad de Carabobo");
            System.out.println("3. Universidad Arturo Michelena");
            System.out.println("Elija la opcion que desea:\n");
            int opcion = 0;
            opcion = scanner.nextInt();
            if (opcion == 1){
                Dinero -=999;
                System.out.println();
                System.out.println("Mala eleccion, ahora te toca vivir abajo del puente barbula porque quedaste pelando por la inscripcion del semestre.");
            } else if (opcion == 2){
                Salud -=30;
                Estres += 40;
                Felicidad +=5;
                System.out.println();
                System.out.println("Carabobo is the best.");
            } else if (opcion == 3){
                Felicidad +=20;
                Salud -=30;
                Dinero -= 100;
                Estres +=10;
                Sueño +=40;
                System.out.println();
                System.out.println("Quedaste pelando pero por lo menos te queda para unos perritos de 1$ diarios.");
            }
        } catch (Exception e) {
            System.out.println("Error ingrese un numero valido: " + e.getMessage());
            scanner.nextLine();
        }
    }
}