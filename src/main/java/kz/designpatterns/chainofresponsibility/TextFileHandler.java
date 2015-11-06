package kz.designpatterns.chainofresponsibility;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public class TextFileHandler extends AbstractHandler {
    private final static String HANDLE_FILE_TYPE = "txt";

    public TextFileHandler(String handlerName) {
        super(handlerName);
    }

    public TextFileHandler(String handlerName, Handler previousHandler) {
        this(handlerName);
        previousHandler.registerNextHandler(this);
    }

    public void process(File requestFile) {
        if(canHandle(requestFile)) {
            System.out.println(getHandlerName() + " saved file: " + requestFile.getFileName());
            requestFile.setHandler(this);
        } else {
            passToNextHandler(requestFile);
        }
    }

    public boolean canHandle(File requestedFile) {
        return HANDLE_FILE_TYPE.equals(requestedFile.getFileType());
    }
}