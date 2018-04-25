package com.backend.restbackend.dao;

import java.util.List;

import com.backend.restbackend.user.dto.DateManagement;
import com.backend.restbackend.user.dto.EventManagement;
import com.backend.restbackend.user.dto.User;
import com.backend.restbackend.user.model.BlockDateRequest;

/**
 * 
 */


/**
 * @author Sk Saddam Hosan
 *
 */
public interface LoginDAO {
	
	/**
	 * login validation 
	 * **/
	
	User checkLogin(User loginuser);
	
	boolean insertDate(EventManagement eventManagement);
	
	List<DateManagement> spAllBlockDate(BlockDateRequest blockDateRequest);

}
