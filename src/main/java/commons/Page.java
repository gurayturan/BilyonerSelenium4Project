package commons;

public class Page {
    private String WaitElement;
    private String ParentName;
    private String PageName;


    public Page() {
    }

    public String getWaitElement() {
        return WaitElement;
    }

    public void setWaitElement(String waitElemet) {
        WaitElement = waitElemet;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }
}
