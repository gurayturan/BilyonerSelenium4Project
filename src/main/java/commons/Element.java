package commons;

public class Element {

    private String ElementName;
    private ElementType ElementType;
    private String ElementValue;

    public Element() {

    }

    public void setElementType(String type) {
        switch (type) {
            case "id":
                this.ElementType = ElementType.id;
                break;
            case "name":
                this.ElementType = ElementType.name;
                break;
            case "className":
                this.ElementType = ElementType.className;
                break;
            case "xpath":
                this.ElementType = ElementType.xpath;
                break;
            case "cssSelector":
                this.ElementType = ElementType.cssSelector;
                break;
            case "linkText":
                this.ElementType = ElementType.linkText;
                break;
            case "partialLinkText":
                this.ElementType = ElementType.partialLinkText;
                break;
            case "tagName":
                this.ElementType = ElementType.tagName;
                break;
        }
    }

    public ElementType ElementType() {
        return ElementType;
    }

    public ElementType getElementType() {
        return ElementType;
    }

    public void setElementType(commons.ElementType elementType) {
        ElementType = elementType;
    }

    public String getElementName() {
        return ElementName;
    }

    public void setElementName(String elementName) {
        ElementName = elementName;
    }

    public String getElementValue() {
        return ElementValue;
    }

    public void setElementValue(String elementValue) {
        ElementValue = elementValue;
    }

}
