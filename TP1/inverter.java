import java.util.Scanner; 
 
public class inverter { 

    //travei aqui um pouco na hora de fazer a classe mas depois lembrei 
    public static void recursivo(String entrada, int i) {

        //quando o i chegar em -1 para a recursao
        if (i >= 0) {

            //pega o caractere que esta na posicao i e imprime
            System.out.print(entrada.charAt(i));

            //chama o metodo novamente diminuindo o i
            recursivo(entrada, i - 1);
        }
    }

    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine(); //le entrada 
 
        while (!(entrada.length() == 3 && 
                 entrada.charAt(0) == 'F' && 
                 entrada.charAt(1) == 'I' && 
                 entrada.charAt(2) == 'M')) { 
 
            //chama o metodo passando a entrada e a ultima posicao
            recursivo(entrada, entrada.length() - 1);

            //pula linha depois de imprimir a entrada invertida
            System.out.println();

            //le a proxima entrada
            entrada = sc.nextLine();

        }//fim while 

        sc.close();

   }//fim do main 
}//fim class