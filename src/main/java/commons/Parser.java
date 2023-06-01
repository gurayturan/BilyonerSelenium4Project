package commons;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Parser {
    JSONParser parser = new JSONParser();
    private static String json="";
    private static String OS = System.getProperty("os.name").toLowerCase();


    public Parser()
    {
        setPath();
    }

    public Page getPageAttributes(String mypage) throws IOException, ParseException {
        Page returnPage = new Page();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(new FileReader(json+""+mypage+".json"));
            allureReport(StepResultType.PASS,"page json file is found("+mypage+".json)",false);
        } catch (IOException | ParseException e) {
            allureReport(StepResultType.FAIL,"page json file is not found("+mypage+".json)",false);
            e.printStackTrace();
        }

        JSONArray array = (JSONArray) object.get("pages");
        String value = null;
        String parentName = "";
        for (Object o : array) {
            JSONObject page = (JSONObject) o;

            JSONObject pageInfo = (JSONObject) page.get("pageInfo");
            String pagename = (String) pageInfo.get("pageName");
            if (pagename.equalsIgnoreCase(mypage)) {
                returnPage.setPageName((String) pageInfo.get("pageName"));
                returnPage.setParentName((String) pageInfo.get("parentName"));
                returnPage.setWaitElement((String) pageInfo.get("waitElement"));
                break;
            }
        }
        return returnPage;
    }

    public Boolean isPageExist(String mypage) {
        setPath();
        JSONObject object = null;
        try {
            System.out.println(json+""+mypage+".json");
            object = (JSONObject) parser.parse(new FileReader(json+""+mypage+".json"));
            allureReport(StepResultType.PASS,"page json file is found("+mypage+".json)",false);
        } catch (IOException | ParseException e) {
            allureReport(StepResultType.FAIL,"page json file is not found("+mypage+".json)",false);
            e.printStackTrace();
        }
        JSONArray array = (JSONArray) object.get("pages");

        for (Object o : array) {
            JSONObject page = (JSONObject) o;

            JSONObject pageInfo = (JSONObject) page.get("pageInfo");
            String pagename = (String) pageInfo.get("pageName");

            if (pagename.equalsIgnoreCase(mypage)) {
                System.out.println(pagename + " sayfası bulundu");
                return true;
            }
        }
        return false;
    }

    public Element getElement(String mypage, String myelement) {
        Element returnElement = new Element();
        JSONObject object = null;
        try {
            object = (JSONObject) parser.parse(new FileReader(json+""+mypage+".json"));
            allureReport(StepResultType.PASS,"page json file is found("+mypage+".json)",false);
        } catch (IOException | ParseException e) {
            allureReport(StepResultType.FAIL,"page json file is not found("+mypage+".json)",false);
            e.printStackTrace();
        }

        JSONArray array = (JSONArray) object.get("pages");
        String value = null;
        String parentName = "";
        for (Object o : array) {
            JSONObject page = (JSONObject) o;

            JSONObject pageInfo = (JSONObject) page.get("pageInfo");
            String pagename = (String) pageInfo.get("pageName");
            parentName = (String) pageInfo.get("parent");
            boolean elemFind = false;
            if (pagename.equalsIgnoreCase(mypage)) {
                JSONArray elements = (JSONArray) page.get("elements");
                for (Object element : elements) {
                    JSONObject elem = (JSONObject) element;
                    value = (String) elem.get("elementName");

                    if (value.equals(myelement)) {
                        returnElement.setElementName((String) elem.get("elementName"));
                        returnElement.setElementType((String) elem.get("elementType"));
                        returnElement.setElementValue((String) elem.get("elementValue"));
                        elemFind = true;
                        break;
                    }
                }

                //control parent
                if (elemFind == false) {
                    for (Object obj : array) {
                        JSONObject parentPage = (JSONObject) obj;
                        pageInfo = (JSONObject) parentPage.get("pageInfo");
                        pagename = (String) pageInfo.get("pageName");

                        if (pagename.equalsIgnoreCase(parentName)) {
                            JSONArray parenEelements = (JSONArray) parentPage.get("elements");
                            for (Object element : parenEelements) {
                                JSONObject elem = (JSONObject) element;
                                value = (String) elem.get("elementName");

                                if (value.equals(myelement)) {
                                    returnElement.setElementName((String) elem.get("elementName"));
                                    returnElement.setElementType((String) elem.get("elementType"));
                                    returnElement.setElementValue((String) elem.get("elementValue"));
                                    elemFind = true;
                                    break;
                                }
                            }
                            if (elemFind == true) {
                                break;
                            }
                        }
                    }
                }
            }
            if (elemFind == true) {
                break;
            }
        }

        return returnElement;
    }

    public void setPath() {
        System.out.println("os.name: " + OS);

        if (isWindows()) {
            System.out.println("This is Windows");
            json = Paths.get("").toAbsolutePath().toString() + "\\src\\test\\java\\pages\\";
        } else if (isMac()) {
            System.out.println("This is Mac");
            json = Paths.get("").toAbsolutePath().toString() + "/src/test/java/pages/";
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux");
            json = Paths.get("").toAbsolutePath().toString() + "/src/test/java/pages/";
        } else if (isSolaris()) {
            System.out.println("This is Solaris");
            json = Paths.get("").toAbsolutePath().toString() + "/src/test/java/pages/";
        } else {
            System.out.println("Your OS is not support!!");
        }
    }

    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0
                || OS.indexOf("nux") >= 0
                || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }

    public void allureReport(StepResultType result, String message, boolean ssFlag) {
        try {
            System.out.println(message);

            if (result.toString().equalsIgnoreCase("PASS")) {
                Allure.step(message, Status.PASSED);
            } else if (result.toString().equalsIgnoreCase("INFO")) {
                Allure.step(message, Status.SKIPPED);
            } else if (result.toString().equalsIgnoreCase("FAIL")) {
                Allure.step(message, Status.FAILED);
                Assert.fail(message);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
