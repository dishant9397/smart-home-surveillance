package com.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class BaseMethods 
{
	public static String getUser()
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		return userName;
	}
	
    public static void copyFile(String Username) throws IOException
    {
        String from = "C:\\Users\\DJ Patel\\eclipse\\SmartHomeSurveillance\\src\\main\\resources\\static\\adminResources\\images\\No Image.PNG";
        String to = "C:\\Users\\DJ Patel\\eclipse\\SmartHomeSurveillance\\src\\main\\webapp\\documents\\profile\\"+Username+"\\No Image.PNG";
        Path src = Paths.get(from);
        Path dest = Paths.get(to);
        /*Files.copy(src.toFile(), dest.toFile());*/
        Files.copy(src, dest);
    }

	protected static void sendMail(String email, int OTP) 
	{
		java.util.Properties properties = new java.util.Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);
		try 
		{
			MimeMessage message = new MimeMessage(mailSession);
			String content = "Your OTP for Smart Home Surveillance is "+OTP;
			message.setContent(content, "text/html");
			message.setSubject("OTP");
			InternetAddress sender = new InternetAddress("smarthomesurveillance0925@gmail.com", "Smart Home Surveillance");
			InternetAddress receiver = new InternetAddress(email);
			message.setFrom(sender);
			message.setRecipient(Message.RecipientType.TO, receiver);
			message.saveChanges();
			javax.mail.Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", 587, "smarthomesurveillance0925@gmail.com" , "Smart@123");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	protected static int generateOTP(int limit) 
	{
        int otp = 0;
        for (int i = 0; i < limit; i++) 
        {
            int x = new Random().nextInt(9);
            if (x == 0 && i == 0)
                i--;
            else
                otp = (otp * 10) + x;
        }
        return otp;
    }
	
	protected static void sendOTP(String PhoneNumber, int OTP)
	{
        String authkey = "246872AY56MLBlYp5be7f40b";
        String mobiles = PhoneNumber;
        String sender = "SHSOTP";
        String message = "Your OTP for Smart Home Surveillance is "+OTP;
        String route="4";
        String country="91";

        //Prepare Url
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;

        //encoding message
        String encoded_message=URLEncoder.encode(message);

        //Send SMS API
        String mainUrl="http://api.msg91.com/api/sendhttp.php?";

        //Prepare parameter string
        StringBuilder sbPostData= new StringBuilder(mainUrl);
        sbPostData.append("authkey="+authkey);
        sbPostData.append("&mobiles="+mobiles);
        sbPostData.append("&message="+encoded_message);
        sbPostData.append("&route="+route);
        sbPostData.append("&sender="+sender);
        sbPostData.append("&country="+country);

        //final string
        mainUrl = sbPostData.toString();
        try
        {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response
            String response;
            while ((response = reader.readLine()) != null)
            //print response
            System.out.println(response);
            //finally close connection
            reader.close();
        }
        catch (IOException e)
        {
                e.printStackTrace();
        }
    }
	
	public static Date addDays(Date date, int days) 
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}
}
