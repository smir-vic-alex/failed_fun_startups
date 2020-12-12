package queueService;

/**
 * Created by Виктор on 08.11.2014.
 */
public class QueueManager {

    private static Queue<Object> queue = new Queue<>();

    public static Queue<Object> getQueue() {
        return queue;
    }

}
