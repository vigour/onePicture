/**
 * 
 */
package com.route;

import com.controller.UserController;
import com.jfinal.config.Routes;

/**
 * �û�·������,�û���ص�·�ɶ������ڴ�
 * @author macavity
 *
 */
public class UserRoute extends Routes {

	@Override
	public void config() {
		add("/user", UserController.class);
	}

}
