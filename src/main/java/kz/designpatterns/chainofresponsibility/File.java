package kz.designpatterns.chainofresponsibility;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public class File {
    private final String fileName;
    private final String fileType;
    private Handler handler;

    public File(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
