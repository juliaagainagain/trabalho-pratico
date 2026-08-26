import java.util.Scanner;

public class is {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String entrada = sc.nextLine();// pega a primeira palavra

        while (!(entrada.length() == 3 && entrada.charAt(0) == 'F' && entrada.charAt(1) == 'I'
                && entrada.charAt(2) == 'M')) {

            boolean vogal = true;
            boolean consoante = true;
            boolean inteiro = true;
            boolean real = true;
            int pontos = 0; // conta quantos pontos existem no num real

            for (int i = 0; i < entrada.length(); i++) {

                char atual = entrada.charAt(i);

                // verifica se é somente vogal
                // se encontrar algo que não é vogal, muda para falso
                if (!(atual == 'a' || atual == 'e' || atual == 'i' || atual == 'o' || atual == 'u' || atual == 'A' || atual == 'E' || atual == 'I'|| atual == 'O' || atual == 'U')) {
                    vogal = false;
                }
                // verifica se e somente consoante
                // se não for uma letra, não pode ser consoante
                if (!((atual >= 'a' && atual <= 'z') || (atual >= 'A' && atual <= 'Z'))) {

                    consoante = false;
                }
                // se for vogal, n e consoante
                if (atual == 'a' || atual == 'e' || atual == 'i' || atual == 'o' || atual == 'u' || atual == 'A' || atual == 'E' || atual == 'I'|| atual == 'O' || atual == 'U') {
                    consoante = false;
                }
                // verifica se e numero inteiro
                // nao e numero, muda para falso
                if (!(atual >= '0' && atual <= '9')) {
                    inteiro = false;
                }

                // verifica se e real
                // aqui fiquei meio travada
                // ai usei ia so pra saber como fazia e fiz assim
                // a ia fez difrente mas assim ja resolveu
                if (atual == '.' || atual == ',') {
                    pontos++;
                } else if (!(atual >= '0' && atual <= '9')) {
                    real = false;
                }

            } // fim for

            // aqui faz a verificacao!!
            // se tiver mais de um ponto, nao e real
            if (pontos > 1) {
                real = false;
            }

            if (vogal)
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (consoante)
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (inteiro)
                System.out.print("SIM ");
            else
                System.out.print("NAO ");

            if (real)
                System.out.println("SIM");
            else
                System.out.println("NAO");

        } // fim while

    }// fim main
}// fim class
