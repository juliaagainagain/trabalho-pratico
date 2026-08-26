package TP1;
import java.util.Scanner;

class cesar{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();

        while (!(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I' && entrada.charAt(2) == 'M')) {

            String cifrada = "";//tem que criar uma nova string no java

            for (int i = 0; i < entrada.length(); i++) {
                cifrada += (char)(entrada.charAt(i) + 3); //aqui propriamente esta cifrando
            }

            System.out.println(cifrada); //imprime a cifrada

            entrada = sc.nextLine();//lenado a proxima 
        }

        sc.close();
    

    }//fim main

}//fim class 