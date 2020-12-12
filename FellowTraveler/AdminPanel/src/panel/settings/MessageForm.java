package panel.settings;

import org.apache.struts.action.ActionForm;

/**
 * Created by Денис on 03.05.14.
 * Форма предназначена для передачи сообшений о выполнении каких-либо действий в настройках
 */
public class MessageForm extends ActionForm {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = this.message + " " +message + "\n";
    }
}
