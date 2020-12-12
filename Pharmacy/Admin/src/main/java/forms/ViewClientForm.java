/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package forms;

import entities.UserAccount;

public class ViewClientForm extends ActionFormBase {
    private UserAccount client;

    public UserAccount getClient() {
        return client;
    }

    public void setClient(UserAccount user) {
        this.client = user;
    }
}
