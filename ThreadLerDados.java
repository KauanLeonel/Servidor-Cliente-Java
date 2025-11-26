import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ThreadLerDados extends Thread {

    Socket cliente;

    public ThreadLerDados(Socket cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {

            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            Scanner entrada = new Scanner(cliente.getInputStream());
            Pessoa p = new Pessoa();
            System.out.println("Insira seu nome:");
            if(teclado.hasNextLine()){
                p.setNome(teclado.nextLine());
            }

            System.out.println("Insira seu endereço:");
            if(teclado.hasNextLine()){
                p.setEndereco(teclado.nextLine());
            }
            System.out.println("Insira seu CPF:");
            if(teclado.hasNextLine()){
                p.setCpf(teclado.nextLine());
            }
            System.out.println("Insira sua idade:");
            if(teclado.hasNextLine()){
                p.setIdade(teclado.nextLine());
            }
            System.out.println("Insira sua altura:");
            if(teclado.hasNextLine()){
                p.setAltura(teclado.nextLine());
            }
            System.out.println("Insira sua data de nascimento (dd/mm/aa):");
            if(teclado.hasNextLine()){
                p.setNascimento(teclado.nextLine());
            }

            System.out.println("Cliente cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println("Sinto muito man");
        }
    }
}
