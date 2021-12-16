class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] aux = new int[n], prev = new int[n];

        int result = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    aux[j] = min(helper(aux, j-1), helper(aux, j), helper(prev, j-1))+1;
                    result = Math.max(result, aux[j]);
                }
                else
                    aux[j] = 0;

            }
            prev = Arrays.copyOf(aux, aux.length);
        }
        return result*result;
    }

    public int helper(int arr[], int i){
        if(i<0 || i>=arr.length)
            return 0;
        return arr[i];
    }

    public int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

}