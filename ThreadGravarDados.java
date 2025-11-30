import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadGravarDados extends Thread {
    Pessoa cliente;

    private static final Object lock = new Object(); // CHAVE COMPARTILHADA, pelo visto precisa disso

    public ThreadGravarDados(Pessoa cliente) {
        this.cliente = cliente;
    }

    public void run() {
        try {
            gravar();
        } catch (Exception e) {
            System.out.println("Deu erro em algum lugar aqui");
        }
    }

    void gravar() throws IOException {
        synchronized (lock) { // Agora sim, sincroniza
            String arqEscrita = "dados.txt";
            // ESCRITA

            System.out.println("Escrevendo no arquivo " + arqEscrita);
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqEscrita, true));
            buffWrite.write(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getIdade() + ";"
                    + cliente.getEndereco() + ";" + cliente.getAltura() + ";" + cliente.getNascimento() + ";\r\n");

            buffWrite.close();
        }
    }
}
