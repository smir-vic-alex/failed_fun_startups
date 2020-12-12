package panel.records;

import org.apache.struts.action.ActionForm;
import hibernateServise.User;

import java.util.List;

/**
 * Created by Денис on 02.05.14.
 * Форма предназначена для передачи данных о пользователях из БД
 */
public class RecordsForm extends ActionForm {
    private User user;
    private List<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
