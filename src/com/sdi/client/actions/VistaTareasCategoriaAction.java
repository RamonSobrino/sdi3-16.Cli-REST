package com.sdi.client.actions;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.sdi.client.MainMenu;
import com.sdi.client.model.Task;

import alb.util.console.Console;
import alb.util.menu.Action;

public class VistaTareasCategoriaAction implements Action {

	@Override
	public void execute() throws Exception {
		// TODO: cuando exista autentificacion no poner esto
		Long id = Console.readLong("Id categoria");

		GenericType<List<Task>> listm = new GenericType<List<Task>>() {
		};

		List<Task> tasks = ClientBuilder
				.newClient()
				// .register( new Authenticator("sdi", "password") )
				.target(MainMenu.REST_SERVICE_URL)
				.path("cat/" + id.toString()).request()
				.accept(MediaType.APPLICATION_XML).get().readEntity(listm);

		Console.println("Tareas");
		Console.printf("%6s %20s %20s %20s\n", "Id", "Titulo", "Fecha Creacion", "Planeada");
		for (Task task : tasks) {
			Console.printf("%6d %20s %20s %20s\n", task.getId(), task.getTitle(), task.getCreated(),task.getPlanned().toString());
		}

	}

}
