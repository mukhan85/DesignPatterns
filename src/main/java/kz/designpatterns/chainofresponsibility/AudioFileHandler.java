package kz.designpatterns.chainofresponsibility;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public class AudioFileHandler extends AbstractHandler {
    private final static String HANDLES_FILE_TYPE = "mp3";

    public AudioFileHandler(String handlerName, Handler previousHandler) {
        super(handlerName);
        previousHandler.registerNextHandler(this);
    }

    public void process(File requestFile) {
        if(canHandle(requestFile)) {
            System.out.println(getHandlerName() + " persisted file " + requestFile.getFileName());
            requestFile.setHandler(this);
        } else {
            passToNextHandler(requestFile);
        }
    }

    public boolean canHandle(File requestedFile) {
        return HANDLES_FILE_TYPE.equals(requestedFile.getFileType());
    }
}
