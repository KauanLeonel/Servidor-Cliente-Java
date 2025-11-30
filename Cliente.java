
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket cliente = new Socket("127.0.0.1", 12345);

        Scanner entrada = new Scanner(cliente.getInputStream());
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        Scanner teclado = new Scanner(System.in);

        // Nome,
        if (entrada.hasNextLine()) {
            System.out.print(entrada.nextLine());
        }

        saida.println(teclado.nextLine());

        // Endereço,
        if (entrada.hasNextLine()) {
            System.out.print(entrada.nextLine());
        }

        saida.println(teclado.nextLine());

        // CPF,
        if (entrada.hasNextLine()) {
            System.out.print(entrada.nextLine());
        }
        saida.println(teclado.nextLine());

        // Idade,
        if (entrada.hasNextLine()) {
            System.out.print(entrada.nextLine());
        }
        saida.println(teclado.nextLine());

        // Altura e
        if (entrada.hasNextLine()) {
            System.out.print(entrada.nextLine());
        }
        saida.println(teclado.nextLine());

        // Data de Nascimento (use string nesse campo).
        if (entrada.hasNextLine()) {
            System.out.print(entrada.nextLine());
        }
        saida.println(teclado.nextLine());

        while (entrada.hasNextLine()) { //Lê tudo o que o servidor mandou até fechar
            System.out.println(entrada.nextLine()); 
        }
        teclado.close();
        saida.close();
        entrada.close();
    }
}
