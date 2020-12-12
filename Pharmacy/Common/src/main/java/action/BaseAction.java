/**
 * Создано: Денис 
 * Дата: 09.01.15
 * Описание: 
 */
package action;

import checkForm.Form;
import checkForm.FormHandler;
import forms.ActionFormBase;
import helpers.GlobalConstants;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import workUnit.DeleteWorkUnit;
import workUnit.EditWorkUnit;
import workUnit.ListWorkUnit;
import workUnit.ViewWorkUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseAction extends LogDispatchAction {

    /**
     * Получение сущности по ID
     */
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase) form;
        ViewWorkUnit view = createViewWorkUnit(frm);
        view.init(frm.getId());
        updateViewForm(frm, view);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase) form;
        FormHandler formHandler = new FormHandler(frm.getFields(), frm.getLogicForm());
        if (!formHandler.handler()) {
            request.setAttribute(GlobalConstants.ERROR_MESSAGE, formHandler.getErrorMessage());
            return mapping.findForward(ERROR);
        }
        EditWorkUnit workUnit = createEditWorkUnit(frm);
        workUnit.init(frm.getId());
        workUnit.updateEntity(formHandler.getResult());
        workUnit.addition(frm);
        workUnit.save();
        return mapping.findForward(SUCCESS);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase) form;
        DeleteWorkUnit delete = createDeleteWorkUnit(frm);
        delete.delete(frm.getId());
        return mapping.findForward(SUCCESS);
    }

    //TODO: Метод требует тестирования
    public ActionForward filter(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase) form;
        FormHandler formHandler = new FormHandler(frm.getFilters(), frm.getLogicForm());
        if (!formHandler.handler()) {
            request.setAttribute(GlobalConstants.ERROR_MESSAGE, formHandler.getErrorMessage());
            return mapping.findForward(ERROR);
        }
        ListWorkUnit list = createListWorkUnit(frm);
        list.setFilter(formHandler.getResult());
        list.filter();
        frm.setData(list.getResult());
        return filterForward(frm, list, mapping, request);
    }

    /**
     * Получения forward'а
     * @param form Форма
     * @param list Модуль список
     * @param mapping Маппинг
     * @param request Запрос
     * @return Forward на jsp
     */
    protected ActionForward filterForward(ActionFormBase form, ListWorkUnit list, ActionMapping mapping, HttpServletRequest request){
        return mapping.findForward(SUCCESS);
    }

    /**
     * Создание модуля для просмотра сущности
     *
     * @param form Форма
     * @return Модуль просмотра сущности
     */
    protected abstract ViewWorkUnit createViewWorkUnit(ActionFormBase form);

    /**
     * Обновление формы данными с модуля
     *
     * @param form Форма
     * @param view Модуль
     */
    protected abstract void updateViewForm(ActionFormBase form, ViewWorkUnit view);

    /**
     * Создание модуля для редактирования сущности
     *
     * @param frm Форма
     * @return Модуль для редактирования
     */
    protected EditWorkUnit createEditWorkUnit(ActionFormBase frm) {
        throw new UnsupportedOperationException();
    }

    /**
     * Создание модуля для удаления сущности
     *
     * @param frm Форма
     * @return Модуль для удаления
     */
    protected DeleteWorkUnit createDeleteWorkUnit(ActionFormBase frm) {
        throw new UnsupportedOperationException();
    }

    /**
     * Создание модуля для просмотра списка сущностей
     *
     * @param frm Форма
     * @return Модуль для просмотра списка сущностей
     */
    protected ListWorkUnit createListWorkUnit(ActionFormBase frm) {
        throw new UnsupportedOperationException();
    }
}
