package com.Utilities;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;



public class LogGeneration {
	 public static final Logger logger=Logger.getLogger("MyLog");
	private static String w_LogPath = "C:\\Users\\subrahmanyam\\Desktop\\Tools for Selenium with Java\\Appian_ASOE\\LogFiles\\Logs.";
			//Path.GetDirectoryName(Path.GetDirectoryName(System.IO.Directory.GetCurrentDirectory())) + "\\LogFiles\\logfile";
	 //Logger logger = Logger.getLogger("MyLog"); 
	
	public static String getCurrTime()
	{
		Date today = new Date();
		 String strDateFormat = "dd/MM/yyyy hh:mm:ss a";
		 DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		 String formattedDate= dateFormat.format(today);
		 //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		 return formattedDate;
	}
  public static void GenerateLogfile(String SuitName)
    {
        // Create log file Name
	 try {
		 
	        
	  SimpleLayout layout = new SimpleLayout();           
	  FileAppender appender = new FileAppender(layout,("C:\\Users\\moneecasinha\\Desktop\\Tools for Selenium with Java\\Appian_ASOE\\LogFiles\\Logs."+SuitName+" "+new Date().getTime()+".txt"),false);
	 logger.addAppender(appender);
	   
     // FileAppender appender = new FileAppender(layout,("C:\\Users\\moneecasinha\\Desktop\\Tools for Selenium with Java\\Appian_ASOE\\LogFiles\\Logs."+SuitName+" "+getCurrTime())+".txt",false);
	  // logger.addAppender(appender); 
      //w_LogPath = w_LogPath + SuitName +(formatter.format(today))+ ".txt";
	 } 
	 catch(Exception e)
	 {
		 System.out.println(e);
     }
    }
  public static void GenerateLog(String logMessage)
  {
	try {		
		 
		  /*SimpleLayout layout = new SimpleLayout();           
		  FileAppender appender = new FileAppender(layout,("C:\\Users\\moneecasinha\\Desktop\\Tools for Selenium with Java\\Appian_ASOE\\LogFiles\\Logs."+" "+new Date().getTime()+".txt"),false);
		 logger.addAppender(appender);*/
	  logger.info(logMessage);
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
  }
  
  public static void LogWrite(String logMessage)
  {
      try
      {
          //w_LogPath = w_LogPath + "logfile.txt";
    	  OutputStream Variable_name1 = new FileOutputStream(w_LogPath);
    	  OutputStreamWriter Variable_name2 = new OutputStreamWriter(Variable_name1);
    	  Variable_name2.write(logMessage);
          
      }
      catch (Exception e)
      {
      }

}
  public static void Log(String logMessage, Writer txtWriter)
  {
      try
      {
          txtWriter.write("\r\nLog Entry : ");
          //txtWriter.WriteLine("{0} {1}", DateTime.Now.ToLongTimeString(),
              //DateTime.Now.ToLongDateString());
          txtWriter.write("  :");
          txtWriter.write(logMessage);
          txtWriter.write("-------------------------------");
      }
      catch (Exception e)
      {
      }
  }
}
