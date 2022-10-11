import java.util.*;
import java.lang.*;
import java.io.*;

class twoandzeros {
    static long dp[] = new long [100000001];
    static int mod = 1000000007;
    public static void main(String[] args) throws java.lang.Exception {
        Arrays.fill(dp, -1);
        dp[0] = 1;
        getFactorial2(100000000);
        try {
            FastReader sc = new FastReader();
            PrintWriter pw = new PrintWriter(System.out);
            int t = sc.nextInt();
            while (t-- != 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                long ans = 0;
                for(int i=1;i<=Math.min(m, n);i++){
                    ans += ((dp[n]/dp[i])%mod)*((dp[m]/dp[i])%mod)%mod;
                    if(i%3==0){
                        ans += (dp[n]/dp[i])%mod;
                    }
                    ans = ans%mod;
                }
                pw.println(ans);
            }
            pw.flush();
        } catch (Exception e) {
            return;
        }
    }
    // public static BigInteger getFactorial(int num) {
    //     BigInteger fact = BigInteger.valueOf(1);
    //     for (int i = 1; i <= num; i++){
    //         fact = fact.multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(mod));
    //         dp[i] = fact.longValue();
    //     }
    //     return fact;
    // }
    public static long getFactorial2(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++){
            fact= fact*i%mod;
            dp[i] = fact;
        }
        return fact;
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}