//BEECROWD - 3139

package ex01;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
 
    public static void main(String[] args) throws IOException {
 
        Scanner entrada = new Scanner(System.in);
        FilaDinamica filaOriginal = new FilaDinamica();
        FilaDinamica filaOrdenada = new FilaDinamica();
        int nCasosTeste = entrada.nextInt();
        int nAlunos[] = new int[nCasosTeste];
        String notas[] = new String[nCasosTeste];

        for(int i = 0; i < nCasosTeste; i++) {
            nAlunos[i] = entrada.nextInt();
            entrada.nextLine();
            notas[i] = entrada.nextLine();
        }

        entrada.close();

        for(int i = 0; i < nCasosTeste; i++) {
            int notasAlunosIntDesordenado[] = new int[nAlunos[i]];
            String[] notasAlunosString = notas[i].split(" ");
            for(int j = 0; j < notasAlunosString.length; j++) {
                notasAlunosIntDesordenado[j] = Integer.parseInt(notasAlunosString[j]);
                filaOriginal.enfileira(Integer.parseInt(notasAlunosString[j]));
            }
            
            int[] notasAlunosIntOrdenado = notasAlunosIntDesordenado.clone();

            Arrays.sort(notasAlunosIntOrdenado);

            int[] notasAlunosIntOrdenadoAux = notasAlunosIntOrdenado.clone();

            for(int x = 0 ; x < notasAlunosIntOrdenado.length ; x++){
                int aux = notasAlunosIntOrdenado.length - 1;
                notasAlunosIntOrdenado[x] = notasAlunosIntOrdenadoAux[aux - x];
                filaOrdenada.enfileira(notasAlunosIntOrdenado[x]);
            }

            int count = 0;
            for(int y = 0; y < notasAlunosIntDesordenado.length; y++) {
                if(filaOriginal.desenfileira() == filaOrdenada.desenfileira()) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}