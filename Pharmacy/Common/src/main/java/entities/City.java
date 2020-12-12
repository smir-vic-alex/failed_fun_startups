/**
 * Создано: Денис
 * Дата: 09.11.14.
 * Описание: Класс описывает сущность город
 */
package entities;

public class City {
    private String name;
    private Integer id;
    private String coordinates; //Координаты города на карте

    public City() {
    }

    public City(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }
}
