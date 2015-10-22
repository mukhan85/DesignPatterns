package kz.designpatterns.composite;

/**
 * Created on 22/10/2015.
 */
public class HtmlElement extends HtmlTag {

    public HtmlElement(String tagName) {
        super(tagName);
    }

    @Override
    public void addChildTag(HtmlTag paragraphTag) {
        throw new UnsupportedOperationException(getTagName() + " cannot have children elements.");
    }

    @Override
    public void removeChild(HtmlTag childTag) {
        throw new UnsupportedOperationException(getTagName() + " cannot remove children.");
    }

    @Override
    public boolean isParent() {
        return false;
    }

    @Override
    public String generateHtml() {
        return getStartTag() + getTagBody() + getEndTag() + "\n";
    }
}
