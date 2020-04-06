public class Driver {
    public static void main(String[] args) {
//    KnapsackRec krec = new KnapsackRec();
      KnapsackDP dp = new KnapsackDP();
    int[] wt = {1,3,4,5};
    int[] val = {10,40,50,70};
//        System.out.println(krec.knapsack(7,wt,val,4));
        System.out.println(dp.dp(7,wt,val,val.length));
    }
}
