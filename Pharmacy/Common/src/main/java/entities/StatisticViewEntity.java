/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Класс предназначен для вывода краткой статистики по аптеке
 */
package entities;

public class StatisticViewEntity {
    private Pharmacy pharmacy;
    private Integer countVisitOverDay;      //Колличество просмотров за день
    private Integer countVisitOverWeek;     //Колличество просмотров за неделю
    private Integer countVisitOverMonth;    //Колличество просмотров за 30 дней

    public StatisticViewEntity(Pharmacy pharmacy, Integer countVisitOverDay, Integer countVisitOverWeek, Integer countVisitOverMonth) {
        this.pharmacy = pharmacy;
        this.countVisitOverDay = countVisitOverDay;
        this.countVisitOverWeek = countVisitOverWeek;
        this.countVisitOverMonth = countVisitOverMonth;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Integer getCountVisitOverDay() {
        return countVisitOverDay;
    }

    public void setCountVisitOverDay(Integer countVisitOverDay) {
        this.countVisitOverDay = countVisitOverDay;
    }

    public Integer getCountVisitOverWeek() {
        return countVisitOverWeek;
    }

    public void setCountVisitOverWeek(Integer countVisitOverWeek) {
        this.countVisitOverWeek = countVisitOverWeek;
    }

    public Integer getCountVisitOverMonth() {
        return countVisitOverMonth;
    }

    public void setCountVisitOverMonth(Integer countVisitOverMonth) {
        this.countVisitOverMonth = countVisitOverMonth;
    }
}
