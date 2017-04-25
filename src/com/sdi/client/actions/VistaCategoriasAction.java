package com.sdi.client.actions;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.sdi.client.MainMenu;
import com.sdi.client.model.Category;

import alb.util.console.Console;
import alb.util.menu.Action;

public class VistaCategoriasAction implements Action {

	@Override
	public void execute() throws Exception {
		// TODO: cuando exista autentificacion no poner esto
		Long id = Console.readLong("Id usuario");

		GenericType<List<Category>> listm = new GenericType<List<Category>>() {
		};

		List<Category> cats = ClientBuilder
				.newClient()
				// .register( new Authenticator("sdi", "password") )
				.target(MainMenu.REST_SERVICE_URL).path("userCats/"+id.toString())
				.request().accept(MediaType.APPLICATION_JSON).get()
				.readEntity(listm);

		Console.println("Categorias");
		Console.println("ID\tNombre");
		for (Category cat : cats) {
			Console.printf("%d\t%s\n", cat.getId(), cat.getName());
		}

	}

}
