package main;

import java.util.ArrayList;

import suplementarias.Paquete;
import suplementarias.Vehiculo;

public class E1_JML {

	public static void main(String[] args) {
		ArrayList<Paquete> lineaCarga = new ArrayList<Paquete>();
		for (int i = 0; i < 21; i++) {
			lineaCarga.add(new Paquete());
		}
		Vehiculo v1 = new Vehiculo("CA-1",lineaCarga);
		Vehiculo v2 = new Vehiculo("CA-2",lineaCarga);
		v1.start();
		v2.start();
		try {
			v1.join();
			v2.join();
			if (lineaCarga.size()==0) {
				System.out.println("Todos los paquetes han sido repartidos");
			} else {
				System.out.println("Quedan paquetes por repartir.");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
