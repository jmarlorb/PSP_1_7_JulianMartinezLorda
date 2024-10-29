package suplementarias;

import java.util.List;

public class Vehiculo extends Thread {

	private String idVehiculo;
	private int capacidadRestantePaquetes;
	private List<Paquete> lineaCarga;
	public Vehiculo(String id, List<Paquete> lineaCarga) {
		super();
		this.idVehiculo = id;
		this.capacidadRestantePaquetes = (int)(9*(Math.random()/Math.nextDown(1.0)+1));
		this.lineaCarga = lineaCarga;
	}
	
	public String getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(String idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getCapacidadPaquetes() {
		return capacidadRestantePaquetes;
	}
	public void setCapacidadPaquetes(int capacidadPaquetes) {
		this.capacidadRestantePaquetes = capacidadPaquetes;
	}
	public List<Paquete> getLineaCarga() {
		return lineaCarga;
	}
	public void setLineaCarga(List<Paquete> lineaCarga) {
		this.lineaCarga = lineaCarga;
	}
	
	public void run() {
		Paquete auxActual;
		synchronized(this.lineaCarga) {
			System.out.println("El camión "+ this.idVehiculo+ "empieza a recibir paquetes de la linea de carga.");
			while (this.lineaCarga.size()>0 && this.capacidadRestantePaquetes>0) {
				auxActual=this.lineaCarga.remove(0);
				System.out.println("El camión " + this.idVehiculo+" comienza a cargar paquete.");
				try {
					Thread.sleep(auxActual.getTiempoCargaEnMilisegundos());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.capacidadRestantePaquetes--;
				System.out.println("El camión " + this.idVehiculo+ " termina de cargar paquete.");
			}
			System.out.println("El camión " + this.idVehiculo+ "sale a reparto");
			this.lineaCarga.notify();
		}
		
	}
	
	
}
