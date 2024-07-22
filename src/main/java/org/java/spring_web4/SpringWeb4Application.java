package org.java.spring_web4;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import org.java.spring_web4.db.pojo.Specialization;
import org.java.spring_web4.db.serv.SpecializationServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWeb4Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringWeb4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
