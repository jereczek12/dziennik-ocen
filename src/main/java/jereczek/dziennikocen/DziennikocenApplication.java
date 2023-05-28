package jereczek.dziennikocen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class DziennikocenApplication {

	public static void main(String[] args) {
		SpringApplication.run(DziennikocenApplication.class, args);
	}

}
