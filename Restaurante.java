import java.util.Scanner;

public class Restaurante {

    private static final int REGULAR = 1;
    private static final int VEGETARIANO = 2;
    private static final int VEGANO = 3;

    private static final int PLATO1 = 0;
    private static final int PLATO2 = 1;
    private static final int PLATO3 = 2;

    private static final String[] MENU_REGULAR = {"Hamburguesa", "Pollo al horno"};
    private static final String[] MENU_VEGETARIANO = {"Ensalada", "Hamburguesa vegetariana"};
    private static final String[] MENU_VEGANO = {"Ensalada", "Tofu Salteado"};
    private static final double[] PRECIOS_REGULAR = {8.5, 10.0};
    private static final double[] PRECIOS_VEGETARIANO = {7.0, 9.0};
    private static final double[] PRECIOS_VEGANO = {6.0, 12.0};

    private static int[] cantidadRegular = {5, 5};
    private static int[] cantidadVegetariano = {5, 5};
    private static int[] cantidadVegano = {5, 5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        double total = 0;

        System.out.println("¡Bienvenido al restaurante!");

        while (continuar) {
            System.out.println("\n¿Qué tipo de comida desea?");
            System.out.println("1. Regular");
            System.out.println("2. Vegetariana");
            System.out.println("3. Vegano");
            System.out.println("0. Salir");

            int tipoComida = sc.nextInt();

            if (tipoComida == 0) {
                System.out.println("Gracias por su visita. Su total es: $" + total);
                break;
            }

            if (tipoComida == REGULAR || tipoComida == VEGETARIANO || tipoComida == VEGANO) {
                mostrarMenu(tipoComida);
                System.out.println("\nSeleccione el plato (1 o 2):");
                int platoSeleccionado = sc.nextInt();

                if (platoSeleccionado == 1 || platoSeleccionado == 2) {
                    total += procesarPedido(tipoComida, platoSeleccionado - 1);
                } else {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            } else {
                System.out.println("Tipo de comida no válido. Intente nuevamente.");
            }

            System.out.println("¿Desea pedir algo más? (1 para Sí, 0 para No):");
            continuar = sc.nextInt() == 1;
        }

        sc.close();
    }

    private static void mostrarMenu(int tipoComida) {
        if (tipoComida == REGULAR) {
            System.out.println("Menú Regular:");
            for (int i = 0; i < MENU_REGULAR.length; i++) {
                System.out.println((i + 1) + ". " + MENU_REGULAR[i] + " - $" + PRECIOS_REGULAR[i] + "(Cantidad " + cantidadRegular[i] + ")");
            }
        } else if (tipoComida == VEGETARIANO) {
            System.out.println("Menú Vegetariano: ");
            for (int i = 0; i < MENU_VEGETARIANO.length; i++) {
                System.out.println((i + 1) + ". " + MENU_VEGETARIANO[i] + " - $" + PRECIOS_VEGETARIANO[i] + "(Cantidad " + cantidadVegetariano[i] + ")");
            }
        } else if (tipoComida == VEGANO) {
            System.out.println("Menú Vegano: ");
            for (int i = 0; i < MENU_VEGANO.length; i++) {
                System.out.println((i + 1) + ". " + MENU_VEGANO[i] + " - $" + PRECIOS_VEGANO[i] + "(Cantidad " + cantidadVegano[i] + ")");
            }
        }
    }

    private static double procesarPedido(int tipoComida, int platoSeleccionado) {
        if (tipoComida == REGULAR) {
            if (cantidadRegular[platoSeleccionado] > 0) {
                cantidadRegular[platoSeleccionado]--;
                System.out.println("Has pedido: " + MENU_REGULAR[platoSeleccionado]);
                return PRECIOS_REGULAR[platoSeleccionado];
            } else {
                System.out.println("Lo sentimos, " + MENU_REGULAR[platoSeleccionado] + " está agotado.");
                reponer(tipoComida, platoSeleccionado);
                return 0;
            }
        } else if (tipoComida == VEGETARIANO) {
            if (cantidadVegetariano[platoSeleccionado] > 0) {
                cantidadVegetariano[platoSeleccionado]--;
                System.out.println("Has pedido: " + MENU_VEGETARIANO[platoSeleccionado]);
                return PRECIOS_VEGETARIANO[platoSeleccionado];
            } else {
                System.out.println("Lo sentimos, " + MENU_VEGETARIANO[platoSeleccionado] + " está agotado.");
                reponer(tipoComida, platoSeleccionado);
                return 0;
            }
        } else if (tipoComida == VEGANO) {
            if (cantidadVegano[platoSeleccionado] > 0) {
                cantidadVegano[platoSeleccionado]--;
                System.out.println("Has pedido: " + MENU_VEGANO[platoSeleccionado]);
                return PRECIOS_VEGANO[platoSeleccionado];
            } else {
                System.out.println("Lo sentimos, " + MENU_VEGANO[platoSeleccionado] + " está agotado.");
                reponer(tipoComida, platoSeleccionado);
                return 0;
            }
        }
        return 0;
    }

    private static void reponer(int tipoComida, int platoSeleccionado) {
        if (tipoComida == REGULAR) {
            if (cantidadRegular[platoSeleccionado] == 0) {
                cantidadRegular[platoSeleccionado] += 5;
                System.out.println("Se ha repuesto 5 unidades de " + MENU_REGULAR[platoSeleccionado]);
            } else {
                System.out.println("No es necesario reponer " + MENU_REGULAR[platoSeleccionado]);
            }
        } else if (tipoComida == VEGETARIANO) {
            if (cantidadVegetariano[platoSeleccionado] == 0) {
                cantidadVegetariano[platoSeleccionado] += 5;
                System.out.println("Se ha repuesto 5 unidades de " + MENU_VEGETARIANO[platoSeleccionado]);
            } else {
                System.out.println("No es necesario reponer " + MENU_VEGETARIANO[platoSeleccionado]);
            }
        } else if (tipoComida == VEGANO) {
            if (cantidadVegano[platoSeleccionado] == 0) {
                cantidadVegano[platoSeleccionado] += 5;
                System.out.println("Se ha repuesto 5 unidades de " + MENU_VEGANO[platoSeleccionado]);
            } else {
                System.out.println("No es necesario reponer " + MENU_VEGANO[platoSeleccionado]);
            }
        }
    }
}

