/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package workUnits;

import entities.UserAccount;
import forms.ActionFormBase;
import helpers.PasswordHelper;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import workUnit.EditWorkUnit;

import java.util.List;
import java.util.Map;

public class EditClientWU implements EditWorkUnit {
    private UserAccount userAccount;
    private HibernateService<UserAccount> service = new HibernateService<UserAccount>(UserAccount.class);

    @Override
    public void init(Integer id) {
        if(id != null && id != 0){
            userAccount = service.getById(id);
            if (userAccount == null){
                throw new IllegalArgumentException("Недопустимый id: " + id);
            }
        }else {
            userAccount = new UserAccount();
        }
    }

    @Override
    public void updateEntity(Map<String, Object> values)throws Exception {
        userAccount.setFirstName((String) values.get("firstName"));
        userAccount.setSecondName((String) values.get("secondName"));
        userAccount.setFatherName((String) values.get("fatherName"));
        userAccount.setPhone((String) values.get("phone"));
        userAccount.setEmail((String) values.get("email"));
        userAccount.setLogin((String) values.get("login"));
        String password = (String)values.get("password1");
        if (password != null){
            userAccount.setPassword(PasswordHelper.encrypt(password));
        }
        if (userAccount.getCodeNetwork() == null){
            List list = service.execute(new GenerallyHibernateQuery() {
                @Override
                public List run(Session session) throws HibernateException {
                          Query query = session.createSQLQuery("select S_CODE_NETWORK.nextval as num from dual")
                                    .addScalar("num", StandardBasicTypes.INTEGER);
                    return query.list();
                }
            });
            Integer codeNetwork = (Integer) list.get(0);
            userAccount.setCodeNetwork(codeNetwork);
        }

    }

    @Override
    public void addition(ActionFormBase form) {

    }

    @Override
    public void save() {
        service.saveOrUpdate(userAccount);
    }
}
