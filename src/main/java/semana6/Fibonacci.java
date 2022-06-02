package semana6;

public class Fibonacci {
    public static int calcFibonacci(int nro){
        if (nro <= 1){
            return nro;
        }else {
            return calcFibonacci(nro -1) + calcFibonacci(nro - 2);
        }
    }

    public static void main(String[] args) {
        for (int nro = 0; nro < 40; nro++){
            System.out.printf("F[%d]: %d\n", nro, calcFibonacci(nro));
        }
    }
}
