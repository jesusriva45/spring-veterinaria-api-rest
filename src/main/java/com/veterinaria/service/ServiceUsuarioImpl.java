package com.veterinaria.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.veterinaria.dao.IAccesoRolDao;
import com.veterinaria.dao.IRolDao;
import com.veterinaria.dao.IUsuarioDao;
import com.veterinaria.entity.AccesoRol;
import com.veterinaria.entity.Rol;
import com.veterinaria.entity.Ubigeo;
import com.veterinaria.entity.Usuario;


@Service
public class ServiceUsuarioImpl implements IUsuarioService, UserDetailsService{

	@Autowired
	private IUsuarioDao usuarioDao;	
	
	@Autowired
	private IRolDao rolDao;	
	
	//@Autowired
	//private EmailService emailService;
	
	
	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return  usuarioDao.findAll();
	}

	@Override
	@Transactional
	public Optional<Usuario> findById(int id) {
		// TODO Auto-generated method stub
		//
		return usuarioDao.findById(id);	
	}
	
	

	

	@Override
	@Transactional
	public Usuario save(Usuario objUser) {
		// TODO Auto-generated method stu	
		
		//emailService.sendEmailMessageWelcome(objUser.getCorreo());
		
		return usuarioDao.save(objUser);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
		
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Ubigeo> findAllRegiones() {
		return usuarioDao.findAllRegiones();
	}

	
	
	
	//---------------------- VALIDACION DE ACCESO DE UN USUARIO -------------------------
	
	private Logger logger = LoggerFactory.getLogger(ServiceUsuarioImpl.class);
	
	@Override
	@Transactional(readOnly = true)

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		// TODO Auto-generated method stub
		Usuario usu = usuarioDao.findByUsername(username);
		
		
		if(usu == null) {
			logger.error("Error en el login: El usuario : '"+username+"' no existe en el sistema");
			throw new UsernameNotFoundException("Error en el login: El usuario : '"+username+"' no existe en el sistema");
		}
		
		List<GrantedAuthority> authorities =  usu.getRol().stream().map(rol ->{ 
		return new SimpleGrantedAuthority(rol.getDescripcion());
		}).peek(authority -> logger.info("Rol : "+authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usu.getUsername(), usu.getPassword(), usu.isEstado(), true, true, true, authorities);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	
	
	//-------------LISTA DE ROLES-----------------------
	
	
	@Override
	public List<Rol> findAllRol() {
		// TODO Auto-generated method stub
		return usuarioDao.findAllRol();
	}
	
	
	//--------- BUSCAR ROL POR ID DE USUARIO ----------
	
	@Override
	public Optional<Rol> rolUsuario(int id_user) {
		// TODO Auto-generated method stub
		return rolDao.rolUsuario(id_user);
	}

	
	//---------------- ACCESO POR ROL ---------------------------------

	
	
	//---------------- MUESTRA EL ID DEL USUARIO Y EL ID DE ROL QUE TIENE -----------------
	@Override
	public List<AccesoRol> findAllAccesoRol() {
		// TODO Auto-generated method stub
		return  usuarioDao.findAllAccesoRol();
	}	
	
	

	//-------------- ACTUALIZAR ESTADO USUARIO SIN USO --------------------
	
	@Override
	public void updateEstadoUser(int id_user, boolean estado_user) {
		// TODO Auto-generated method stub
		usuarioDao.estadoUsuario(id_user, estado_user);
	}

	//---------------------- CLIENTE ---------------------------
	/*@Override
	public Usuario saveUserCliente(Usuario cli) {
		// TODO Auto-generated method stub
		
		String body = "<p>&nbsp;</p>\r\n"
				+ "<h3>El ultimo cambio que har&eacute; para el proyecto</h3>";
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("jesusriva45@gmail.com");
        message.setTo("jesusriva45@gmail.com"); 
        message.setSubject("Bienvenido a Patazas"); 
        message.setText(body);
        emailSender.send(message);
		
		return usuarioDao.save(cli);
	}
*/
	//--------------------------------------------------

	

}
