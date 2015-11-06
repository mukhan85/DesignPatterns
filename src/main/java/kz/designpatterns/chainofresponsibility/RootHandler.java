package kz.designpatterns.chainofresponsibility;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public class RootHandler extends AbstractHandler {

    public RootHandler(String handlerHandler) {
        super(handlerHandler);
    }

    public void process(File requestFile) {
        System.out.println("Root Handler does not handle any requests.");
        nextChainHandler.process(requestFile);
    }

    public boolean canHandle(File requestedFile) {
        return false;
    }
}
