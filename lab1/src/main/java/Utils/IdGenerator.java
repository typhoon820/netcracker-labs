package Utils;

/**
 * Singleton id generator
 */
public class IdGenerator {
    private static IdGenerator generator = null;
    private int id;

    private IdGenerator(){
        id =0;
    }
    public static IdGenerator getInstance(){
        if(generator== null){
            generator = new IdGenerator();
        }
        return generator;
    }

    public int getId(){
        return id++;
    }

}
