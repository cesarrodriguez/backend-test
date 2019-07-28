package br.com.viavarejo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * That class is to used by Spring-boot to run that app.
 * 
 * Please see the link class for true identity
 * 
 * @author Captain America
 * 
 */
@SpringBootApplication
@EnableFeignClients
public class BackendApplication {

	/**
	 * <p>
	 * This is method is to used by spring-boot to run that app.
	 *
	 * </p>
	 * 
	 * @param args
	 *            that argument should be used to pass arguments in command line
	 * @see <a href="link_to_ticket_repository">ticket_123</a>
	 * @since 1.0
	 */
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}

