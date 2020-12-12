/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: Интерфейс для просмотра сущности
 */
package workUnit;

public interface ViewWorkUnit<E> {

    public void init(Integer id);
    public E getEntity();
}
