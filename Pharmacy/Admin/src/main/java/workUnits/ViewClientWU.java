/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package workUnits;

import entities.UserAccount;
import hibernateService.HibernateService;
import workUnit.ViewWorkUnit;

public class ViewClientWU implements ViewWorkUnit {

    private HibernateService<UserAccount> service = new HibernateService<UserAccount>(UserAccount.class);
    private UserAccount user;

    @Override
    public void init(Integer id) {
        if (id != null && id > 0){
            user = service.getById(id);
            if  (user == null){
                throw new IllegalArgumentException("Недопустимый ID = " + id);
            }
        }else {
            throw new IllegalArgumentException("Недопустимый ID = " + id);
        }
    }

    @Override
    public Object getEntity() {
        return user;
    }
}
