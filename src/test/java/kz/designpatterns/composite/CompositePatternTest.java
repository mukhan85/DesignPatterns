package kz.designpatterns.composite;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

/**
 * Created on 22/10/2015.
 */

public class CompositePatternTest {
    @Test
    public void shouldPrintOutHtml() {

        HtmlTag topHtmlTag = buildTestTag();

        String htmlString = topHtmlTag.generateHtml();
        System.out.println(htmlString);
        assertFalse("Should have generated html String", htmlString.isEmpty());
    }

    @Test
    public void shouldRemoveChildTag() {
        HtmlTag htmlTag = buildTestTag();

        HtmlTag paragraphTag = new HtmlElement("Paragraph");
        paragraphTag.setStartTag("<p>");
        paragraphTag.setTagBody("This is the first paragraph!");
        paragraphTag.setEndTag("</p>");

        htmlTag.removeChild(paragraphTag);
        String html = htmlTag.generateHtml();

        assertFalse("Should not have paragaph2.", html.contains(paragraphTag.getTagBody()));
        System.out.println(html);
    }

    private HtmlTag buildTestTag() {
        HtmlTag topHtmlTag = new HtmlParentElement("html");
        topHtmlTag.setStartTag("<html>");
        topHtmlTag.setEndTag("</html>");

        HtmlTag bodyTag = new HtmlParentElement("body");
        bodyTag.setStartTag("<body>");
        bodyTag.setEndTag("</body>");

        topHtmlTag.addChildTag(bodyTag);

        HtmlTag paragraphTag = new HtmlElement("Paragraph");
        paragraphTag.setStartTag("<p>");
        paragraphTag.setTagBody("This is the first paragraph!");
        paragraphTag.setEndTag("</p>");

        bodyTag.addChildTag(paragraphTag);

        paragraphTag = new HtmlElement("Paragraph 2");
        paragraphTag.setStartTag("<p>");
        paragraphTag.setTagBody("Paragraph #2");
        paragraphTag.setEndTag("</p>");

        bodyTag.addChildTag(paragraphTag);
        return topHtmlTag;
    }

}
