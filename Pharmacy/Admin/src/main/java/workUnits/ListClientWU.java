/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package workUnits;

import entities.UserAccount;
import hibernateService.HibernateService;
import workUnit.ListWorkUnit;

import java.util.List;
import java.util.Map;

public class ListClientWU implements ListWorkUnit<UserAccount> {

    private HibernateService<UserAccount> service = new HibernateService<UserAccount>(UserAccount.class);
    private List<UserAccount> listUser;
    @Override
    public void setFilter(Map<Object, Object> filterParam) {

    }

    @Override
    public void filter() {
        listUser = service.getAll();
    }

    @Override
    public List<UserAccount> getResult() {
        return listUser;
    }
}
