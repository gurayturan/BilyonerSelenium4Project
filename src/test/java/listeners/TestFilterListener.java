package listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class TestFilterListener implements IMethodInterceptor{

    private static Set<Pattern> patterns;

    private boolean includeTest(String testsToInclude, String currentTestName) {

        boolean result = false;

        if (patterns == null) {
            patterns = new HashSet<>();
            String[] testPatterns = testsToInclude.split(",");
            for (String testPattern : testPatterns) {

                patterns.add(Pattern.compile(testPattern, Pattern.CASE_INSENSITIVE));
            }
        }
            for (Pattern pattern : patterns) {
                if (pattern.matcher(currentTestName).find()) {
                    result = true;
                    break;
                }
            }
            return result;
        }


   @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        String testNames = System.getProperty("testname");
        System.out.println(testNames);
       System.out.println("context name:"+context.getName());

        if (testNames == null || testNames.trim().isEmpty()) {
            System.out.println(0);
            return methods;

        } else {

            if (includeTest(testNames, context.getName())) {
                System.out.println(methods);
                System.out.println(1);
                return methods;
            } else {
                System.out.println(2);
                return new ArrayList<IMethodInstance>();
            }
        }
    }
}
