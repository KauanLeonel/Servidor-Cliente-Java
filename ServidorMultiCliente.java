
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServidorMultiCliente {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);

        System.out.println("Porta 12345 aberta! Aguardando conexão...");

       while(true){
        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado");
        ThreadLerDados tcn = new ThreadLerDados(cliente);
        tcn.start();
       }

    
    }
}

