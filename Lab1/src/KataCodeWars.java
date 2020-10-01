public class KataCodeWars {
    public static void main(String[] args) {
        System.out.println(uniqVal(new int[]{1,1,1,1,2,1,1,1}));
        for (var o: SortEvenNumber(new int[]{5,2,7,4,3,8})) {
            System.out.print(o + " ");
        }
    }
    public static int[] SortEvenNumber(int[] arr){
        int i, j;
        for(i = 0; i< arr.length-1; i++){
            if(arr[i] % 2 == 0)
                continue;
            for(j = i; j < arr.length; j++){
                if(arr[j] %2 != 0 && arr[i] > arr[j]){
                    int k = arr[i];
                    arr[i] = arr[j];
                    arr[j] = k;
                }
            }
        }
        return arr;
    }

    public static int uniqVal(int[] arr){
        int i = arr[0];
        int j = 1;
        if(arr[0] != arr[1]){
            if(arr[2] == arr[1])
                return arr[0];
            else
                return arr[1];
        }
        while(arr[j] == i)
            j++;
        return arr[j];

    }
}
