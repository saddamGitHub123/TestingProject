package com.backend.apitest.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.backend.restbackend.dao.PageDAO;
import com.backend.restbackend.page.dto.AppToken;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;


/**
 * 
 * @author saddam
 *
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc

public class PageController {
	
	 private static final Logger logger = LoggerFactory.getLogger(PageController.class);
		
	  
	
	@Autowired
	public PageDAO pageDAO;

	//This is for home page 
	
	@RequestMapping(value = {"/home", "/index" })
	public ModelAndView index() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	@RequestMapping(value = {"/userlogin" })
	public ModelAndView LoginPage() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("welCome");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	@RequestMapping(value = {"/e_home" })
	public ModelAndView E_HomePage() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("ShoppingHome");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
	@RequestMapping(value = {"/mens.html" })
	public ModelAndView MensCollection() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("mens");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
	@RequestMapping(value = {"/about.html" })
	public ModelAndView About() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("about");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
	
	@RequestMapping(value = {"/womens.html" })
	public ModelAndView WomensProduct() {
		logger.info("pagecontroller the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		//ModelAndView mv = new ModelAndView("womens");
		ModelAndView mv = new ModelAndView("gcmNotificaion");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
	@RequestMapping(value = {"/testpage" })
	public ModelAndView testPage() {
		logger.info("pagecontroller the PageController testpage ");

	//	ModelAndView mv = new ModelAndView("page");
		//ModelAndView mv = new ModelAndView("womens");
		ModelAndView mv = new ModelAndView("test");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
	
	
	@RequestMapping(value = {"/pushnot" })
	public ModelAndView pushNotification() {
		logger.info("pushnotification This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		//.ModelAndView mv = new ModelAndView("test");
		ModelAndView mv = new ModelAndView("pushnoti");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
//	@RequestMapping(value = {"/pushNotifiationFCM" })
//	public ModelAndView pushNotificationUsinFCM() {
//		logger.info("pushnotification This is the PageController ");
//	final String AUTH_KEY_FCM = "Your api key";
//	final String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
//	final String deviceToken = "";
//
////	public static String sendPushNotification(String deviceToken)
////	        throws IOException {
//	    String result = "";
//	    URL url = new URL(API_URL_FCM);
//	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//	    conn.setUseCaches(false);
//	    conn.setDoInput(true);
//	    conn.setDoOutput(true);
//
//	    conn.setRequestMethod("POST");
//	    conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
//	    conn.setRequestProperty("Content-Type", "application/json");
//
//	    JSONObject json = new JSONObject();
//
//	    json.put("to", deviceToken.trim());
//	    JSONObject info = new JSONObject();
//	    info.put("title", "notification title"); // Notification title
//	    info.put("body", "message body"); // Notification
//	                                                            // body
//	    json.put("notification", info);
//	    try {
//	        OutputStreamWriter wr = new OutputStreamWriter(
//	                conn.getOutputStream());
//	        wr.write(json.toString());
//	        wr.flush();
//
//	        BufferedReader br = new BufferedReader(new InputStreamReader(
//	                (conn.getInputStream())));
//
//	        String output;
//	        System.out.println("Output from Server .... \n");
//	        while ((output = br.readLine()) != null) {
//	            System.out.println(output);
//	        }
//	        result = CommonConstants.SUCCESS;
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        result = CommonConstants.FAILURE;
//	    }
//	    System.out.println("GCM Notification is sent successfully");
//
//	    return result;
//
//	}
//	}
	

	

	@RequestMapping(value = "/GCMNotification", method = RequestMethod.GET)
	public ModelAndView gcmNotification(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		logger.info("This is the PageController ");
		
		
		// Put your Google API Server Key here
		final String GOOGLE_SERVER_KEY = "AIzaSyDE0xgqBs0RQY_bRv1pOwU0QanabwP4IYw";
		final String MESSAGE_KEY = "Push notification working";
		
		Result result = null;

		String share = request.getParameter("shareRegId");

		// GCM RedgId of Android device to send push notification
		String regId = "";
		if (share != null && !share.isEmpty()) {
			regId = request.getParameter("regId");
			PrintWriter writer = new PrintWriter("GCMRegId.txt");
			writer.println(regId);
			writer.close();
			request.setAttribute("pushStatus", "GCM RegId Received.");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		} else {
			try {
				BufferedReader br = new BufferedReader(new FileReader(
						"GCMRegId.txt"));
				regId = br.readLine();
				br.close();
				String userMessage = request.getParameter("message");
				Sender sender = new Sender(GOOGLE_SERVER_KEY);
				Message message = new Message.Builder().timeToLive(30)
						.delayWhileIdle(true).addData(MESSAGE_KEY, userMessage).build();
				System.out.println("regId: " + regId);
				result = sender.send(message, regId, 1);
				request.setAttribute("pushStatus", result.toString());
			} catch (IOException ioe) {
				ioe.printStackTrace();
				request.setAttribute("pushStatus",
						"RegId required: " + ioe.toString());
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("pushStatus", e.toString());
			}
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("gcmNotificaion");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	          }
		return null;
	}
	
	/**
	 * Push notification sending web using web token 
	 * 
	 * */
	
	
	@RequestMapping(value = "/push", method = RequestMethod.GET)
	public ResponseEntity<String> pusNotification() throws IOException{
		logger.info("This is the PageController ");
	
	 String authKey = "AIzaSyAuS9vJADBUEWM_pAQcgPDGR_GcNWP2knw"; // You FCM AUTH key
	   String FMCurl = "https://fcm.googleapis.com/fcm/send"; 
	   String userDeviceIdKey ="dtU7nDL9FeE:APA91bHRDkbEdcXm65TSTYyPFv-E4inzlzqjkzbls3IjuH9iDlistUQIidsnBm7f766mINk-QpVraN9825pjgK8Fpzm"
	   		+ "KxJLUC_xBt2d_c5CMdsds--tN7-ZlRpAtBSk2agllloEYYOG";

	   URL url = new URL(FMCurl);
	   HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	   conn.setUseCaches(false);
	   conn.setDoInput(true);
	   conn.setDoOutput(true);

	   conn.setRequestMethod("POST");
	   conn.setRequestProperty("Authorization","key="+authKey);
	   conn.setRequestProperty("Content-Type","application/json");

	   JSONObject json = new JSONObject();
	   json.put("to",userDeviceIdKey.trim());
	   JSONObject info = new JSONObject();
	   info.put("title", "Notificatoin Title"); // Notification title
	   info.put("body", "Hello Test notification"); // Notification body
	   json.put("notification", info);

	   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	   wr.write(json.toString());
	   wr.flush();
	   conn.getInputStream();
	   System.out.println(wr);
	   System.out.println(json.toString());
	   //ModelAndView mv = new ModelAndView("pushnoti");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
	//	return mv;
	//return "nice";
	//return userDeviceIdKey;
	 //  String firebaseResponse = pushNotification.get();		
		//return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		
	return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	
	}
	
	
	
	

