/**
 * Created by Виктор on 03.11.2014.
 */

package action;

import fileService.FileManager;
import form.LoadedData;
import form.FileUploadForm;
import entities.Pharmacy;
import helpers.SessionAndRequestHelper;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import queueService.QueueManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadAction extends LogDispatchAction {

    private static final String IS_NOT_MULTIPART_CONTENT = "isNotMultipartContent";

    /**
     * Загрузка прайса аптеки
     */
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        FileUploadForm fileUploadForm = (FileUploadForm) form;
        LoadedData loadedData = new LoadedData();
        // если нам пришел реквест с файлом
        if (ServletFileUpload.isMultipartContent(request)) {
            Pharmacy pharmacy = SessionAndRequestHelper.getPharmacy(request);
            String pathToFile = getPathToFile(pharmacy, form);
            loadedData.setPathToFile(pathToFile);
            loadedData.setPharmacy(pharmacy);
            loadedData.setEncoding(new FileManager(loadedData.getPathToFile()).getEncodingFile());
            QueueManager.getQueue().add(loadedData);
            ((FormFile) fileUploadForm.getMultipartRequestHandler().getFileElements().get("upfile")).destroy();
            return mapping.findForward(SUCCESS);

        }
        //TODO: Нужно иначе разруливать "плохие" ситуации
        return mapping.findForward(IS_NOT_MULTIPART_CONTENT);
    }

    /**
     * Получение пути к загруженному файлу
     * @param pharmacy Аптека, которая загрузила файл
     * @param form Форма с файлом
     * @return Путь к файлу
     */
    private String getPathToFile(Pharmacy pharmacy, ActionForm form){
        FormFile file = (FormFile) form.getMultipartRequestHandler().getFileElements().get("upfile");
        String filePath = getServlet().getServletContext().getRealPath("/") + pharmacy.getLogin();
        return new FileManager(filePath).loadFile(file, pharmacy.getId().toString()).getAbsolutePath();
    }
}
