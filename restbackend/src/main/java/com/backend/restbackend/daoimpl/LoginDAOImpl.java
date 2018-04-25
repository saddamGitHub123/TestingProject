package com.backend.restbackend.daoimpl;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.restbackend.dao.LoginDAO;
import com.backend.restbackend.user.dto.DateManagement;
import com.backend.restbackend.user.dto.EventManagement;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.model.BlockDateRequest;



/**
 * @author Sk Saddam Hosan
 *
 */
@Repository("loginDAO")
@Transactional
public class LoginDAOImpl implements LoginDAO {
	
	private static final Logger log = LoggerFactory.getLogger(LoginDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.backend.restapi.dao.LoginDAO#checkLogin(com.backend.restapi.dto.User)
	 * 
	 * this is for login user or shopKeeper login validation
	 * 
	 */
	@Override
	public User checkLogin(User loginuser) {
		
		log.debug("Inserting LoginDAOImpl class of checkLogin() method");
		User user = null;
		String User_Name = loginuser.getUser_Name();
		String User_Password = loginuser.getUser_Password();
		try {
			String selectLogin = "FROM User WHERE User_Name = ? AND User_Password = ? AND is_Active =:is_Active";
			Query query = sessionFactory.getCurrentSession().createQuery(selectLogin);

			query.setParameter(0, User_Name);
			query.setParameter(1, User_Password);
			query.setParameter("is_Active", true);
			List<User> list = query.getResultList();

			if ((list != null) && (list.size() > 0)) {
				// userFound= true;
				log.debug("get successful,User Name and Password found");
				user = list.get(0);
				return user;
			} else {
				log.debug("get successful,No User Name and Password found ");
				return user;
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

	@Override
	public boolean insertDate(EventManagement eventManagement) {
		// TODO Auto-generated method stub
		DateManagement eventManagements =null;
		try {
			
			for(int i=0 ; i< eventManagement.getBlock_Date().size();i++) 
			{
				//eventManagements.setSP_ID("SP_001");
				//eventManagements.setUser_ID(eventManagement.getUser_ID());
				String SP_ID = "SP_001";
				//String datee =eventManagement.getBlock_Date().get(i);
				//String msg = eventManagement.getMessage();
				//String user_ID = eventManagement.getUser_ID();
				
				eventManagements = new DateManagement(SP_ID,eventManagement.getUser_ID(),eventManagement.getBlock_Date().get(i),
						eventManagement.getMessage());
				       
		             sessionFactory.getCurrentSession().persist(eventManagements);
		             
		     }
			
			//sessionFactory.openSession().flush();
			sessionFactory.openSession().beginTransaction().commit();
		return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	
	
	/*
	 * Getting all block date list using SP_ID
	 * */
	@Override
	public List<DateManagement> spAllBlockDate(BlockDateRequest blockDateRequest) {
		// TODO Auto-generated method stub
		String SP_ID = blockDateRequest.getSP_ID();
		String Starting_Date = blockDateRequest.getStarting_Date();
		String Ending_Date = blockDateRequest.getEnding_Date();
		try {
         String showingAllBlockDate = "FROM DateManagement As d where d.Block_Date between :Starting_Date AND :Ending_Date AND SP_ID = :SP_ID";
         
         List<DateManagement> list= sessionFactory
					.getCurrentSession()
					.createQuery(showingAllBlockDate, DateManagement.class)
						.setParameter("SP_ID", SP_ID)
						.setParameter("Starting_Date", Starting_Date)
						.setParameter("Ending_Date", Ending_Date)
							.getResultList();
         
         System.out.println("list size is"+list.size());
         System.out.println("list size is"+list);
         
		return list;
		}catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

}
