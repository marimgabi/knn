//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Banana> todas1 = new ArrayList<>();
        ArrayList<Banana> todas2 = new ArrayList<>();

        File arquivo = new File("C:\\Users\\gabriela\\IdeaProjects\\trabsonam1\\src\\arquivo\\Banana.csv");

        Scanner leitor = new Scanner(arquivo);
        String linha = new String();
        leitor.nextLine();

        while(leitor.hasNext()){
            linha = leitor.nextLine();
            String[] values = linha.split(",");
            Banana line = new Banana(Double.parseDouble(values[0]),Double.parseDouble(values[1]), Integer.parseInt(values[2]));
            if(line.getClasse()==1){
                todas1.add(line);
            }else{
                todas2.add(line);
            }
        }

        ArrayList<Banana> treino = new ArrayList<>();
        ArrayList<Banana> teste = new ArrayList<>();
        ArrayList<Banana> validacao = new ArrayList<>();

        Collections.shuffle(todas1);
        Collections.shuffle(todas2);

        int i;

        for(i=0;i<500; i++){
            treino.add(todas1.get(i));
            treino.add(todas2.get(i));
        }

        for(i=500;i<750; i++){
            validacao.add(todas1.get(i));
            validacao.add(todas2.get(i));
        }

        for(i=750;i<1000; i++){
            teste.add(todas1.get(i));
            teste.add(todas2.get(i));
        }

        System.out.println(treino.size()+"\n"+validacao.size()+"\n"+teste.size());







    }
}
