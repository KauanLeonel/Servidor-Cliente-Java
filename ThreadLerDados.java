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

            saida.println("Insira seu nome:");
            if (entrada.hasNextLine()) {
                p.setNome(entrada.nextLine());
            }

            saida.println("Insira seu endereço:");
            if (entrada.hasNextLine()) {
                p.setEndereco(entrada.nextLine());
            }
            saida.println("Insira seu CPF:");
            if (entrada.hasNextLine()) {
                p.setCpf(entrada.nextLine());
            }
            saida.println("Insira sua idade:");
            if (entrada.hasNextLine()) {
                p.setIdade(entrada.nextLine());
            }
            saida.println("Insira sua altura:");
            if (entrada.hasNextLine()) {
                p.setAltura(entrada.nextLine());
            }
            saida.println("Insira sua data de nascimento (dd/mm/aa):");
            if (entrada.hasNextLine()) {
                p.setNascimento(entrada.nextLine());
            }

            saida.println("Nome: " + p.getNome());
            saida.println("Endereco: " + p.getEndereco());
            saida.println("CPF: " + p.getCpf());
            saida.println("Idade: " + p.getIdade());
            saida.println("Altura: " + p.getAltura());
            saida.println("Data de Nascimento: " + p.getNascimento());
            ThreadGravarDados thr = new ThreadGravarDados(p);
            thr.gravar();
            saida.println("Cliente cadastrado com sucesso");
            teclado.close();
            entrada.close();
            saida.close();
        } catch (Exception e) {

            System.out.println("Sinto muito man");
        }
    }
}
