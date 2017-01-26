import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ordenacao01{

/** SelectionSort
*/
    public static void selection(int[] vetor) {
        int menor;
        int indiceMenor;
        int cont = 0;

        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < vetor.length - 1; i++) {
            // antes de comparar, considera-se menor o valor atual do loop
            menor = vetor[i];
            indiceMenor = i;

            // compara com os outros valores do vetor
            for (int j = i + 1; j < vetor.length; j++){
                if (vetor[j] < menor){
                    menor = vetor[j];
                    indiceMenor = j;
                }
            }

            // troca os valores menor e maior
            vetor[indiceMenor] = vetor[i];
            vetor[i] = menor;
            cont++;
        }
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Trocas "+cont+" Tempo:"+(tempoFinal - tempoInicial) / 1000d);

        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
    }

/** InsertionSort
*/

    public static void insertionSort(int[] vetor){
        int cont = 0;

        long tempoInicial = System.currentTimeMillis();
        for (int i = 1; i < vetor.length; i++){

            int key = vetor[i];
            int j = i;

            while ((j > 0) && (vetor[j-1] > key)){
                vetor[j] = vetor[j-1];
                j -= 1;
                cont++;
            }
            vetor[j] = key;
        }
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Trocas "+cont+" Tempo:"+(tempoFinal - tempoInicial) / 1000d);

        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
        }
    }

    /** MergeSort - particiona o vetor ao meio
    */
        private static int[] numbers;
        private static int[] helper;

        private static int number;

        public static void sort(int[] values) {
                numbers = values;
                number = values.length;
                helper = new int[number];
                mergesort(0, number - 1);

                for(int i = 0; i < values.length; i++){
                    System.out.println(values[i]);
                }
        }

        private static void mergesort(int low, int high) {
                // check if low is smaller then high, if not then the array is sorted
                if (low < high) {
                        // Get the index of the element which is in the middle
                        int middle = low + (high - low) / 2;
                        // Sort the left side of the array
                        mergesort(low, middle);
                        // Sort the right side of the array
                        mergesort(middle + 1, high);
                        // Combine them both
                        merge(low, middle, high);
                }

        }

        private static void merge(int low, int middle, int high) {

                // Copy both parts into the helper array
                for (int i = low; i <= high; i++) {
                        helper[i] = numbers[i];
                }

                int i = low;
                int j = middle + 1;
                int k = low;
                // Copy the smallest values from either the left or the right side back
                // to the original array
                while (i <= middle && j <= high) {
                        if (helper[i] <= helper[j]) {
                                numbers[k] = helper[i];
                                i++;
                        } else {
                                numbers[k] = helper[j];
                                j++;
                        }
                        k++;
                }
                // Copy the rest of the left side of the array into the target array
                while (i <= middle) {
                        numbers[k] = helper[i];
                        k++;
                        i++;
                }

        }

    /**QuickSort - Se assemelha com o pensamento do merge, mas usufrui da particição através de um pivô
    */
    private static void quickSort(int[] vetor, int inicio, int fim) {
               for(int i = 0; i < vetor.length; i++)
                    System.out.println(vetor[i]);

               if (inicio < fim) {
                      int posicaoPivo = separar(vetor, inicio, fim);
                      quickSort(vetor, inicio, posicaoPivo - 1);
                      quickSort(vetor, posicaoPivo + 1, fim);
               }
               for(int i = 0; i < vetor.length; i++){
                    System.out.println(vetor[i]);
                }
         }

         private static int separar(int[] vetor, int inicio, int fim) {
               int pivo = vetor[inicio];
               int i = inicio + 1, f = fim;
               while (i <= f) {
                      if (vetor[i] <= pivo)
                             i++;
                      else if (pivo < vetor[f])
                             f--;
                      else {
                             int troca = vetor[i];
                             vetor[i] = vetor[f];
                             vetor[f] = troca;
                             i++;
                             f--;
                      }
               }
               vetor[inicio] = vetor[f];
               vetor[f] = pivo;
               return f;
        }


        /**
            HeapSort
        */

        private static int[] a;
        private static int n;
        private static int left;
        private static int right;
        private static int largest;

        public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }

    public static void maxheap(int[] a, int i){
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }

        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        }

    public static void sortHeap(int []a0){
        a = a0;
        buildheap(a);

        for(int i = n; i > 0; i--){
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }

        for(int i = 0; i < a0.length; i++){
            System.out.println(a0[i]);
        }
    }

        public static void main(String[] args){

            String k = args[0];
            Scanner scan = new Scanner(System.in);

            String linha = scan.nextLine();

            int n = Integer.parseInt(linha);
            int x = 0;

            int vetor[] = new int[n];
            for(int i = 0; i < n; i++){
                linha = scan.nextLine();
                x = Integer.parseInt(linha);
                vetor[i] = x;
            }

            switch(k){
                case "1":
                        selection(vetor);
                        break;
                case "2":
                        insertionSort(vetor);
                        break;
                case "3":
                        sort(vetor);//merge
                        break;
                case "4":
                        quickSort(vetor,0,vetor.length-1);
                        break;
                case "5":
                        sortHeap(vetor);
                        break;
                default:
                        System.out.println("Digito inválido");
            }

        }

}
