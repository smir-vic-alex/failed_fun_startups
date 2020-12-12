/**
 * Создано: Денис
 * Дата: 03.11.14.
 * Описание: Базовый класс для всех форм
 */
package forms;

import checkForm.Form;
import checkForm.FormImp;
import org.apache.struts.action.ActionForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionFormBase extends ActionForm {
    private Integer id;
    private List<Object> data;
    private Map<Object, Object> fields = new HashMap<Object, Object>();
    private Map<Object, Object> filters = new HashMap<Object, Object>();

    public List<Object> getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Map<Object, Object> getFields() {
        return fields;
    }

    public void setFields(Map<Object, Object> map){
        fields = map;
    }

    public String getLength(){
        if (data != null){
            return Integer.toString(data.size());
        }
        return "0";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setField(String key, Object value){
        fields.put(key, value);
    }

    public Map<Object, Object> getFilters() {
        return filters;
    }

    public void setFilters(Map<Object, Object> filters) {
        this.filters = filters;
    }

    public Form getLogicForm(){
        return new FormImp();
    }
}
