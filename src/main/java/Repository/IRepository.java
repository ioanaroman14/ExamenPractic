package Repository;

import Domain.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {
    /**
     * returns a entity by id
     * @param id of the entity
     * @return a entity
     */
    T getById(String id);

    /**
     * adds a masina
     * @param entity to add
     * @throws RuntimeException if a entity with that id already exists
     */
    void insert(T entity);

    /**
     * updates a masina
     * @param entity to update
     * @throws RuntimeException if a masina with id doesn't exists
     */
    void update(T entity);

    /**
     * removes a masina
     * @param id of the masina we want to remove
     * @throws RuntimeException if a medicine with that id doesn't exists
     */
    void remove (String id);

    /**
     * @return a list with all entities
     */
    List<T> getAll();
}
