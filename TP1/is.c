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

    texto[indice] = '\0';
}

// verifica se o caractere e uma vogal
int ehVogal(char caractere) {
    return caractere == 'a' ||
           caractere == 'e' ||
           caractere == 'i' ||
           caractere == 'o' ||
           caractere == 'u' ||
           caractere == 'A' ||
           caractere == 'E' ||
           caractere == 'I' ||
           caractere == 'O' ||
           caractere == 'U';
}

// verifica se o caractere e uma letra
int ehLetra(char caractere) {
    return (caractere >= 'A' && caractere <= 'Z') ||
           (caractere >= 'a' && caractere <= 'z');
}

// verifica recursivamente se todos os caracteres sao vogais
int vogaisRec(char texto[], int indice) {

    // chegou no final da palavra
    if (texto[indice] == '\0') {
        return indice > 0;
    }

    return ehVogal(texto[indice]) &&
           vogaisRec(texto, indice + 1);
}

int somenteVogais(char texto[]) {
    return vogaisRec(texto, 0);
}

// verifica recursivamente se todos os caracteres sao consoantes
int consoantesRec(char texto[], int indice) {

    // chegou no final da palavra
    if (texto[indice] == '\0') {
        return indice > 0;
    }

    return ehLetra(texto[indice]) &&
           !ehVogal(texto[indice]) &&
           consoantesRec(texto, indice + 1);
}

int somenteConsoantes(char texto[]) {
    return consoantesRec(texto, 0);
}

// verifica se a string representa um numero inteiro
int inteiroRec(char texto[], int indice) {

    // chegou no final da string
    if (texto[indice] == '\0') {

        // evita aceitar apenas + ou -
        return indice > 0 &&
               !((indice == 1) &&
               (texto[0] == '+' || texto[0] == '-'));
    }

    // aceita sinal somente na primeira posicao
    if (indice == 0 &&
        (texto[indice] == '+' || texto[indice] == '-')) {

        return inteiroRec(texto, indice + 1);
    }

    // verifica se o caractere atual e um digito
    return texto[indice] >= '0' &&
           texto[indice] <= '9' &&
           inteiroRec(texto, indice + 1);
}

int ehInteiro(char texto[]) {
    return inteiroRec(texto, 0);
}

// verifica se os caracteres faz parte de um numero real
int caracteresReaisRec(char texto[], int indice) {

    if (texto[indice] == '\0') {
        return 1;
    }

    // aceita sinal somente no inicio
    if (indice == 0 &&
        (texto[indice] == '+' || texto[indice] == '-')) {

        return caracteresReaisRec(texto, indice + 1);
    }

    // aceita numeros, ponto ou virgula
    return ((texto[indice] >= '0' && texto[indice] <= '9') ||
            texto[indice] == '.' ||
            texto[indice] == ',') &&
            caracteresReaisRec(texto, indice + 1);
}

// conta quantos pontos ou virgulas existem
int contarSeparadoresRec(char texto[], int indice) {

    if (texto[indice] == '\0') {
        return 0;
    }

    int separador = 0;

    if (texto[indice] == '.' || texto[indice] == ',') {
        separador = 1;
    }

    return separador + contarSeparadoresRec(texto, indice + 1);
}

// conta quantos digitos existem
int contarDigitosRec(char texto[], int indice) {

    if (texto[indice] == '\0') {
        return 0;
    }

    int digito = 0;

    if (texto[indice] >= '0' && texto[indice] <= '9') {
        digito = 1;
    }

    return digito + contarDigitosRec(texto, indice + 1);
}

// verifica se a string representa um numero real
int ehReal(char texto[]) {

    return caracteresReaisRec(texto, 0) &&
           contarDigitosRec(texto, 0) > 0 &&
           contarSeparadoresRec(texto, 0) <= 1;
}

int main() {
    char linha[1000];

    // le as entradas ate encontrar FIM
    while (fgets(linha, 1000, stdin) != NULL) {

        removerQuebra(linha);

        if (fim(linha)) {
            break;
        }

        printf("%s %s %s %s\n",
               somenteVogais(linha) ? "SIM" : "NAO",
               somenteConsoantes(linha) ? "SIM" : "NAO",
               ehInteiro(linha) ? "SIM" : "NAO",
               ehReal(linha) ? "SIM" : "NAO");
    }

    return 0;
}//fim main