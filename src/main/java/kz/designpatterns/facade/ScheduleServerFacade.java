package kz.designpatterns.facade;

/**
 * Created on 21/10/2015.
 */
public class ScheduleServerFacade {
    private final ScheduleServer scheduleServer;

    public ScheduleServerFacade(ScheduleServer scheduleServer) {
        this.scheduleServer = scheduleServer;
    }

    public void startServer(){
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
    }

    public void stopServer(){
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
