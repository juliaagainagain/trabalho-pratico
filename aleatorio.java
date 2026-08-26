import java.util.Scanner;
import java.util.Random;

public class aleatorio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //isso aqui nao entendi bem usei IA para saber como colocava
        Random gerador = new Random(); 
        // aqui tamem nao sabia definir tive que pesquisar no google mesmo 
        gerador.setSeed(4); 

        String entrada = sc.nextLine(); //entrada normal

        while (!(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M')) {

            //essas duas linhas seguintes serve para:
            //sortear duas letras do alfabeto uma para trocar e outra ser trocada
            //a(97)+ numero aletorio
            //o (char) transforma o numero em letra depois
            char letra1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26)); 
            char letra2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

            String alterada = "";

            //percorre trocando if (i) == letra troca 
            for (int i = 0; i < entrada.length(); i++) {
                if (entrada.charAt(i) == letra1) {
                    alterada += letra2; //troca
                } else {
                    alterada += entrada.charAt(i); //coloca o mesmo na string nova que chama alterada
                }
            }

            System.out.println(alterada);

            entrada = sc.nextLine();
        }//fim while 

        sc.close();
    }//fim main
}//fim class

