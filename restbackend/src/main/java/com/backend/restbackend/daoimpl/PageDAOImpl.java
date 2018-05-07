package com.backend.restbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.backend.restbackend.dao.PageDAO;
import com.backend.restbackend.page.dto.AppToken;
import com.backend.restbackend.page.dto.HeaderRequestInterceptor;
import com.backend.restbackend.user.dto.DateManagement;
import com.backend.restbackend.user.dto.User;

@Repository("pageDAO")
@Transactional
public class PageDAOImpl implements PageDAO {
	
	private static final Logger log = LoggerFactory.getLogger(PageDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CompletableFuture<String> send(HttpEntity<String> entity) {
		
		String FIREBASE_SERVER_KEY = "AIzaSyAuS9vJADBUEWM_pAQcgPDGR_GcNWP2knw"; // You FCM AUTH key
		   String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send"; 
		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}

	
	
	/**
	 * this  is the daoimple class in the page controller 
	 * it is save and create the new token which is save the database using hibernate query 
	 * 
	 * 
	 * **/
	@Override
	public AppToken CreateTokenAndSave() {
		
		log.debug("Enterring the appToken daoImple class");
		AppToken appToken = new AppToken();
		try{
			
			  sessionFactory.getCurrentSession().persist(appToken);
			  return appToken;
			
		}catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}

		
		
	}



	@Override
	public AppToken validateAppToken(AppToken appToken) {
		
		
		String Token_Value= appToken.getToken_Value();
		String selectLogin = "FROM AppToken WHERE Token_Value = :Token_Value";
		Query query = sessionFactory.getCurrentSession().createQuery(selectLogin);
		query.setParameter("Token_Value", Token_Value);
		List<AppToken> list = query.getResultList();

		if ((list != null) && (list.size() > 0)) {
			// userFound= true;
			log.debug("get successful,User Name and Password found");
			appToken = list.get(0);
			return appToken;
		} else {
			log.debug("get successful,No User Name and Password found ");
			return appToken;
		}
	}

/**
 * Getting random token value imple class 
 * using hibernate query getting one unique token 
 * 
 * ***/

	@Override
	public AppToken randomTokenValue() {
		
		log.debug("Enterring the randoTokenValue() -- in pageDAOImp classs ");
		
		AppToken appToken  = new AppToken();
		
		String selectLogin = "FROM AppToken ORDER BY rand()";
	//	Query query = sessionFactory.getCurrentSession().createQuery(selectLogin).setMaxResults(1);
		
	List<AppToken> list = sessionFactory.getCurrentSession()
						.createQuery(selectLogin,AppToken.class)
							.setMaxResults(1)
								.getResultList();

		
	if ((list != null) && (list.size() > 0)) {
		// userFound= true;
		log.debug("get successful,random token from database");
		appToken = list.get(0);
		return appToken;
	} else {
		log.debug("Random token can not fetch from datbase ");
		return appToken;
	}
		
		//return null;
	}

}
