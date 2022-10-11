import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySub {
    public static void main(String[] args) throws java.lang.Exception {
        try {
            FastReader sc = new FastReader();
            PrintWriter pw = new PrintWriter(System.out);
            int t = sc.nextInt();
            while (t-- != 0) {
                String s = sc.nextLine();
                int dp[] = new int[s.length() + 1];
                Arrays.fill(dp, -1);
                int ans = posiblity(s, s.length(), 0, dp);
                pw.println(ans);
            }
            pw.flush();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }

    static int posiblity(String s, int n, int i, int dp[]) {
        if (i >= n - 2) {
            if (i == n - 2) {
                if (s.charAt(i) == 'a') {
                    if (s.charAt(i + 1) == 'b') {
                        return dp[i] = 2;
                    } else {
                        return dp[i] = 1;
                    }
                } else {
                    if (s.charAt(i + 1) == 'a') {
                        return dp[i] = 2;
                    } else {
                        return dp[i] = 1;
                    }
                }
            } else if (i == n - 1) {
                if (s.charAt(i) == 'a') {
                    return dp[i] = 1;
                } else {
                    return dp[i] = 1;
                }
            }
            return dp[i] = 0;
        } else {
            if (s.charAt(i) == 'a') {
                if (s.charAt(i + 1) == 'b') {
                    {
                        if (dp[i] == -1) {
                            return dp[i] = ((posiblity(s, n, i + 2, dp)%998244353) + (posiblity(s, n, i + 1, dp)%998244353))%998244353;
                        } else {
                            return dp[i];
                        }
                    }
                } else {
                    if (dp[i] == -1) {
                        return dp[i] = (posiblity(s, n, i + 1, dp)%998244353);
                    } else {
                        return dp[i];
                    }
                }
            } else {
                if (s.charAt(i + 1) == 'a') {
                    {
                        if (dp[i] == -1) {
                            return dp[i] = ((posiblity(s, n, i + 2, dp)%998244353) + (posiblity(s, n, i + 1, dp)%998244353))%998244353;
                        } else {
                            return dp[i];
                        }

                    }
                } else {
                    if (dp[i] == -1) {
                        return dp[i] = posiblity(s, n, i + 1, dp)%998244353;
                    } else {
                        return dp[i];
                    }
                }
            }
        }
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