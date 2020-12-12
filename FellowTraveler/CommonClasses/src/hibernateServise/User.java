package hibernateServise;

import org.apache.struts.action.ActionForm;

import javax.persistence.Entity;

/**
 * Created by Денис on 03.05.2014.
 * Форма пользователя
 */

public class User extends ActionForm {
    private Integer id;
    private String startpoint;
    private String finishpoint;
    private String intermediatepoints;
    private Integer day;
    private Integer month;
    private String vkId;
    private String information;
    private String agree;
    private Integer who;
   
    public Integer getWho() {
        return who;
    }

    public void setWho(Integer who) {
        this.who = who;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return Откуда
     */
    public String getStartpoint() {
        return startpoint;
    }

    /**
     *
     * @param from Откуда
     */
    public void setStartpoint(String from) {
        this.startpoint = from;
    }

    /**
     *
     * @return Куда
     */
    public String getFinishpoint() {
        return finishpoint;
    }

    /**
     *
     * @param where Куда
     */
    public void setFinishpoint(String where) {
        this.finishpoint = where;
    }

    /**
     *
     * @return Почта
     */
    public String getIntermediatepoints() {
        return intermediatepoints;
    }

    /**
     *
     * @param mail Почта
     */
    public void setIntermediatepoints(String mail) {
        this.intermediatepoints = mail;
    }

    /**
     *
     * @return id Вконтакте
     */
    public String getVkId() {
        return vkId;
    }

    /**
     *
     * @param vkId id Вконтакте
     */
    public void setVkId(String vkId) {
        this.vkId = vkId;
    }

    /**
     *
     * @return Комментарий
     */
    public String getInformation() {
        return information;
    }

    /**
     *
     * @param comment Комментарий
     */
    public void setInformation(String comment) {
        this.information = comment;
    }
}
