import java.util.*;
import java.io.*;
class Solution
{
   public static void main(String[] args)throws IOException 
	{
		new Solution();
	} 
    
    
    
   public Solution()
   {
       FasterScanner sc = new FasterScanner(System.in);
       int t=sc.nextInt();
       int S,N;
       while(t-->0)
       {
           S=sc.nextInt();
           N=sc.nextInt();
           if(S<N)
             System.out.println(calculate(S,S));
             else
             System.out.println(calculate(S,N));
        }
        
    }
    
    static int calculate(int s, int n)
    {
        //n=n%2==0?n:n-1;
        int coins=0;
        int a=s;
        int b=n;
        while(b!=1 && b!=0)
        {
            b=b%2==0?b:b-1;
            coins=coins+(a/b);
            a=a%b;
            b=a;
        }
        
        if(b==1)
          coins++;
          return coins;
    }
    
    
    
    public class FastPrinter {
		PrintWriter writer;

		/**
		 * Initialize the writer.
		 */
		public FastPrinter() {
			writer = new PrintWriter(new BufferedOutputStream(System.out));
		}

		/**
		 * Print the given String and add a newline.
		 * 
		 * @param string
		 *            The given String.
		 */
		public void println(String string) {
			writer.println(string);
		}

		/**
		 * Print the given int and add a newline.
		 * 
		 * @param string
		 *            The given int.
		 */
		public void println(int integer) {
			writer.println(integer);
		}

		/**
		 * Print the given String.
		 * 
		 * @param string
		 *            The given String.
		 */
		public void print(String string) {
			writer.print(string);
		}

		private void close() {
			writer.close();
		}
	}
	
	class FasterScanner {
		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FasterScanner() {
			this(System.in);
		}

		public FasterScanner(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String nextString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public void close() {
			try {
				mIs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
