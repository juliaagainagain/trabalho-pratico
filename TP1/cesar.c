#include <stdio.h>

// verifica se a palavra digitada foi FIM
int fim(char texto[]) {
    return texto[0] == 'F' &&
           texto[1] == 'I' &&
           texto[2] == 'M' &&
           texto[3] == '\0';
}

// remove a quebra de linha do fgets
void removerQuebra(char texto[]) {
    int indice = 0;

    while (texto[indice] != '\0' &&
           texto[indice] != '\n' &&
           texto[indice] != '\r') {

        indice++;
    }

    texto[indice] = '\0';//vai ate o final da palavra
}

// faz a cifra de cesar usando recursividade
void cifrarRec(char texto[], int indice) {

    // verifica se ainda nao chegou no final da string
    if (texto[indice] != '\0') {

        // desloca o caractere em 3 posicoes
        texto[indice] = texto[indice] + 3;

        // chama a funcao para a proxima posicao
        cifrarRec(texto, indice + 1);
    }
}

// inicia a recursao na primeira posicao
void cifrar(char texto[]) {
    cifrarRec(texto, 0);
}

int main() {
    char linha[1000];

    // continua lendo ate encontrar FIM
    while (fgets(linha, 1000, stdin) != NULL) {

        removerQuebra(linha);

        if (fim(linha)) {
            break;
        }

        // aplica a cifra na palavra
        cifrar(linha);

        printf("%s\n", linha);
    }

    return 0;
}//fim main