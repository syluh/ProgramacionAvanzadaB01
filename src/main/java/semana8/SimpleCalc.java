package semana8;

public class SimpleCalc {
    private int op1;

    private int op2;

    public SimpleCalc(int op1, int op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    public int suma(){
        return op1 + op2;
    }

    public int restar(){
        return op1 - op2;
    }
}
