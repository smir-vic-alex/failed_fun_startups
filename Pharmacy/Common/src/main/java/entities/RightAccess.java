/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Класс описывает права доступа
 */

package entities;

public enum RightAccess {

    SUPER_ADMIN("Супер администратор"),
    ADMIN("Администратор");

    private String status;

    RightAccess(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
