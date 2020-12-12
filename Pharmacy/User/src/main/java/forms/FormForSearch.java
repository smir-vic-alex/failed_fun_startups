package forms;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;

/**
 * Created by Виктор on 21.11.2014.
 */
public class FormForSearch extends ActionForm {
    private Integer idCity;
    private String form;

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}