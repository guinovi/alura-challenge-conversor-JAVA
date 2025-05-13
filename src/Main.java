import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("""
                ******************************
                Conversor de Moneda =)
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ******************************
            """);

            opcion = scanner.nextInt();

            try {
                switch (opcion) {
                    case 1 -> convertir("USD", "ARS");
                    case 2 -> convertir("ARS", "USD");
                    case 3 -> convertir("USD", "BRL");
                    case 4 -> convertir("BRL", "USD");
                    case 5 -> convertir("USD", "COP");
                    case 6 -> convertir("COP", "USD");
                    case 7 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error al obtener datos de la API: " + e.getMessage());
            }
        }
    }

    private static void convertir(String base, String destino) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Ingrese el monto en %s: ", base);
        double monto = scanner.nextDouble();

        double tasa = Busqueda.obtenerTasa(base, destino);
        double resultado = monto * tasa;

        System.out.printf("%.2f %s equivalen a %.2f %s%n", monto, base, resultado, destino);
        System.out.println("\n******************************\n");
    }
}


