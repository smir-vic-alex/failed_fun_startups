/**
 * Создано: Виктор
 * Дата: 09.11.2014
 */
package fileService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Scanner;

public class FileManager {

    protected final Logger LOG = LogManager.getLogger(FileManager.class);
    private static final String FILE_PREFIX = "Pharmacy";
    private Scanner scanner;
    private String pathFile;

    /**
     * Сканер файла
     *
     * @return
     */
    public Scanner getScanner() {
        try {
            scanner = new Scanner(new FileReader(pathFile));
        } catch (IOException e) {
            LOG.error("Ошибка сканнера");
            throw new Error(e);
        }
        return scanner;
    }

    /**
     * @param pathFile - путь до файла
     */
    public FileManager(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * @param formFile - файл, который загрузили
     * @return файл в который скопировали данные
     */
    //TODO: Если с загрузкой файла произошла ошибка, то пробросить её наверх
    public File loadFile(FormFile formFile, String name) {

        createFolder();
        File newFile = new File(pathFile, FILE_PREFIX + name);
        try (FileOutputStream outputStream = new FileOutputStream(newFile)) {
            outputStream.write(formFile.getFileData());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            LOG.error("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            LOG.error("Ошибка при копировании файла");
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * Создаёт папку
     *
     * @return true - создана новая папка , false - папка с таким названием уже существует
     */
    public boolean createFolder() {

        File folder = new File(pathFile);
        if (!folder.exists()) {
            if (Files.isRegularFile(folder.toPath())) {
                try {
                    Files.delete(folder.toPath());
                } catch (IOException e) {
                    LOG.error("Ошибка при создании папки");
                    e.printStackTrace();
                }
            }
            return folder.mkdir();
        }
        return false;
    }

    /**
     * Определение кодировки файла
     * @return строка с названием кодировки, null если кодировка не определена
     */
    public String getEncodingFile() {

        byte[] buf = new byte[4096];
        UniversalDetector detector = new UniversalDetector(null);
        try {
            FileInputStream fis = new FileInputStream(pathFile);
            int nRead;
            while ((nRead = fis.read(buf))  > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, nRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        if (encoding != null) {
            LOG.info("Определена кодировка " + encoding + " для " + pathFile);
        } else {
            LOG.error("Не определена кодировка для файла " + pathFile );
        }
        detector.reset();

        return encoding;
    }

}
