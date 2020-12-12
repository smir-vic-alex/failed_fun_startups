/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package workUnit;

import forms.ActionFormBase;

import java.util.Map;

public interface EditWorkUnit {
    /**
     * Инициализация сущности по id.
     * @param id Ид сущности
     */
    public void init(Integer id);

    /**
     * Обновление данных сущности
     * @param values Новые данные
     */
    public void updateEntity(Map<String, Object> values) throws Exception;

    /**
     * Дополнительные действия
     * @param form Форма запроса
     */
    public void addition(ActionFormBase form);
    /**
     * Сохранение сущности
     */
    public void save();
}
