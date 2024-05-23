public class Main {

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 5, 6, 1, 7, 8, 9};
        evenOddSearch(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void evenOddSearch(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            while (arr[l] % 2 == 0 && l < r)
                l++;
            while (arr[r] % 2 == 1 && l < r)
                r--;
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        // Ordina i numeri pari in modo crescente
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // Ordina i numeri dispari in modo decrescente
        for (int i = l; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
