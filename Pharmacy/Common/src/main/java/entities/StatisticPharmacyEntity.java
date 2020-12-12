/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package entities;

import java.util.Calendar;

public class StatisticPharmacyEntity {
    private Integer id;
    private Integer idPharmacy;
    private Calendar day;
    private Integer countVisit;

    public Integer getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(Integer idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public Calendar getDay() {
        return day;
    }

    public void setDay(Calendar day) {
        this.day = day;
    }

    public Integer getCountVisit() {
        return countVisit;
    }

    public void setCountVisit(Integer countVisit) {
        this.countVisit = countVisit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
