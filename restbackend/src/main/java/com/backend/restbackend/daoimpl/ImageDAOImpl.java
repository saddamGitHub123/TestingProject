package com.backend.restbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.restbackend.dao.ImageDAO;
import com.backend.restbackend.image.dto.ImageValue;
import com.backend.restbackend.user.dto.User;

/**
 * @author Sk Saddam Hosan
 *
 */

@Repository("imageDAO")
@Transactional
public class ImageDAOImpl implements ImageDAO {

	private static final Logger log = LoggerFactory.getLogger(ImageDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * Implement for saving image 
	 * **/
	@Override
	public boolean saveImageByByte(ImageValue imageValue) {
		log.debug("Inserting ImageDAOImpl class of saveImageByByte() method");
		
		try {
		
		
			
				if(imageValue.getImage() != null ) {
					ImageValue test1 = new ImageValue();
			        test1.setImage(imageValue.getImage());
			        test1.setUser_ID(imageValue.getUser_ID());
			        
			        sessionFactory.getCurrentSession().persist(test1);
			        return true;
			        }
			return false;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			/*
			 * if (sessionFactory != null) { sessionFactory.close(); }
			 */
		}

	}
	
	/*
	 * Implement for getting particular image 
	 * **/

	@Override
	public ImageValue getImageValue(String User_ID) {
		log.debug("Inserting ImageDAOImpl class of getImageValue() method");
		
		ImageValue imageValue = new ImageValue();
		try {
			
			String selectProductsByShopId = "FROM ImageValue WHERE User_ID = :User_ID";
	        List<ImageValue> list= sessionFactory
					.getCurrentSession()
					.createQuery(selectProductsByShopId, ImageValue.class)
						.setParameter("User_ID", User_ID)
					//	.setParameter("Availability", true)
							.getResultList();
			//System.out.println(list);
			
			if ((list != null) && (list.size() > 0)) {
				//userFound= true;
				
				imageValue = list.get(0);
				log.debug("get successful,image list is found");
				return imageValue;
			}
			else {
				log.debug("get successful,image List is not found ");
				return imageValue;
			 }
						
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			/*
			 * if (sessionFactory != null) { sessionFactory.close(); }
			 */
		}
	}

	

	/*
	 * Implement for getting particular image using JSONView
	 * **/
	
	@Override
	public ImageValue getImageValueUsingJSONView(String User_ID) {
		log.debug("Inserting ImageDAOImpl class of getImageValue() method");
		
		ImageValue imageValue = new ImageValue();
		try {
			
			String selectProductsByShopId = "FROM ImageValue WHERE User_ID = :User_ID";
	        List<ImageValue> list= sessionFactory
					.getCurrentSession()
					.createQuery(selectProductsByShopId, ImageValue.class)
						.setParameter("User_ID", User_ID)
					//	.setParameter("Availability", true)
							.getResultList();
			//System.out.println(list);
			
			if ((list != null) && (list.size() > 0)) {
				//userFound= true;
				
				imageValue = list.get(0);
				log.debug("get successful,image list is found");
				return imageValue;
			}
			else {
				log.debug("get successful,image List is not found ");
				return imageValue;
			 }
						
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		} finally {
			/*
			 * if (sessionFactory != null) { sessionFactory.close(); }
			 */
		}
	}
}
