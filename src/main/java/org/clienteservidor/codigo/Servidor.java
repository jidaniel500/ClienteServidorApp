package org.clienteservidor.codigo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor implements Runnable {

	private ServerSocket socketserver;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private static final int PORT = 1201;
	private Scanner out = new Scanner(System.in);

	public static void main(String[] args) {
		Servidor ser = new Servidor();
		ser.IniciarServidor();

	}

	public void IniciarServidor() {
		try {
			Thread hiloproceso = new Thread(this);
			hiloproceso.start();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error" + e.getMessage());
		}

	}

	public void run() {
		try {
			// TODO Auto-generated method stub
			System.out.println("iniciando el servidor ");
			this.socketserver = new ServerSocket(PORT);
			Socket socket = this.socketserver.accept();
			System.out.println("servidor conectado ");

			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());

			String msgIn = "", msgout = "";

			while (!msgIn.equalsIgnoreCase("fin")) {
				msgIn = entrada.readUTF();
				System.out.println(msgIn);
				msgout = out.next();
				salida.writeUTF(msgout);
				salida.flush();
			}
			socket.close();

		} catch (IOException ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage() + " causa : " + ex.getCause());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