/*
 * Push notification using firebase  checking fcm is working or not using fcm project
 * */
	
	@RequestMapping(value = "/fcmNotification", method = RequestMethod.GET)
	public ResponseEntity<String> send() {
		
		final String TOPIC = "JavaSampleApproach";
		JSONObject body = new JSONObject();
		body.put("to", "/topics/" + TOPIC);
		body.put("priority", "high");

		JSONObject notification = new JSONObject();
		notification.put("title", "JSA Notification");
		notification.put("body", "Happy Message!");
		
		JSONObject data = new JSONObject();
		data.put("Key-1", "JSA Data 1");
		data.put("Key-2", "JSA Data 2");

		body.put("notification", notification);
		body.put("data", data);

		HttpEntity<String> request = new HttpEntity<>(body.toString());

		CompletableFuture<String> pushNotification = pageDAO.send(request);
		CompletableFuture.allOf(pushNotification).join();

		try {
			String firebaseResponse = pushNotification.get();
			
			return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	}
	
	
	
	/**
	 * Generate the authentication token 
	 * 
	 * */
	@RequestMapping(value = "/saveToken" , method = RequestMethod.GET)
	public @ResponseBody AppToken SaveToken()
	{
		
		logger.info("Enterring the SaveToken methond -- in PageContrller ");
		AppToken appTokn =  pageDAO.CreateTokenAndSave();
		
//		if() {
//			
//		}
		return appTokn;
		
	}
	
	
	/**
	 * fatching the authentication token usign toekn from the app 
	 * **/
	
	
	@RequestMapping(value = "/validTokenSearch", method = RequestMethod.POST)
	public @ResponseBody AppToken validationForAppToken(@RequestBody AppToken appToken) {
		
		
		AppToken validToken =  pageDAO.validateAppToken(appToken);
		
		return validToken;
		
	}
	
	/*
	 * Getting random one token from database using 
	 * **/
	
	@RequestMapping(value = "/random/tokenValue", method = RequestMethod.GET)
	public @ResponseBody AppToken GettingRandomToken() {
		
		
		AppToken validToken =  pageDAO.randomTokenValue();
		
		return validToken;
		
	}
	
	
	
	
	
	

}
