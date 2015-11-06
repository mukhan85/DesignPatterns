package kz.designpatterns.chainofresponsibility;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public abstract class AbstractHandler implements Handler {
    private final String handlerName;
    protected Handler nextChainHandler;

    public AbstractHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    public String getHandlerName() {
        return this.handlerName;
    }

    public void registerNextHandler(Handler nextChainHandler) {
        this.nextChainHandler = nextChainHandler;
    }

    protected void passToNextHandler(File requestFile) {
        if(nextChainHandler != null) {
            nextChainHandler.process(requestFile);
        } else {
            System.out.println("Does not have next handler. End of chain...");
        }
    }
}
