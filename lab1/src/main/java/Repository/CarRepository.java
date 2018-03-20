package Repository;

import Entity.Car;
import Repository.Search.CarPredicates;
import Repository.Sort.*;
import Repository.Sort.Comparators.HorsePowerComparator;
import Repository.Sort.Comparators.ModelComparator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * @author Nikita Vasilyev
 */
public class CarRepository extends AbstractRepository<Car, Integer>{

    private static final Logger logger = Logger.getLogger(CarRepository.class);

    public CarRepository() {
        BasicConfigurator.configure();
    }

    /**
     * Sorts cars array by horsepower, Sort strategy by default is equal to property file
     */

    public void sortByHorsepower() {
        logger.info("Started sorting by horsepower");
        sort(new HorsePowerComparator());
    }

    /**
     * Sorts cars array by model
     * @param strategy sorting algorithm
     */
    public void sortByModel(SortStrategy<Car> strategy){
        logger.info("Started sorting by model");
        try {
            sorter.setSortStrategy(strategy);
            strategy.execute(entities, new ModelComparator());
        }
        catch (Exception e){
            logger.error(e);
        }
    }
    /**
     * Sorts cars array by Model, Sort strategy by default is equal to property file
     */
    public void sortByModel() {
        sort(new ModelComparator());
    }


    /**
     * Sorts cars array by horsepower
     * @param strategy sorting algorithm
     */
    public void sortByHorsepower(SortStrategy<Car> strategy){
        logger.info("Started sorting by horsepower");
        try {
            sorter.setSortStrategy(strategy);
            sorter.execute(entities, new HorsePowerComparator());
        }
        catch (Exception e){
            logger.error(e);
        }
    }



    /**
     * Find Cars with certain amount of horsepower
     * @param hp horsepower
     * @return repository containing cars with certain amount of horsepower
     */
    public CarRepository getByHorsePower(int hp){
        logger.info("Finding by horsepower");
        CarRepository result = new CarRepository();
        for (int i = 0; i < getLastElem(); ++i) {
            if (CarPredicates.horsepowerIs(hp).test(get(i))){
                result.add(get(i));
            }
        }
        return result;
    }

    /**
     * Find Cars of certain model
     * @param model model of car
     * @return repository containing cars of certain model
     */
    public CarRepository getByModel(String model){
        logger.info("Finding by model");
        CarRepository result = new CarRepository();
        for (int i = 0; i < getLastElem(); ++i) {
            if (CarPredicates.modelIs(model).test(get(i))){
                result.add(get(i));
            }
        }
        return result;
    }


}
