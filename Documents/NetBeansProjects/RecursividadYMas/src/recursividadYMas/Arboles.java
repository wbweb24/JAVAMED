package recursividadYMas;

public class Arboles {

    // Clase Nodo
    static class Nodo {
        int valor;
        Nodo izquierda, derecha;

        public Nodo(int valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    // Clase Árbol
    public static class Arbol {
        static Nodo raiz; 

        public static int calcularAltura(Nodo raiz) {
            if (raiz == null) {
                return 0;
            }
            return 1 + Math.max(calcularAltura(raiz.izquierda), calcularAltura(raiz.derecha));
        }

        // Método para inicializar el árbol
        public static void inicializarArbol() {
            raiz = new Nodo(1); // Se crea el nodo raíz
            raiz.izquierda = new Nodo(2);
            raiz.derecha = new Nodo(3);
            raiz.izquierda.izquierda = new Nodo(4);
            raiz.izquierda.derecha = new Nodo(5);
        }
    }
}
