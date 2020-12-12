package queueService;
/**
 * Created by Виктор on 07.11.2014.
 */
import java.util.LinkedList;

/**
 * Реализация очереди с помощью LinkedList
 * @param <T> тип данных
 */
public class Queue<T>{

    private LinkedList<T> list = new LinkedList<T>();
    private boolean blockAdd = false;

    /**
     * проверка на возможность добавеления элемента в очередь
     * @return
     */
    public boolean isBlockingAdd() {
        return blockAdd;
    }

    /**
     * true-запретить/ false-разрешить добавление в очередь
     * @param blockAdd
     */
    public void setBlockingAdd(boolean blockAdd) {
        this.blockAdd = blockAdd;
    }

    /**
     * синхронизированное добаление в очередь
     * @param v добавляемое значение
     */
    public synchronized void add(T v){
        if(!blockAdd) {
            list.addLast(v);
        }
    }

    /**
     * достать данные с удалением их из очереди
     * @return
     */
    public T poll(){
        return list.poll();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return list.isEmpty();
    }

    /**
     *
     * @return
     */
    public int size(){
        return list.size();
    }

    /**
     *
     * @param object
     * @return
     */
    public boolean contains(Object object){
        return list.contains(object);
    }

}
