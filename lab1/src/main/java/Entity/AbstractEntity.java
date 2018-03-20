package Entity;

public abstract class AbstractEntity<K>{
    K id;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }
}
