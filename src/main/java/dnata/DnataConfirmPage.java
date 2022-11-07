package dnata;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class DnataConfirmPage 
{
	public static void confirmpageFlight() throws InterruptedException, IOException
	{
		String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_tdContent']/section/div[2]/div/div/div[1]/h2")).getText();
		System.out.println(getT);
		String getTxt1[]= getT.split(":");
		String number = getTxt1[1];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[1]"));
		String getTxt2 = getT1.getText();
		System.out.println(getTxt2);
//		String getTxt3[]= getTxt2.split(",");
//		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+getTxt2);
		
			String text = QaBrowser.driver.findElement (By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("Not Confirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[2]"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(";");
				String number2 = getTxt5[0];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status PNR Number is </i></b>"+number2);
			}
			Thread.sleep(25000);
			QaExtentReport.extentScreenshot("Confirm Page");
	}
	
	public static void confirmpageFlightwithBookingQueue() throws Exception
	{
		String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_tdContent']/section/div[2]/div/div/div[1]/h2")).getText();
		System.out.println(getT);
		String getTxt1[]= getT.split(":");
		String number = getTxt1[1];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>"+number);
		
		String getTxt3[]= number.split("");
		String number1 = getTxt3[2]+getTxt3[3]+getTxt3[4]+getTxt3[5]+getTxt3[6]+getTxt3[7];
		System.out.println(number1);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[1]"));
		String getTxt2 = getT1.getText();
		System.out.println(getTxt2);
//		String getTxt3[]= getTxt2.split(",");
//		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+getTxt2);
		
			String text = QaBrowser.driver.findElement (By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("Not Confirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div/div[1]/div[3]/p/span[2]"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(";");
				String number2 = getTxt5[0];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status PNR Number is </i></b>"+number2);
			}
			Thread.sleep(25000);
			QaExtentReport.extentScreenshot("Confirm Page");
			
			QaBrowser.driver.switchTo().defaultContent();
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			
			QaRobot.ClickOnElement("Bookings");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
			
			QaRobot.ClickOnElement("BookingQueues");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.switchframe("//frame[@id='toolHeader']");
			
			QaRobot.ClickOnElement("CorporateQueue");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("BookingandRepriceQueue");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking and Reprice Queue Button</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("StatusAll");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on StatusAll</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("AdditionalSearchOption");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Additional Search Option</i></b>");
			
			QaRobot.PassValue("BookingSearch",number1);
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Search</i></b>");
			Thread.sleep(30000);
			
			QaRobot.ClickOnElement("SearchBooking");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Booking</i></b>");
			QaExtentReport.extentScreenshot("BookAndQuote Page");
			
			QaRobot.ClickOnElement("BookandQuoteApprove");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(5000);
			
			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) 
			{
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(2000);
			QaRobot.PassValue("TextArea","Ok");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
			
			QaRobot.ClickOnElement("BookandQuoteFinalApprove");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
			Thread.sleep(5000);
			
			QaBrowser.driver.switchTo().alert().accept();
			Thread.sleep(8000);
			
			QaBrowser.driver.switchTo().window(ParentWindow8);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("BookandQuoteBook");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Book Button</i></b>");
			Thread.sleep(8000);
			
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,400)", "");
			
			QaRobot.ClickOnElement("BAQFlightItinerary");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight Itinerary</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("BookAndQuote Flight Itinerary");
			
			QaRobot.ClickOnElement("BAQFareBreakup");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight Breakup</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("BookAndQuote Flight Breakup");
			
			QaRobot.ClickOnElement("BAQFareRules");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight Rules</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("BookAndQuote Flight Rules");
			
			QaRobot.ClickOnElement("BAQSelectItinerary");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Select Itinerary</i></b>");
			
			QaRobot.ClickOnElement("BAQSelectandProceed");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Select and Proceed</i></b>");
			Thread.sleep(8000);
			
			QaExtentReport.extentScreenshot("Checkout Page");
			
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,300)", "");
			
			WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/section/div/div[2]/div[3]/div[1]/div[4]/div[1]/div[7]/div[3]/div[9]/ul/li[1]/a"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", MoreDetails);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("MoreDetails");
			
			WebElement MoreDetailsClose = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div/a"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", MoreDetailsClose);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details Close</i></b>");
			Thread.sleep(5000);
			
			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/section/div/div[2]/div[3]/div[1]/div[4]/div[1]/div[7]/div[3]/div[9]/ul/li[2]/a"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup</i></b>");
			Thread.sleep(2000);
			
			WebElement CustomerCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[1]/a"));
			JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
			js5.executeScript("arguments[0].click()", CustomerCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Customer Cost</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CustomerCost");
			
			WebElement CompanyCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[2]/a"));
			JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
			js6.executeScript("arguments[0].click()", CompanyCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Company Cost</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CompanyCost");
			
			WebElement FareBreakupClose = QaBrowser.driver.findElement(By.xpath("//div[@id='DivfarebrekupIN']/div/div/div[1]/button"));
			JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
			js7.executeScript("arguments[0].click()", FareBreakupClose);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup Close</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(12000);
			
			DnataPaymentPage.individualForFlight();
			
			confirmpageFlight();
	}
	
	public static void confirmpageHotel() throws IOException, InterruptedException
	{
		WebElement getT = QaBrowser.driver.findElement(By.xpath("/html/body/div/form/div[4]/div/div/section/div[2]/div/div/div[1]/h2"));
		String getTxt = getT.getText();
		String getTxt1[]= getTxt.split(" ");
		String number = getTxt1[1];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
		String getTxt2 = getT1.getText();
		String getTxt3[]= getTxt2.split(" ");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+number1);
		
			String text = QaBrowser.driver.findElement (By.xpath("//div[@id='nc_status']/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("UnConfirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(" ");
				String number2 = getTxt5[2];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status Number is </i></b>"+number2);
			}
			Thread.sleep(20000);
			QaExtentReport.extentScreenshot("Confirm Page");
	}
	
	public static void confirmpageFulfilmentHotel() throws IOException, InterruptedException
	{
		WebElement getT = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/div/section/div[2]/div/div/div[1]/h2"));
		String getTxt = getT.getText();
		String getTxt1[]= getTxt.split(" ");
		String number = getTxt1[1];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
		String getTxt2 = getT1.getText();
		String getTxt3[]= getTxt2.split(" ");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>"+number1);
		
			String text = QaBrowser.driver.findElement (By.xpath("//div[@id='nc_status']/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("UnConfirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
				String getTxt4 = getT2.getText();
				String getTxt5[]= getTxt4.split(" ");
				String number2 = getTxt5[2];
				QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status Number is </i></b>"+number2);
			}
			Thread.sleep(20000);
			QaExtentReport.extentScreenshot("Confirm Page");
	}
	
	public static void confirmpageFlight_Hotel() throws IOException
	{
		String getT = QaBrowser.driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[1]/h2")).getText();
		System.out.println(getT);
		String getTxt1[]= getT.split(" ");
		String number = getTxt1[1];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>"+number);
		
		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div[1]/div[1]/div[2]/p"));
		String getTxt2 = getT1.getText();
		System.out.println(getTxt2);
		String getTxt3[]= getTxt2.split(" ");
		String number1 = getTxt3[0];
		System.out.println(number1);
		QaExtentReport.test.log(Status.INFO, "<b><i>Flight Booking Status is </i></b>"+number1);
		
			String text = QaBrowser.driver.findElement (By.xpath("//div[@id='ctl00_contentMain_flt_details']/div[1]/div[1]/div[2]/p/span[1]")).getText();
			
			if(text.equalsIgnoreCase("UnConfirmed"))
			{
				QaExtentReport.test.log(Status.INFO, "<b><i>Flight Booking Fail </i></b>");
			}
			else
			{
				WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div[1]/div[1]/div[2]/p"));
				String getTxt4 = getT2.getText();
				System.out.println(getTxt4);
				String getTxt5[]= getTxt4.split(" ");
				String number2 = getTxt5[2];
				System.out.println(number2);
				QaExtentReport.test.log(Status.INFO, "<b><i>Flight Confirming Status PNR Number is </i></b>"+number2);
			}
			
			WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
			String getTxt5 = getT2.getText();
			System.out.println(getTxt5);
			String getTxt6[]= getTxt5.split(" ");
			String number3 = getTxt6[0];
			System.out.println(number3);
			QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Booking Status is </i></b>"+number3);
			
				String text2 = QaBrowser.driver.findElement (By.xpath("//div[@id='nc_status']/p/span[1]")).getText();
				
				if(text2.equalsIgnoreCase("UnConfirmed"))
				{
					QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Booking Fail </i></b>");
				}
				else
				{
					WebElement getT3 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
					String getTxt7 = getT3.getText();
					String getTxt8[]= getTxt7.split(" ");
					String number4 = getTxt8[2];
					QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Confirming Status Number is </i></b>"+number4);
				}
				QaExtentReport.extentScreenshot("Confirm Page");
	}
}