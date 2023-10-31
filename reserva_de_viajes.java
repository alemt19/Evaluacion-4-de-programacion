import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class reserva_de_viajes{
    public static void main(String[] args) {

        String bandera = "SI";
        String ciclo = "SI";
        ArrayList<String> destinos = new ArrayList<String> (Arrays.asList("Valencia", "Maracay", "Guacara", "Isabelica"));
        int[] asientos = {30, 20, 30, 40};
        int[] costes = {2, 5, 4, 3};

        while (ciclo.equals(bandera)) {

            System.out.printf("***Destinos disponibles*** %n%n");
            System.out.printf("%-12s %-12s %-1s %n", "Destino", "Asientos", "Coste");

            int n_destinos = destinos.size();

            for ( int i = 0 ; i < n_destinos; i++ ) {
                System.out.printf("%-15s %-10d %-1d $ %n", destinos.get(i), asientos[i], costes[i]);
            };

            System.out.printf("%n");

            Scanner destino_in = new Scanner(System.in);
            System.out.println("Por favor escriba su destino:");
            String destino = destino_in.next();
            int destinoindex = destinos.indexOf(destino);

            Scanner boletos_in = new Scanner(System.in);
            System.out.println("Por favor inserte el numero de boletos que desea:");
            int boletos = boletos_in.nextInt();
            
            if (asientos[destinoindex] >= boletos) {

                asientos[destinoindex] = asientos[destinoindex] - boletos;
                System.out.printf("Usted ha comprado %d boletos hacia %s, por un total de %d $. %n", boletos, destino, costes[destinoindex] * boletos );
                Scanner continuar = new Scanner(System.in);
                System.out.printf("¿Desea comprar más boletos? Inserte 'SI' o 'NO'.%n%n");
                ciclo = continuar.next();
            }
            
            else {
                System.out.printf("No quedan asientos disponibles, eliga otro destino. %n%n");
            }
        }

        }
    }