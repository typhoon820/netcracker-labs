package Config;

import Repository.Sort.BubbleSort;
import Repository.Sort.InsertionSort;
import Repository.Sort.QuickSort;
import Repository.Sort.SortStrategy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Nikita Vasilyev
 */
public class Configurator {

    private Properties props = new Properties();
    /**
     * path to project root
     */
    private String rootPath;

    private static Configurator configurator = null;

    /**
     * Sort strategy to be selected from .properties file
     */
    private SortStrategy sortStrategy;

    /**
     * @return sort stratedy, parsed from .property file
     */
    public SortStrategy getSortStrategy() {

        switch (props.getProperty("sort")) {
            case "bubble":
                return new BubbleSort();
            case "quick":
                return new QuickSort();
            case "insert":
                return new InsertionSort();
            default:
                return new BubbleSort();
        }
    }

    private Configurator() {
        try {
            rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            props.load(new FileInputStream(rootPath + "config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Configurator getInstance() {
        if (configurator == null) {
            configurator = new Configurator();
        }
        return configurator;
    }


}
