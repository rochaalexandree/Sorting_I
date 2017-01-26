import java.util.Scanner;

public class Ordenacao01{

/** SelectionSort
*/
    public static void selection(int[] vetor) {
        int menor;
        int indiceMenor;
        int cont = 0;

        for (int i = 0; i < vetor.length - 1; i++) {

            menor = vetor[i];
            indiceMenor = i;

            for (int j = i + 1; j < vetor.length; j++){
                if (vetor[j] < menor){
                    menor = vetor[j];
                    indiceMenor = j;
                }
            }

            vetor[indiceMenor] = vetor[i];
            vetor[i] = menor;
            cont++;
        }

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

    /** MergeSort - particiona o vetor ao meio varias vezes, transformando em subproblemas
    */
        private static int[] numbers;
        private static int[] helper;

        private static int number;

        public static void sort(int[] vetor) {
                numbers = vetor;
                number = vetor.length;
                helper = new int[number];
                mergesort(0, number - 1);

                for(int i = 0; i < vetor.length; i++){
                    System.out.println(vetor[i]);
                }
        }

        private static void mergesort(int low, int high) {

                if (low < high) {
                        int middle = low + (high - low) / 2;
                        mergesort(low, middle);
                        mergesort(middle + 1, high);
                        merge(low, middle, high);
                }

        }

        private static void merge(int low, int middle, int high) {

                for (int i = low; i <= high; i++) {
                        helper[i] = numbers[i];
                }

                int i = low;
                int j = middle + 1;
                int k = low;

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

                while (i <= middle) {
                        numbers[k] = helper[i];
                        k++;
                        i++;
                }

        }

    /**QuickSort - Se assemelha com o pensamento do merge, mas usufrui da particição através de um pivô
    */
    private static void quickSort(int[] vetor, int inicio, int fim) {

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

        private static int[] vector;
        private static int n;
        private static int left;
        private static int right;
        private static int largest;

        public static void buildheap(int []vector){
        n=vector.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(vector,i);
        }
    }

    public static void maxheap(int[] vector, int i){
        left=2*i;
        right=2*i+1;
        if(left <= n && vector[left] > vector[i]){
            largest=left;
        }
        else{
            largest=i;
        }

        if(right <= n && vector[right] > vector[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(vector, largest);
        }
    }

    public static void exchange(int i, int j){
        int t = vector[i];
        vector[i] = vector[j];
        vector[j] = t;
    }

    public static void sortHeap(int []vetor){
        vector = vetor;
        buildheap(vector);

        for(int i = n; i > 0; i--){
            exchange(0, i);
            n = n - 1;
            maxheap(vector, 0);
        }

        for(int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i]);
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
