package br.com.voterestaurante.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.voterestaurante.dao.RestauranteDAO;
import br.com.voterestaurante.entity.Restaurante;

@WebListener
public class ListenerStartStopServer implements ServletContextListener{

	@Autowired
	private RestauranteDAO restauranteDAO;
	
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		WebApplicationContextUtils
		.getRequiredWebApplicationContext(servletContextEvent.getServletContext())
		.getAutowireCapableBeanFactory()
		.autowireBean(this);
		insereRestaurantes();
	}

	public void contextDestroyed(ServletContextEvent arg0) {}
	
	public void insereRestaurantes() {
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Girafas");
		restaurante.setImagem("giraffas.jpg");
		restauranteDAO.salvar(restaurante);

		restaurante = new Restaurante();
		restaurante.setNome("Mc Donalds");
		restaurante.setImagem("mcdonalds.png");
		restauranteDAO.salvar(restaurante);
		
		restaurante = new Restaurante();
		restaurante.setNome("Burger King");
		restaurante.setImagem("burgerKing.png");
		restauranteDAO.salvar(restaurante);
		
		restaurante = new Restaurante();
		restaurante.setNome("Habbis");
		restaurante.setImagem("habibs.png");
		restauranteDAO.salvar(restaurante);
		
		restaurante = new Restaurante();
		restaurante.setNome("Subway");
		restaurante.setImagem("subway.png");
		restauranteDAO.salvar(restaurante);
	}	
}
