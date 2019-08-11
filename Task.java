import java.util.Vector;

public interface Task extends Runnable {
    /**
     * this interface is made for doing tasks on our calls vector.
     *
     */
    void doTask();
    void run();

}
