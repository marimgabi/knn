//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner ler = new Scanner(System.in);
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

        ArrayList<Banana> validacaoCopia = new ArrayList<>();
        ArrayList<Banana> testeCopia = new ArrayList<>();

        validacaoCopia = validacao;
        testeCopia = teste;

        //CONJUNTO VALIDAÇÃO

        int k=1;
        double distancia, acuraciaK[];
        Banana[] vizinhos;
        acuraciaK = new double[12];

        //ArrayList<Banana> vizinhos = new ArrayList<>();

        for(k=1;k<12;k+=2){
            vizinhos = new Banana[k];
            for (Banana a: validacao){
                for (Banana b: treino){
                    distancia= Math.sqrt(Math.pow((a.getX()-b.getX()),2)+Math.pow((a.getY()-b.getY()),2));
                    for(i=0;i<k;i++){
                        if(Math.abs(distancia)<Math.abs(Math.sqrt(Math.pow((a.getX()-vizinhos[k].getX()),2)+Math.pow((a.getY()-vizinhos[k].getY()),2)))){
                            vizinhos[i] = b;

                        }
                    }
                }
            }
        }










    }
}
