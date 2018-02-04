import java.util.Arrays;


public class problem3 {
    public static boolean[] primes(int limit) {
        boolean[] primes = new boolean[limit+2];
        Arrays.fill(primes, Boolean.TRUE);
        
        primes[0] = false;
        primes[1] = false;

        for (int i=2; i<=limit; i++) {
            if (primes[i]) {
                for (int j=i*i; j<=limit; j+=i) {
                    if (j > limit || j < 0) break;
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
    
    public static void main(String[] args) {
        long n = 600851475143L;
        int nSqrt = (int)Math.sqrt(n);
        boolean[] isPrime = primes(nSqrt);
        
        int i = nSqrt;
        
        while (true) {
            if (isPrime[i]) {
                if (n % i == 0) break;
            }
            i--;
        }
        
        System.out.println(i);
    }
}
