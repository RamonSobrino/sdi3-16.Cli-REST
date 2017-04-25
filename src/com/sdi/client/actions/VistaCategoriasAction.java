package com.sdi.client.actions;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.sdi.client.MainMenu;
import com.sdi.client.model.Category;
import com.sdi.client.util.Authenticator;

import alb.util.console.Console;
import alb.util.menu.Action;

public class VistaCategoriasAction implements Action {

	@Override
	public void execute() throws Exception {


		GenericType<List<Category>> listm = new GenericType<List<Category>>() {
		};

		List<Category> cats = ClientBuilder
				.newClient()
				.register( new Authenticator(MainMenu.user, MainMenu.password) )
				.target(MainMenu.REST_SERVICE_URL).path("userCats/")
				.request().accept(MediaType.APPLICATION_JSON).get()
				.readEntity(listm);

		Console.println("Categorias");
		Console.println("ID\tNombre");
		for (Category cat : cats) {
			Console.printf("%d\t%s\n", cat.getId(), cat.getName());
		}

	}

}
