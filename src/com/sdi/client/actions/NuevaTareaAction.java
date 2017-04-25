package com.sdi.client.actions;

import java.util.Date;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sdi.client.MainMenu;
import com.sdi.client.model.Task;

import alb.util.console.Console;
import alb.util.menu.Action;

public class NuevaTareaAction implements Action{
	@Override
	public void execute() throws Exception {
		Task toCreate = new Task();
		
		String title = Console.readString("Titulo");
		while(title.trim().isEmpty()){
			Console.println("El titulo no puede ser vacio");
			title = Console.readString("Titulo");
		}
		toCreate.setTitle(title);
		
		//TODO: esto hay que cambiarlo por el login, en el propio servidor
		toCreate.setUserId(153l);
		
		toCreate.setCreated(new Date());
		
		Long idCat = Console.readLong("Id categoria (Blanco para sin categoria)");
		toCreate.setCategoryId(idCat);
		
		String comment = Console.readString("Comentario (Blanco para sin comentario)");
		toCreate.setComments(comment);
		
		
		Response rs = ClientBuilder.newClient()
				// .register( new Authenticator("sdi", "password") )
				.target(MainMenu.REST_SERVICE_URL).request()
				.post(Entity.entity(toCreate, MediaType.APPLICATION_JSON));
	
		
		System.out.println(rs.getStatusInfo().getStatusCode());
		
		if(rs.getStatus() != 204){
			Console.println("Error al actualizar");
		}
	
	}
}
