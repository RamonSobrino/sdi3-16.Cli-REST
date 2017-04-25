package com.sdi.client.actions;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sdi.client.MainMenu;
import com.sdi.client.model.Task;
import com.sdi.client.util.Authenticator;

import alb.util.console.Console;
import alb.util.menu.Action;

public class MarcarCompletadaAction implements Action {

	@Override
	public void execute() throws Exception {
		Long id = Console.readLong("Id de la tarea");
		Task toUpdate = new Task();
		toUpdate.setId(id);

		Response rs = ClientBuilder.newClient()
				.register( new Authenticator(MainMenu.user, MainMenu.password) )
				.target(MainMenu.REST_SERVICE_URL).request()
				.put(Entity.entity(toUpdate, MediaType.APPLICATION_JSON));
		
		if(rs.getStatus() >= 300 ){
			Console.println("Error al actualizar");
		}
	
	}

}
