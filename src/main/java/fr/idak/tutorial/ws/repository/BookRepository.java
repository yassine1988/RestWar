package fr.idak.tutorial.ws.repository;

import java.util.List;
import fr.idak.tutorial.ws.model.Book;

public interface BookRepository {
    /**
     * Permet de r�cup�rer tous les enregistrements de la table BOOK
     * @return Liste de Book
     */
    List<Book> getAll();

    /**
     * Permet de rechercher un BOOK � partir de son identifiant
     * @param id
     * @return Book
     */
    Book get(Long id);

    /**
     * Permet d'ajouter un nouvel enregistrement de la table BOOK
     * @param book
     */
    void create(Book book);

    /**
     * 
     * Permet de supprimer un BOOK
     * @param book
     */
    void delete(Book book);

    /**
     * Permet de mettre � jour un BOOK 
     * @param book
     */
    void update(Book book);

}
