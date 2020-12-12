/**
 * Created by Виктор on 04.11.2014.
 */

package entities;

public class Pharmacy{
    private Integer id;
    private String address;
    private String name;
    private String phone;
    private City city;
    private String login;
    private String password;
    private Integer codeNetwork;
    private String coordinates;
    private String workTime;
    private Boolean fakePrice; // Флаг отвечает за показ "шума" в прайсе

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCodeNetwork() {
        return codeNetwork;
    }

    public void setCodeNetwork(Integer codeNetwork) {
        this.codeNetwork = codeNetwork;
    }

    public Boolean getFakePrice() {
        return fakePrice;
    }

    public void setFakePrice(Boolean fakePrice) {
        this.fakePrice = fakePrice;
    }
}
