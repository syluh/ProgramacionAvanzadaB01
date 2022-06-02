package semanaparcial;

import java.util.ArrayList;
import java.util.List;

public class Tarea implements Runnable{
    //Atributos o propiedades
    List<Integer> listNum;
    List<Integer> listNumAb;

    //Constructor
    public Tarea(List<Integer> listNum) {
        this.listNum = listNum;
        listNumAb = new ArrayList<>();
    }

    //Código concurrente
    @Override
    public void run() {
        // listNum.stream().filter(x -> (2 until x).filter(y => x % y == 0).sum > x);
        /*for (var num: listNum) {
            for(int i = 2; i < listNum.size(); i++){
                if(num % i == 0){

                }
            }
        }*/

        int sum = 0;

        for(int num: listNum){
            for (int i = 2; i < num; i++){
                if (num % i == 0){
                    sum += i;
                }
            }

            if (num < sum){
                listNumAb.add(num);
            }
            sum = 0;
        }
    }

    public List<Integer> getListNumAb() {
        return listNumAb;
    }
}
