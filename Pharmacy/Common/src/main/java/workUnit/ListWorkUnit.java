/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: Модуль для просмотра списка сущностей
 */
package workUnit;

import java.util.List;
import java.util.Map;

public interface ListWorkUnit<E> {
    /**
     * Кстановка значений фильтра
     * @param filterParam Параметря фильтрации
     */
    public void setFilter(Map<Object, Object> filterParam);

    /**
     * Применение фильтра для получения нужных данных
     */
    public void filter();

    /**
     * Получение результата обработки
     * @return Список сущностей
     */
    public List<E> getResult();
}
