/**
 * Created by Виктор on 04.11.2014.
 */

package entities;

import java.util.Calendar;

public class Price {
    private Integer id;
    private Integer idCity;
    private Integer idMedicament;
    private Integer amount;
    private Double cost;
    private Calendar dateUpdate;
    private Pharmacy pharmacy;
    private String pharmacyName;

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public Integer getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Calendar getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Calendar dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
