import java.util.*;
class Main{
    public static void main(String rags[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int v=0;
        String vow="aeiouAEIOU";
        String n="1234567890";
        for(char c:s.toCharArray()){
            if(vow.indexOf(c)!=-1) v++;
            if(n.indexOf(c)!=-1){
                System.out.println("NO CODE");
                return;
            }
        }
        if(v==0){
            System.out.println("NO CODE");
            return;
        }
        String res="";int max=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    String a=s.substring(i,j+1);
                    if(a.length()>max){
                        max=a.length();
                        res=a;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
