/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: Класс, описывающий сущность для сбора статистики по аптекам.
 */
package entities;

import java.util.Calendar;

public class StatisticMedicamentEntity {
    private Integer id;
    private Integer medicamentId;
    private Integer countRequest;
    private Calendar day;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(Integer medicamentId) {
        this.medicamentId = medicamentId;
    }

    public Integer getCountRequest() {
        return countRequest;
    }

    public void setCountRequest(Integer countRequest) {
        this.countRequest = countRequest;
    }

    public Calendar getDay() {
        return day;
    }

    public void setDay(Calendar day) {
        this.day = day;
    }
}
