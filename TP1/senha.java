import java.util.Scanner;

public class senha {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine(); //le entrada

        while (!(entrada.length() == 3 &&
                 entrada.charAt(0) == 'F' &&
                 entrada.charAt(1) == 'I' &&
                 entrada.charAt(2) == 'M')) {

            boolean maiuscula = false;
            boolean minuscula = false;
            boolean numero = false;
            boolean especial = false;

            if (entrada.length() >= 8) {

                for (int i = 0; i < entrada.length(); i++) {

                    char atual = entrada.charAt(i);

                    if (atual >= 'A' && atual <= 'Z') {
                        maiuscula = true;
                    }

                    else if (atual >= 'a' && atual <= 'z') {
                        minuscula = true;
                    }

                    else if (atual >= '0' && atual <= '9') {
                        numero = true;
                    }

                    else {
                        especial = true;
                    }
                }
            }

            if (entrada.length() >= 8 &&
                maiuscula &&
                minuscula &&
                numero &&
                especial) {

                System.out.println("SIM");

            } else {

                System.out.println("NAO");
            }

            entrada = sc.nextLine();//pega proxima palavra
        }

        sc.close();
    }
}