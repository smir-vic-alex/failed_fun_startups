package form;

/**
 * Created by Виктор on 09.11.2014.
 */

/**
 * Класс данных, которые будут обновляться
 */
public class UpdateRecord {

    private String name;
    private Integer amount;
    private Double cost;

    /**
     *
     * @return название лекарства
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name название лекартсва
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return количество лекарства
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     *
     * @param amount количество лекарства
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     *
     * @return стоимость лекарства
     */
    public Double getCost() {
        return cost;
    }

    /**
     *
     * @param cost стоимость лекарства
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }
}
