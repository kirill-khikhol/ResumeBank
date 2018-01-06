package tel_ran.bank_resume.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:Orm.xml")
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
