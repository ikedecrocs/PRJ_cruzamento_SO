package view;

import java.util.concurrent.Semaphore;

import model.ThreadCarro;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore semaforo = new Semaphore(1); //1 carro passando por vez no cruzamento --> 1 no cruzamento inteiro ou seria a ideia de "se 1 está vindo de norte/sul, nenhum de leste/oeste pode vir"?
		
		for(int c = 1; c <= 4 ; c++) {
			ThreadCarro carro = new ThreadCarro(c, semaforo);
			carro.start();
		}
	}

}
