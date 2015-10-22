package kz.designpatterns.composite;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created on 22/10/2015.
 */
public abstract class HtmlTag {

    private final String tagName;
    private String startTag;
    private String endTag;
    private String tagBody;

    public HtmlTag(String tagName) {
        this.tagName = tagName;
    }

    public abstract String generateHtml();

    public void setStartTag(String startTag) {
        this.startTag = startTag;
    }

    public void setEndTag(String endTag) {
        this.endTag = endTag;
    }

    public abstract void addChildTag(HtmlTag childTag);
    public abstract void removeChild(HtmlTag childTag);

    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getStartTag() {
        return startTag;
    }

    public String getEndTag() {
        return endTag;
    }

    public String getTagBody() {
        if(StringUtils.isEmpty(this.tagBody)) {
            return "\n";
        }
        return tagBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HtmlTag htmlTag = (HtmlTag) o;
        return new EqualsBuilder()
                .append(tagName, htmlTag.tagName)
                .append(startTag, htmlTag.startTag)
                .append(endTag, htmlTag.endTag)
                .append(tagBody, htmlTag.tagBody)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(tagName)
                .append(startTag)
                .append(endTag)
                .append(tagBody)
                .toHashCode();
    }

    public abstract boolean isParent();
}
