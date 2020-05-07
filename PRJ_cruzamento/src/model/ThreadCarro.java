package model;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

	private String sentido;
	private Semaphore semaforo;
	
	public ThreadCarro(int sentido, Semaphore semaforo) {
		switch(sentido) {
		case 1:
			this.sentido = "Norte";
			break;
		case 2:
			this.sentido = "Leste";
			break;
		case 3:
			this.sentido = "Sul";
			break;
		case 4:
			this.sentido = "Oeste";
			break;
		}
		this.semaforo = semaforo;	
	}
	
	@Override
	public void run() {
		carroChegando();
		try {
			semaforo.acquire();
			carroPassando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			carroPassou();
		}
	}
	
	public void carroChegando() {
		try {
			sleep((int)((Math.random() * 1001) + 100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Carro indo para --" + sentido + "-- chegou no cruzamento");
	}
	
	public void carroPassando() {
		System.out.println("Carro indo para --" + sentido + "-- passando");
		try {
			sleep((int)((Math.random() * 1001) + 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void carroPassou() {
		System.out.println("Carro indo para --" + sentido + "-- passou pelo cruzamento");
	}
	
}
