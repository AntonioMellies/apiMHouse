package br.com.apimhouse;

import br.com.apimhouse.domain.User;
import br.com.apimhouse.enums.Perfil;
import br.com.apimhouse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApimhouseApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ApimhouseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		defaultSettings();
	}

	private void defaultSettings(){

		// Usuario Administrador Default
		try {
			User user = new User();

			user.setFirstname("Admin2");
			user.setUsername("admin");
			user.setPassword("admin");
			user.setPerfil(Perfil.ADMIN);

			userService.save(user);


		}catch (Exception e){
			System.err.println(e);
		}
	}

}
