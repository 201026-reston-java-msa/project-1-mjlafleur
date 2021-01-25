package com.revature.test.web;




import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.revature.helper.ServletHelper;

public class MasterServletTest {
		
	public HttpServletRequest req;
	public HttpServletResponse resp;
	
	ServletHelper mockedGetProcess = mock(ServletHelper.class);
	
	@Test
	/**@author Matthew LaFleur
	 * This will 
	 * 
	 */
	public void isReceivingClient() {
		ServletHelper.getProcess(req, resp);
		
		
	}
	
}
