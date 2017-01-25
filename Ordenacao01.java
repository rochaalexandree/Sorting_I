public class Ordenacao01{

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
        }
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Trocas "+cont+" Tempo:"+(tempoFinal - tempoInicial) / 1000d);
    }

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

    public static void main(String[] args){

        int v[] = {12, 2, 3, 52, 12, 43, 5, 13, 42, 10};

        selection(v);
        System.out.println();
        insertionSort(v);
        System.out.println();
        sort(v);//merge
   }

}