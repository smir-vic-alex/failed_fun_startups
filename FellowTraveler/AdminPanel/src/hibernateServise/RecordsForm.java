package hibernateServise;

import org.apache.struts.action.ActionForm;
import java.util.List;

/**
 * Created by Денис on 02.05.14.
 * Форма предназначена для передачи данных о пользователях из БД
 */
public class RecordsForm extends ActionForm {
    private User user;
    private List<User> users;

//    Нужно убрать эти поля !

    private Integer id;
    private String startpoint;
    private String finishpoint;
    private String intermediatepoints;
    private Integer day;
    private Integer month;
    private String vkId;
    private String information;
    private String agree;
    private int who;

    public int getWho() {
        return who;
    }

    public void setWho(int who) {
        this.who = who;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getFinishpoint() {
        return finishpoint;
    }

    public void setFinishpoint(String finishpoint) {
        this.finishpoint = finishpoint;
    }

    public String getIntermediatepoints() {
        return intermediatepoints;
    }

    public void setIntermediatepoints(String intermediatepoints) {
        this.intermediatepoints = intermediatepoints;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getVkId() {
        return vkId;
    }

    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }
}