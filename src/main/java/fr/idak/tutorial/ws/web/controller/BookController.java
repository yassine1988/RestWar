package fr.idak.tutorial.ws.web.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import fr.idak.tutorial.ws.model.Book;
import fr.idak.tutorial.ws.repository.BookRepository;

/**
 * Désormais avec la version 4 de Spring, il n'y a plus besoin d'effectuer la
 * conversion Objet en JSON et inversement. Le marshaling et le unmarshaling
 * sont effectués grâce à l'annotation @RestController.
 * 
 * @RequestMapping permet d'indiquer le mapping d'URL pour lequel le contrôleur
 *                 ou la méthode doit répondre :
 * 
 *                 value : définit l'URL à traiter ; method : définit le type de
 *                 la requête, GET dans ce cas.
 * 
 * @PathVariable permet de spécifier une valeur en dehors de l'URL (ex. : id) et
 *               de l'assigner aux paramètres de la méthode.
 * 
 * @author Yassine88
 *
 */
@RestController
@RequestMapping(value = "/api")
public class BookController {
	@Resource
	private BookRepository bookRepository;

	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable Long id) {
		return bookRepository.get(id);
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getBooks() {
		return bookRepository.getAll();
	}
}
