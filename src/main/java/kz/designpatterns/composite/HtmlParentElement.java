package kz.designpatterns.composite;

import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 22/10/2015.
 */
public class HtmlParentElement extends HtmlTag {

    private List<HtmlTag> childrenTag = new ArrayList<HtmlTag>();

    public HtmlParentElement(String tagName) {
        super(tagName);
    }

    @Override
    public void addChildTag(HtmlTag childTag) {
        this.childrenTag.add(childTag);
    }

    @Override
    public void removeChild(HtmlTag tagToRemove) {
        Validate.notNull(tagToRemove);

        Iterator<HtmlTag> it = this.childrenTag.iterator();
        while(it.hasNext()) {
            HtmlTag childTag = it.next();

            if(childTag.equals(tagToRemove)) {
                it.remove();
            } else if(childTag.isParent()){
                childTag.removeChild(tagToRemove);
            }
        }
    }

    @Override
    public boolean isParent() {
        return true;
    }

    @Override
    public String generateHtml() {
        StringBuilder sb = new StringBuilder();

        sb.append(getStartTag() + getTagBody());

        for(HtmlTag eachChildTag : this.childrenTag) {
            sb.append(eachChildTag.generateHtml());
        }
        sb.append(getEndTag());

        return sb.toString();
    }
}
