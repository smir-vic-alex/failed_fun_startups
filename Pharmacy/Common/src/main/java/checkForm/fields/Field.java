/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Интерфейс для полей с формы
 */
package checkForm.fields;

import checkForm.parsers.FieldParser;
import checkForm.validators.Validator;

import java.util.List;

public interface Field {

    /**
     * Установление валидатора.
     * @param validator Валидатор
     */
    public void setValidator(Validator validator);

    /**
     * Установение валидаторов.
     * @param validators Валидаторы
     */
    public void setValidators(Validator... validators);

    /**
     * Получение валидаторов.
     * @return Список валидаторов
     */
    public List<Validator> getValidators();

    /**
     * Установление парсера.
     * @param parser Парсер
     */
    public void setParser(FieldParser parser);

    /**
     * Получение парсера
     * @return Парсер
     */
    public FieldParser getParser();

    /**
     * Установление имени поля.
     * @param name Имя поля, соответствующее имени на форме.
     */
    public void setName(String name);

    /**
     * Получение имени.
     * @return Имя формы
     */
    public String getName();

    /**
     * Установление описания
     * @param description Описание поля
     */
    public void setDescription(String description);

    /**
     * Получение описания.
     * @return Описание
     */
    public String getDescription();

    /**
     * Маркировка поля, что оно является не обязательным
     */
    public void setNotRequired();

    /**
     * Проверка, является ли поле обязательным
     * @return Да, если поле обязательное. Нет, в противном случае.
     */
    public boolean isRequire();
}
