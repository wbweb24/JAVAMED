

/*  
ORIGINAL JS
let arrayOrdenado = (arr) => {
  let resultado = [];  

  arr.forEach(element => {
   
    if (Array.isArray(resultado[element])) {
      resultado[element].push(element);
    } else if (resultado[element] !== undefined) {
      resultado[element] = [resultado[element], element];
    } else {
      resultado[element] = element; // Asignar si es el primer valor.
    }
  });
*/
package ordenaryorganizar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OrdenarYOrganizar {

    
    public static void main(String[] args) {
        // Generar un array de números aleatorios
        int[] arrayAleatorio = generarArrayAleatorio(100000, 200);

        // Medir el tiempo de ejecución de cada algoritmo
        
        double quicksort = medirTiempoAlgoritmos("Quicksort", () -> quicksort(arrayAleatorio, 0, arrayAleatorio.length - 1));
        double mergeSort = medirTiempoAlgoritmos("Merge Sort", () -> mergeSort(arrayAleatorio, 0, arrayAleatorio.length - 1));
        double bubbleSort = medirTiempoAlgoritmos("Bubble Sort", () -> bubbleSort(arrayAleatorio));
        double arbolOrdenado = medirTiempoAlgoritmos("Árbol Ordenado", () -> ordenarConArbol(arrayAleatorio));
        double procesarArray = medirTiempoAlgoritmos("Procesar Array", () -> procesarArray(arrayAleatorio));
        
        imprimirTiemposOrdenados(quicksort, mergeSort, bubbleSort, arbolOrdenado, procesarArray);

        
       
    }
    
    
    public static void imprimirTiemposOrdenados(double... tiempos) {
    Arrays.sort(tiempos); // Ordena los tiempos de menor a mayor
    System.out.println("Tiempos ordenados:");
    for (double tiempo : tiempos) {
        System.out.println(tiempo + " segundos");
    }
}
     

    public static double medirTiempoAlgoritmos(String nombre, Runnable metodo) {
        long inicio = System.nanoTime();
        metodo.run();
        long fin = System.nanoTime();
        return (fin - inicio) / 1e9;
        

    }
    
    public static int[] generarArrayAleatorio(int tamano, int rango) {
        Random rand = new Random();
        int[] arr = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arr[i] = rand.nextInt(rango);
            }
            return arr;
        }
    

    ///////////////////////////////////////////////////////////////////////////////////////
    public static void mergeSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);
            merge(arr, inicio, medio, fin);
        }
    }

    private static void merge(int[] arr, int inicio, int medio, int fin) {
        int[] izquierda = Arrays.copyOfRange(arr, inicio, medio + 1);
        int[] derecha = Arrays.copyOfRange(arr, medio + 1, fin + 1);

        int i = 0, j = 0, k = inicio;
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arr[k++] = izquierda[i++];
            } else {
                arr[k++] = derecha[j++];
            }
        }
        while (i < izquierda.length) arr[k++] = izquierda[i++];
        while (j < derecha.length) arr[k++] = derecha[j++];
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public static void quicksort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(arr, inicio, fin);
            quicksort(arr, inicio, indiceParticion - 1);
            quicksort(arr, indiceParticion + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }
        intercambiar(arr, i + 1, fin);
        return i + 1;
    }

    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    ////////////////////////////////////////////////////////////////////////////////
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    public static void ordenarConArbol(int[] array) {
        Arbol arbol = new Arbol(); // Inicializamos el árbol vacío
        arbol.construirDesdeArray(array); // Llenamos el árbol con los valores del array
        List<Integer> numerosOrdenados = arbol.extraerOrdenados(); // Extraemos los datos ordenados
      
    }

    ////////////////////////////////////////////////////////////////////////////////
    static class Nodo {
        int valor;
        Nodo izquierda;
        Nodo derecha;
        boolean esNumeroCompleto;

        public Nodo(int valor) {
            this.valor = valor;
            this.izquierda = null;
            this.derecha = null;
            this.esNumeroCompleto = false;
        }

        public void marcarComoNumeroCompleto() {
            this.esNumeroCompleto = true;
        }
    }

    static class Arbol {
        Nodo raiz;

        public Arbol() {
            this.raiz = new Nodo(-1); // Valor simbólico
        }

        public void construirDesdeArray(int[] arrayAleatorio) {
            for (int num : arrayAleatorio) {
                insertarNumero(String.valueOf(num)); // Convertimos cada número a String
            }
        }

        public void insertarNumero(String numero) {
            for (int i = 1; i <= numero.length(); i++) {
                int valor = Integer.parseInt(numero.substring(0, i));
                raiz = insertarNodo(raiz, valor, i == numero.length());
            }
        }

        private Nodo insertarNodo(Nodo actual, int valor, boolean esCompleto) {
            if (actual == null) {
                Nodo nuevo = new Nodo(valor);
                if (esCompleto) nuevo.marcarComoNumeroCompleto();
                return nuevo;
            }

            if (valor < actual.valor) {
                actual.izquierda = insertarNodo(actual.izquierda, valor, esCompleto);
            } else if (valor > actual.valor) {
                actual.derecha = insertarNodo(actual.derecha, valor, esCompleto);
            }

            return actual;
        }

        public List<Integer> extraerOrdenados() {
            List<Integer> resultado = new ArrayList<>();
            recorridoInOrden(raiz, resultado);
            return resultado;
        }

        private void recorridoInOrden(Nodo actual, List<Integer> lista) {
            if (actual == null) return;

            recorridoInOrden(actual.izquierda, lista);

            if (actual.esNumeroCompleto) {
                lista.add(actual.valor);
            }

            recorridoInOrden(actual.derecha, lista);
        }
    }
    
    
    public static void procesarArray(int[] arrayAleatorio) {
    // Crear un ArrayList con suficiente capacidad
    ArrayList<Integer> lista = new ArrayList<>();

    // Agregar valores en su índice correspondiente
    for (int valor : arrayAleatorio) {
        while (lista.size() <= valor) { // Expandir el ArrayList dinámicamente
            lista.add(null); // Llenar con valores nulos para mantener la estructura
        }
        lista.set(valor, valor); // Insertar el valor en su índice
    }

    // Eliminar los índices vacíos (valores nulos)
    lista.removeIf(x -> x == null);

}

    /*SIGUE: PASAR COPIAS DE ARRAYALEATORIO PARA ORDENACION IN SITU Y VERSIONAR CADA ALGORITMO PARA NUEVO ARRAAY Y PARA MODIFICACION COPIAS
    
    */
    
    
}
