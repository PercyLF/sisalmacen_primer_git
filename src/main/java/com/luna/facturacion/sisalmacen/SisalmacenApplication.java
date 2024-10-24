package com.luna.facturacion.sisalmacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SisalmacenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisalmacenApplication.class, args);
	}

}
