package kz.designpatterns.facade;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created on 21/10/2015.
 */
public class FacadePatternTest {
    @Test
    public void shouldStartServer() {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade facadeServer = new ScheduleServerFacade(scheduleServer);
        facadeServer.startServer();
        assertThat(scheduleServer.isRunning(), is(true));
    }

    @Test
    public void shouldStopServer() {
        ScheduleServer scheduleServer = new ScheduleServer();
        ScheduleServerFacade facadeServer = new ScheduleServerFacade(scheduleServer);
        facadeServer.stopServer();
        assertThat(scheduleServer.isRunning(), is(false));
    }
}
