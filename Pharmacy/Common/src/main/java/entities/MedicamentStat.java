/**
 * Создано: Денис 
 * Дата: 05.04.15
 * Описание: Класс для описания статистики по лекарству.
 */
package entities;

public class MedicamentStat {
    private String name;
    private Integer countRequest;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountRequest() {
        return countRequest;
    }

    public void setCountRequest(Integer countRequest) {
        this.countRequest = countRequest;
    }
}
