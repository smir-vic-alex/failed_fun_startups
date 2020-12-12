/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package workUnits;

import entities.City;
import entities.Pharmacy;
import forms.ActionFormBase;
import helpers.PasswordHelper;
import hibernateService.HibernateService;
import workUnit.EditWorkUnit;

import java.util.Map;

public class EditPharmacyWU implements EditWorkUnit{

    private Pharmacy pharmacy;
    private HibernateService<Pharmacy> service = new HibernateService<Pharmacy>(Pharmacy.class);

    public void init(Integer id){
        if(id != null && id != 0){
            pharmacy = service.getById(id);
            if (pharmacy == null){
                throw new IllegalArgumentException("Недопустимый id: " + id);
            }
        }else {
            pharmacy = new Pharmacy();
        }
    }

    @Override
    public void updateEntity(Map<String, Object> values) throws Exception{
        pharmacy.setName((String)values.get("name"));
        pharmacy.setAddress((String) values.get("address"));
        pharmacy.setPhone((String) values.get("phone"));
        pharmacy.setCity((City) values.get("city"));
        pharmacy.setWorkTime((String) values.get("workTime"));
        pharmacy.setCoordinates((String) values.get("coordinates"));
        if (pharmacy.getCodeNetwork() == null){
            pharmacy.setCodeNetwork((Integer) values.get("codeNetwork"));
        }
        String login = (String) values.get("login");
        if (login != null){
            pharmacy.setLogin(login);
        }
        String password = (String) values.get("password1");
        if (password != null){
            pharmacy.setPassword(PasswordHelper.encrypt(password));
        }
        Boolean needFakePrice = (Boolean)values.get("fakePrice");
        needFakePrice = needFakePrice == null ? Boolean.FALSE : needFakePrice;
        pharmacy.setFakePrice(needFakePrice);
    }

    @Override
    public void save() {
        service.saveOrUpdate(pharmacy);
    }

    @Override
    public void addition(ActionFormBase form) {

    }
}
