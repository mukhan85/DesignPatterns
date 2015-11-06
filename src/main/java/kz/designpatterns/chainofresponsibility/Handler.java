package kz.designpatterns.chainofresponsibility;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public interface Handler {
    void process(File requestFile);
    String getHandlerName();
    boolean canHandle(File requestedFile);
    void registerNextHandler(Handler nextHandler);
}
