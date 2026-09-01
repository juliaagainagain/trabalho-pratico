#include <stdio.h>
#include <stdlib.h>

// verifica se a palavra digitada foi FIM
int fim(char texto[]) {
    if (texto[0] == 'F' &&
        texto[1] == 'I' &&
        texto[2] == 'M' &&
        texto[3] == '\0') {

        return 1;
    }

    return 0;
}

// remove a quebra de linha do fgets
void removerQuebra(char texto[]) {
    int i = 0;

    while (texto[i] != '\0') {

        if (texto[i] == '\n' || texto[i] == '\r') {
            texto[i] = '\0';
            break;
        }

        i++;
    }
}

// soma os digitos do numero
int somaDigitos(int numero) {
    int soma = 0;

    // transforma numero negativo em positivo
    if (numero < 0) {
        numero = numero * -1;
    }

    while (numero > 0) {
        soma = soma + (numero % 10);
        numero = numero / 10;
    }

    return soma;
}

int main() {
    char linha[1000];

    // continua lendo ate encontrar FIM
    while (fgets(linha, 1000, stdin) != NULL) {

        removerQuebra(linha);

        if (fim(linha)) {
            break;
        }

        // transforma a string em inteiro
        int numero = atoi(linha);

        int resultado = somaDigitos(numero);

        printf("%d\n", resultado);
    }

    return 0;
}//fim main