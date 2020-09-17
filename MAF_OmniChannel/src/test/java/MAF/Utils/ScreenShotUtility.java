package MAF.Utils;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mongodb.MapReduceCommand.OutputType;

import MAF.BasePackage.ProjectBaseClass;
import freemarker.template.SimpleDate;

public class ScreenShotUtility extends ProjectBaseClass {

	public static String ScreenShotName;
	public static String ScreenShotPathPass;
	public static String ScreenShotPathFailed;


	public ScreenShotUtility (String ScreenShotName1) {

		SimpleDateFormat Formatter = new SimpleDateFormat("yyyymmddhhmmss");
		Date date = new Date(System.currentTimeMillis());
		String date1 = Formatter.format(date);
		ScreenShotName = ScreenShotName1;
		ScreenShotPathPass = projectpath1 +"/ScreenShots/" + ScreenShotName + "_" +date1+"_PASS" +".jpg"; 
		ScreenShotPathFailed = projectpath1 +"/ScreenShots/" + ScreenShotName + "_" +date1+"_Failed" +".jpg"; 
	}


	public static void TakeScreenPass() throws IOException, InterruptedException {

		//Take ScreenShot
		File file=((TakesScreenshot)driver1).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		try {

			//COpy the screen shot to desired loaction useing copy file
			FileUtils.copyFile(file, new File(ScreenShotPathPass));
		} catch (IOException e){

			e.printStackTrace();

		}}

	public void TakeScreenFail() throws IOException, InterruptedException {

		//Take ScreenShot
		File file=((TakesScreenshot)driver1).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		try {

			//COpy the screen shot to desired loaction useing copy file
			FileUtils.copyFile(file, new File(ScreenShotPathFailed));
		} catch (IOException e){

			e.printStackTrace();

		}
	}}

