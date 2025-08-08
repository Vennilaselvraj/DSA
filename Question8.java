import java.util.*;
class Main{
    public static void main(String rags[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] bins=new int[n];
        for(int i=0;i<n;i++){
            bins[i]=sc.nextInt();
        }
        int orderquantity=sc.nextInt();
        int k=sc.nextInt();
        int sum=0;
        for(int i=0;i<n;i++){
            sum=0;
            int b=i;
            for(int j=i;j<i+k;j++){
                //System.out.print(bins[j]+" ");
                sum+=bins[j];
                b=j;
            }
            if(sum==orderquantity){
                System.out.print((i+1)+" "+(b+1));
                return;
            }
        }
    }
}
