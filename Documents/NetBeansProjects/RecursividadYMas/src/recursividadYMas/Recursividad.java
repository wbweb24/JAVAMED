package recursividadYMas;

public class Recursividad {

    public static void main(String[] args) {
        int num1 = 48, num2 = 18;
        int log = 0;

        System.out.println("El factorial de " + num2/3 + " es: " + factorial(num2/3));
        System.out.println("El MCD de " + num1 + " y " + num2 + " es: " + calcularMCD(num1, num2));
        System.out.println("El log2(8) es: " + calcularLogaritmo(2, 8));
        System.out.println("El log2(8) (con log " + log + " ) es: " + calcularLogaritmo(2, 8, 0));

        // Inicialización del árbol antes de calcular la altura
        Arboles.Arbol.inicializarArbol();

        // Ahora sí podemos llamar al método
        System.out.println("Altura del árbol: " + Arboles.Arbol.calcularAltura(Arboles.Arbol.raiz));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static long calcularMCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calcularMCD(b, a % b);
        }
    }

    
    //NEIN
    public static int calcularLogaritmo(int base, int cantidad, int log) {
        if (cantidad == 1) {
            return log;
        } else {
            return calcularLogaritmo(base, cantidad / base, log + 1);
        }
    }

    //:)
    public static int calcularLogaritmo(int base, int cantidad) {
    if (cantidad == 1) {
        return 0;
    }
    return 1 + calcularLogaritmo(base, cantidad / base);
}

    
    
}
