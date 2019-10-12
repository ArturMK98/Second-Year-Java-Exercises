class QuickSort {

    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int array[], int low, int high) {

        if (low < high) {

            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(array, low, high);

            // Recursively sort elements before and and ater partition
            sort(array, low, pi-1);
            sort(array, pi+1, high);
        }
    }

    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
    int partition(int array[], int low, int high) {

        int pivot = array[high];
        int i = (low-1); // Index of smaller element

        for (int j = low; j < high; j++) {

            // If current element is smaller than or equal to pivot
            if (array[j] <= pivot) {

                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i+1;
    }
}