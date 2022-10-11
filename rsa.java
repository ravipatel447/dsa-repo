import java.util.*;

public class rsa {
    public static long gcd(long a,long b){
        if(a==0) return b;
        return gcd(b%a,a);
    }
    public static long[] keyGenerate(long p,long q){
        long n=(p-1)*(q-1);
        long e=Integer.MIN_VALUE;
        ArrayList<Long> al =new ArrayList<Long>();
        for(long key=2;key<=n;key++){
            if(gcd(key,n)==1){
                al.add(key);
            }
        }
        System.out.println("All possible public key is");
        for(int i=0;i<al.size();i++) System.out.println(al.get(i));
        e=al.get(0);
        long d=Integer.MIN_VALUE;
        long index=1;
        while (true){
            if((index*e)<n){
                index++;
            }
            else{
                if((index*e)%n==1){
                    d=index;
                    break;
                }
                index++;
            }
        }
        long[] key=new long[]{e,d};
        return key;
    }

    public static double powerModeFunction(long[] key,double planeText){
        double text = Math.pow(planeText,key[0])%key[1];
        return text;
    }

    public static void main(String[] arr){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter message ");
        double planeText=sc.nextDouble();
        System.out.println("Enter message p");
        long p=sc.nextLong();
        System.out.println("Enter message q");
        long q=sc.nextLong();
        long[] keyArray=keyGenerate(p,q);
        long[] publicKey=new long[]{keyArray[0],(p)*(q)};
        long[] privateKey=new long[]{keyArray[1],(p)*(q)};
        double encryptText = powerModeFunction(publicKey,planeText);
        System.out.println("Private key is "+privateKey[0]);
        System.out.println("Public key is "+publicKey[0]);
        System.out.println("Encryption text is "+encryptText);
        double decryptText=powerModeFunction(privateKey,encryptText);
        System.out.println("Decryption text is "+decryptText);
    }
}
