package kz.designpatterns.facade;

/**
 * Created on 21/10/2015.
 */
public class ScheduleServer {


    private boolean isRunning;

    public boolean isRunning() {
        return isRunning;
    }

    public void startBooting() {
        System.out.println("Start Booting.");
    }

    public void readSystemConfigFile() {
        System.out.println("Read system fiels.");
    }

    public void init() {
        System.out.println("Init");
    }

    public void initializeContext() {
        System.out.println("Init Context");
    }

    public void initializeListeners() {
        System.out.println("Init Listeners");
    }

    public void createSystemObjects() {
        System.out.println("Create system objects");
        this.isRunning = true;
    }

    public void releaseProcesses() {
        System.out.println("Release Processes");
    }

    public void destory() {
        System.out.println("Destroy!!!");
    }

    public void destroySystemObjects() {
        System.out.println("DestroySystemObjects");
    }

    public void destoryListeners() {
        System.out.println("Destroy Listeners");
    }

    public void destoryContext() {
        System.out.println("Destroy Context");
    }

    public void shutdown() {
        isRunning = false;
    }
}