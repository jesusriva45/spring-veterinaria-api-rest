package com.veterinaria.auth;

import java.util.HashMap;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;


import com.veterinaria.entity.Usuario;

import com.veterinaria.service.IUsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	@Autowired
	private IUsuarioService usuarioService;
	


	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		
		//Optional<Cliente> cliente = clienteService.findByIdUsuario(usuario.getIdusuario());
		
		Map<String, Object> info = new HashMap<>();
		info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
		info.put("idusuario", usuario.getIdusuario());
		info.put("nombres", usuario.getNombres());
		info.put("apellidos", usuario.getApellidos());
		info.put("correo", usuario.getCorreo());
		
		
		//info.put("idCliente", cliente.map((json)-> json.getIdcliente()));
		//info.put("cliente", cliente);
		
		//info.put("usu", usuario );
		//info.put("rol", usuario.getRol().get(1).toString());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
