import java.util.*;
import java.lang.*;
import java.io.*;

public class codechef {
    public static void main (String[] args) throws java.lang.Exception
	{
	    try {
		        FastReader sc = new FastReader();
		        int n = sc.nextInt();
				int val = sc.nextInt();
				ArrayList<lines> lines = new ArrayList<>();
				for(int i=0;i<n;i++){
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					int m1 = sc.nextInt();
					int n1 = sc.nextInt();
					lines l = new lines(x1, y1, m1, n1);
					lines.add(l);
				}
				int ans = 0;
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(i==j){
							continue;
						}
						else{
							lines l1 = lines.get(i);
							lines l2 = lines.get(j);
							boolean check = intersects(l1.x, l1.y, l1.m, l1.n, l2.x, l2.y, l2.m, l2.n);
							if(check){
								ans++;
							}
						}
					}
				}
				System.out.println(ans/2);
					
	    } catch(Exception e) {
	        return;
	    }
	}
	static boolean intersects(int a,int b,int c,int d,int p,int q,int r,int s) {
		double det, gamma, lambda;
		det = (c - a) * (s - q) - (r - p) * (d - b);
		if (det == 0) {
		  return false;
		} else {
		  lambda = ((s - q) * (r - a) + (p - r) * (s - b)) / det;
		  gamma = ((b - d) * (r - a) + (c - a) * (s - b)) / det;
		  return (0 < lambda && lambda < 1) && (0 < gamma && gamma < 1);
		}
	  };
	static class lines{
		int x;
		int y;
		int m;
		int n;
		lines(){
			x = 0;
			y = 0;
			m = 0;
			n = 0;
		}
		lines(int x1,int y1,int m1,int n1){
			x = x1;
			y = y1;
			m = m1;
			n = n1;
		}
	}
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
