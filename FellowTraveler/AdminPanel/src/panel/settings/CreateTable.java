package panel.settings;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.BaseAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.Driver;

/**
 * Created by Денис on 03.05.14.
 * Класс разворачивает новую таблицу для хранения маршрутов
 */
public class CreateTable extends BaseAction{

    private static final String URL = "jdbc:mysql://localhost:3306/togetherinway";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String FORWARD_SETTINGS = "settings";

    /**
     * Метод отправляет запрос на создание таблицы
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        MessageForm messageForm = (MessageForm) form;

        Driver driver = new com.mysql.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Connection connection = null;
        ResultSet cursor = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            cursor = connection.createStatement().executeQuery("SHOW DATABASES LIKE 'togetherinway'");
            if (cursor != null && cursor.next()){
                messageForm.setMessage("База togetherinway уже существует");
            }else {
                String send = "CREATE DATABASE `togetherinway`\n" +
                        "\tDEFAULT CHARACTER SET utf8\n" +
                        "\tDEFAULT COLLATE utf8_general_ci";
                connection.createStatement().execute(send);
                messageForm.setMessage("База togetherinway создана успешно");
            }
            cursor = connection.createStatement().executeQuery("SHOW TABLES LIKE 'ways'");
            if (cursor != null && cursor.next()){
                messageForm.setMessage("Таблица ways уже существует");
            }else {
                String send = "CREATE TABLE `ways`  (\n" +
                        "\t`id`                \tint(11) NOT NULL,\n" +
                        "\t`startpoint`        \tvarchar(50) NOT NULL,\n" +
                        "\t`finishpoint`       \tvarchar(50) NOT NULL,\n" +
                        "\t`intermediatepoints`\tvarchar(100) NOT NULL,\n" +
                        "\t`day`               \tint(11) NOT NULL,\n" +
                        "\t`month`             \tint(11) NOT NULL,\n" +
                        "\t`vkid`              \tvarchar(50) NOT NULL,\n" +
                        "\t`information`       \tvarchar(300) NULL,\n" +
                        "\t`who`                \tint(11) NOT NULL,\n" +
                        "\tPRIMARY KEY(`id`)\n" +
                        ")\n" +
                        "AUTO_INCREMENT = 0";
                connection.createStatement().execute(send);
                messageForm.setMessage("Таблица ways создана успешно");
            }
        }catch (SQLException e){
            messageForm.setMessage(e.getMessage());
        }
        finally {
            if (cursor != null)
            {
                cursor.close();
            }
            if (connection != null)
            {
                connection.close();
            }
        }
        return mapping.findForward(FORWARD_SETTINGS);
    }
}
