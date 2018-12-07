/*
 * Fernando Eugenio Augusto de Carvalho          RA:88408
 * Tatiane Fernandes Paz Gaieski                 RA 89354
 */

import java.util.Scanner;

public class PAA2{
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Informe a quantidade de linhas: ");
        int linhas = s.nextInt();
        pascal(linhas);
    }


    private static void pascal(int linhas) {
        int[][] pascal = new int[linhas][linhas];
        //inicia a linha 0
        for (int c = 0; c < linhas; c++) {
            pascal[0][c] = 1;
        }
        //inicia a coluna 0
        for (int l = 0; l < linhas; l++) {
            pascal[l][0] = 1;
        }

        //soma das linhas e colunas com algoritimo dinamico
        for (int l = 1; l < linhas; l++) {
            for (int c = 1; c < linhas; c++) {
                //soma posicao L com coluna anterior e posicao C da linha anterior
                pascal[l][c] = pascal[l][c - 1] + pascal[l - 1][c];
            }
        }

        exibePascal(pascal);

    }

    private static void exibePascal(int[][] pascal){
        int pad;
        int aux = pascal[pascal.length -1][pascal.length-1];
        for(pad = 1 ; aux >= 10; pad++){
            aux = aux / 10;
        }
        //exibe matriz resultado
        for (int l = 0; l < pascal.length; l++) {
            for (int c = 0; c < pascal.length; c++) {
                System.out.print(PAA2.leftPadWithSpaces(String.valueOf(pascal[l][c]), pad + 1));
            }

            //pula linha
            System.out.println("");
        }
    }

    //String helper para mostrar a matriz
    private static String leftPadWithSpaces(String originalString, int length) {
        String paddedString = originalString;
        while (paddedString.length() < length) {
            paddedString = " " + paddedString;
        }
        return paddedString;
    }
}