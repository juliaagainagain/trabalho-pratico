import java.util.Scanner;
public class digitos {
    //public static tipo de retorno nome
    public static int recursivo(int numero) {

        //quando o numero tiver apenas um digito, retorna ele
        if (numero < 10) {
            return numero;
        }

        //pega o ultimo digito e soma com o restante do numero
        return numero % 10 + recursivo(numero / 10);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero = sc.nextInt();

        //fica lendo enquanto tiver numero para ler
        while (sc.hasNextInt()) {

            //chama o metodo recursivo e mostra o resultado
            System.out.println(recursivo(numero));

            //le o proximo numero
            numero = sc.nextInt();
        }

        sc.close();
    }//fim main
}//fim class

