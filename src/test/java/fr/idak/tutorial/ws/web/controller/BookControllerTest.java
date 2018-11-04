package fr.idak.tutorial.ws.web.controller;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import fr.idak.tutorial.ws.config.ContextConfig;
import fr.idak.tutorial.ws.config.WebMvcConfig;

/**
 * @WebAppConfiguration : permet d'indiquer au contexte Spring que nous allons
 *                      utiliser un WebApplicationContext lors d'ex�cution des
 *                      tests. Cette annotation est n�cessaire pour la
 *                      configuration du Mock MVC de Spring. La classe MockMvc
 *                      est initialis�e dans la m�thode init() � partir de la
 *                      classe WebApplicationContext avant chaque test.
 * 
 * @author Yassine88
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextConfig.class, WebMvcConfig.class })
@WebAppConfiguration
public class BookControllerTest {

	@Resource
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/**
	 * CheckGetBookByIdUrl() : v�rifie le bon fonctionnement l'URL '/api/book/{id}'
	 * du Web service.
	 * 
	 * @throws Exception
	 */
	@Test
	public void checkGetBookByIdUrl() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/book/1")).andExpect(MockMvcResultMatchers.status().isOk());

	}

	/**
	 * CheckGetBooksUrl() : v�rifie le bon fonctionnement l'URL '/api/books' du Web
	 * service.
	 * 
	 * @throws Exception
	 */
	@Test
	public void checkGetBooksUrl() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/books")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	/**
	 * getBooks() : v�rifie le nombre de bouquins par l'URL /api/books du Web service.
	 * 
	 * @throws Exception
	 */
	@Test
	public void getBooks() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/books")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(11)));
	}
}
