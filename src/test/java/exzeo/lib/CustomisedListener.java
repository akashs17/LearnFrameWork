package exzeo.lib;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class CustomisedListener implements ITestListener,ISuiteListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String path=System.getProperty("JENKINS_URL")+ "\\target\\surefire-reports\\html\\ScreenShots\\" +result.getName() +".png";
		Reporter.log("<li>" + result.getName() + " : Passed</li>" );
		Reporter.log("<a href=\"" + path + "\"  target=\"_blank\">" + "<img src=\"" + path+ "\" height="+ "\"100\""  + " width=\"200\"" + "/><br></a>");

		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String path=System.getProperty("JENKINS_URL")+ "\\target\\surefire-reports\\html\\ScreenShots\\" +result.getName() +".png";
		Reporter.log("<li>" + result.getName() + " : Failed</li>" );
		Reporter.log("<a href=\"" + path + "\"  target=\"_blank\">" + "<img src=\"" + path+ "\" height="+ "\"100\""  + " width=\"200\"" + "/><br></a>");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("<li>" + result.getName() + "  Passed</li>" );
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("<h2>TestCase" + context.getName() + "</h2><br>");
		Reporter.log("<ol type=1>");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("</ol>");
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("<center><h3>Execution result of <b> <font color='red'>" +suite.getName() + "</font></b> Suite</h3></center><br/>");
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}


}
