package kz.designpatterns.chainofresponsibility;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mmyrzaku on 06/11/2015.
 */
public class ChainOfResponsibilityTest {

    Handler rootHandler;
    Handler textFileHandler;
    Handler audioHandler;

    @Before
    public void setUp() throws Exception {
        rootHandler = new RootHandler("RootHandler");
        textFileHandler = new TextFileHandler("TextFile Handler", rootHandler);
        audioHandler = new AudioFileHandler("AudioHandler", textFileHandler);
    }

    @Test
    public void shouldHandleTextFile() {
        File textFile = new File("TextFile", "txt");
        assertThat("should be handled by textFileHandler.", textFileHandler.canHandle(textFile), is(true));
    }

    @Test
    public void shouldNotHandleNonTextFile() {
        File nonTextFile = new File("NonTextFile", "jpg");
        assertThat("Should not handle non Text files", textFileHandler.canHandle(nonTextFile), is(false));
    }

    @Test
    public void shouldPassReqeustToAudioHandler() {
        File audioFile = new File("Audio", "mp3");
        rootHandler.process(audioFile);
        assertThat("Should have been handled by Audio handler", audioFile.getHandler(), is(audioHandler));
    }
}