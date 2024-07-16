package org.java.spring_web4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWeb4Application {

	/**
	 * REPO: 2024-spring-web-4
	 * 
	 * TODO:
	 * 
	 * In nuovo esercizio creare classi per definire le due seguenti entita':
	 * - Farmer (contadino)
	 * - Farm (fattoria)
	 * 
	 * Farmer: name, surname, age, fattoria (obbligatgoria)
	 * Farm: name, city
	 * 
	 * Relazione tra Farm e Farmer di tipo 1-a-N (ragionare sulla direzione).
	 * 
	 * Dopo aver definito le classi e le relazioni, testare il db in DBEaver.
	 * 
	 * Creare a questo punto un controller orientato all'entita' Farmer, con
	 * i seguenti metodi:
	 * - inserimento di 3 contadini fake per velocizzare i test
	 * - visualizzazione di tutti i contadini presenti con relativa fattoria
	 * - aggiungere un nuovo contadino
	 * - eliminare un contadino presente in db
	 * - aggiornare un contadino presente in db
	 * 
	 * Per ogni azione vi sara' un end-point che permette di richiamare quel
	 * metodo attraverso PostMan.
	 * 
	 * -----------------------------------------------------------------------
	 * BONUS:
	 * -----------------------------------------------------------------------
	 * 
	 * Aggiungere controller secondario orientato all'entita' Farm, con i
	 * seguenti metodi:
	 * - lettura di tutte le fattorie presenti (senza contadini associati)
	 * - creazione di nuova fattoria
	 * - modifica di una fattoria presente in db
	 * 
	 * Per ogni azione vi sara' un end-point che permette di richiamare quel
	 * metodo attraverso PostMan.
	 * 
	 * -----------------------------------------------------------------------
	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringWeb4Application.class, args);
	}

}
