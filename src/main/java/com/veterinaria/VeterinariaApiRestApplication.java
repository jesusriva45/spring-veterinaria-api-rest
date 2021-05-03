package com.veterinaria;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





@SpringBootApplication
public class VeterinariaApiRestApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	
	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApiRestApplication.class, args);
	}

	
	/*-El eliminar mascota debe cambiar solo estado

-Falta en registro de mascota que coga el cliente de la sesion

-Falta en registro de mascota la imagen de la foto

201823235 Rivadeneyra Llerena, Nilton Jesus+1->EXPOSITOR->14

201824180 Román Cortez, Mariano Gustavo>->12

201823176 Herrera Mestanza, Lulio Arturo->12

201824078 Chaparro Quispe, Arturo Jaime+1->EXPOSITOR->14

201021515 Raraz Janampa, Wilber Jordani->EXPOSITOR->14*/


	@Override
	public void run(String... args) throws Exception { 
		//--TODO Auto-generated method stub
		String password = "12345";	
		
		
		
		for(int i=0; i<4 ; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			
			System.out.println(passwordBcrypt);
		}
		
		
	

	}

}
