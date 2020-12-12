/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Сущность, описывающая администраторов
 */
package entities;

public class StuffUser {
    private Integer id;
    private String firstName;
    private String secondName;
    private String fatherName;
    private String login;
    private String password;
    private RightAccess right;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RightAccess getRight() {
        return right;
    }

    public void setRight(RightAccess right) {
        this.right = right;
    }
}
