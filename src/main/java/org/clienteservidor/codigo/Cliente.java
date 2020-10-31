package org.clienteservidor.codigo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Cliente {

	DataInputStream entrada;
	DataOutputStream salida;
	static int PUERTO_CLIENTE = 1201;
	Socket sc;
	BufferedReader bfreader;
	Scanner out = new Scanner(System.in);

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.IniciarCliente();

	}

	public void IniciarCliente() {
		try {
			sc = new Socket("127.0.0.1", PUERTO_CLIENTE);
			System.out.println("cliente conectado");
			entrada = new DataInputStream(sc.getInputStream());
			salida = new DataOutputStream(sc.getOutputStream());
			bfreader = new BufferedReader(new InputStreamReader(entrada));
			String msgIn = "", msgout = "";
			while (!msgIn.equalsIgnoreCase("fin")) {
				  msgout = out.next();
				  salida.writeUTF(msgout);
				  msgIn = entrada.readUTF();
				  System.out.println(msgIn);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("excepcion" + e.getMessage());
			
		}
	}
	

 
}
