package Repository;

import Config.Configurator;
import Entity.AbstractEntity;
import Entity.Person;
import Repository.Search.PersonPredicates;
import Repository.Sort.SortStrategy;
import Repository.Sort.Sorter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Nikita Vasilyev
 */
public abstract class AbstractRepository<E extends AbstractEntity, K> {
    private static final Logger logger = Logger.getLogger(AbstractRepository.class);
    protected static final int INITIAL_SIZE = 10;
    protected Object[] entities = new Object[INITIAL_SIZE];
    private int lastElem = 0;
    protected Sorter<E> sorter = new Sorter<>();
    protected SortStrategy<E> defaultSortStrategy = Configurator.getInstance().getSortStrategy();


    /**
     * Adding by object
     * @param e new entity
     */
    public void add(E e) {
        if (lastElem == entities.length) {
            resize();
        }
        entities[lastElem++] = e;
    }

    /**
     * Resizes the people array when there is no more space to add a new one
     */
    private void resize() {
        Object[] temp = new Object[entities.length * 2];
        System.arraycopy(entities, 0, temp, 0, entities.length);
        entities = temp;
    }


    /** Find entity by its position in array
     * @param i index of array
     * @return entity by its array position
     */
    public E get(int i){
        return (E)entities[i];
    }


    /**
     * @param id id of entity
     * @return entity by its ID
     */
    public E getById(K id){
        for(Object e: entities){
            if (((E)e).getId().equals(id)){
                return (E)e;
            }
        }
        logger.warn("No entity with ID = "+id+" found");
        return null;
    }


    /**
     * @param o object to be found
     * @return object which is equal to @param o
     */
    public E get(Object o){
        for (Object e: entities){
            if(e.equals(o)){
               return (E)e;
            }
        }
        logger.warn("No entity =>"+o+" found");
        return null;
    }

    /**
     * @return size of the repository
     */
    public int size() {
        return entities.length;
    }


    /**
     * @return count of all not-null elemnts on repository
     */
    public int elementsCount() {
        return lastElem;
    }


    /**
     * @param o object to be deleted
     * @return if deletion was successful or not
     */
    public boolean delete(Object o){
        boolean found = false;
        int i = -1;
        while (!found && i < entities.length) {
            i++;
            if (entities[i] != null && entities[i].equals(o)) {
                found = true;
            }
        }
        for (int j = i; j < entities.length - 1; j++) {
            entities[j] = entities[j + 1];
        }
        entities[entities.length - 1] = null;
        lastElem--;
        return found;
    }


    /**
     * @param index index in array by which the entity has to be deleted
     * @return if deletion was successful or not
     */
    public boolean delete(int index){
        if (index <= entities.length) {
            for (int j = index; j < entities.length - 1; j++) {
                entities[j] = entities[j + 1];
            }
            entities[entities.length - 1] = null;
            return true;
        }
        return false;
    }


    /**
     * @param id of entity to be deleted
     * @return if deletion was successful or not
     */
    public boolean deleteById(K id){
        return delete(getById(id));
    }

    /**
     * @param var1 array to be written into
     * @param <T> type of array to be written into
     * @return array of entities
     */
    public <T> T[] getAll(T[] var1) {
        if (var1.length <this.lastElem) {
            return (T[])Arrays.copyOf(this.entities, this.lastElem, var1.getClass());
        } else {
            System.arraycopy(this.entities, 0, var1, 0, this.lastElem);
            if (var1.length > this.lastElem) {
                var1[this.lastElem] = null;
            }

            return var1;
        }

    }

    /**
     * Sorting with deafult sort strategy
     * @param comparator determines by which field to sort
     */
    public void sort(Comparator<E> comparator){
        defaultSortStrategy.execute(entities, comparator);
    }

    /**
     * @return last not-null element of array
     */
    protected int getLastElem(){
        return lastElem;
    }


}
