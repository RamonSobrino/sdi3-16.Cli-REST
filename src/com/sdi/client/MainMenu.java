package com.sdi.client;

import com.sdi.client.actions.MarcarCompletadaAction;
import com.sdi.client.actions.NuevaTareaAction;
import com.sdi.client.actions.VistaCategoriasAction;
import com.sdi.client.actions.VistaTareasCategoriaAction;

import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu{
	
	public final static String REST_SERVICE_URL = "http://localhost:8280/sdi2-16WEB/rest/UserServicesRest";
	
	public MainMenu() {
		menuOptions = new Object[][] {
				{ "Menu de usuario", null },
				{"Ver lista categorias", VistaCategoriasAction.class},
				{"Ver tareas categoria", VistaTareasCategoriaAction.class},
				{"Marcar tarea completada", MarcarCompletadaAction.class},
				{"Nueva tarea", NuevaTareaAction.class},
				
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}
