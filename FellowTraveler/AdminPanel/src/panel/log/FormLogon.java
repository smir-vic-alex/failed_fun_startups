package panel.log;

import org.apache.struts.action.ActionForm;

/**
 * Created by Денис on 29.04.14.
 */
public class FormLogon extends ActionForm {
    private String name;
    private String password;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
