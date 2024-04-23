import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Fifa> fifa = new ArrayList<>();
        int option = 0;
        do {
            try {
                System.out.println("Digite a opção desejada:");
                System.out.println("[1] Ordenar por Ordem Alfabética");
                System.out.println("[2] Ordenar por audiência TV");
                System.out.println("[3] Encerrar");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        Fifa.sortCountryes(fifa);
                        break;
                    case 2:
                        Fifa.sortAudience(fifa);
                        break;
                    case 3:
                        System.out.println("Programa Encerrado.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção invalida. Informe uma opção valida:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Insira um número inteiro");
                sc.nextLine();
            }

        } while (option != 1 && option != 2 && option != 3);

        sc.close();
    }
}