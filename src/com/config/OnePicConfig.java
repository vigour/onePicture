/**
 * 
 */
package com.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.model.User;
import com.route.UserRoute;

/**
 * @author macavity
 *
 */
public class OnePicConfig extends JFinalConfig {
	/**
	 * �˷����������� JFinal ����ֵ���翪��ģʽ���� devMode ������
	 * �ڿ���ģʽ�£�JFinal ���ÿ������������棬�������������� Controller��Method 
	 * �Լ�������Я���Ĳ�����JFinal ֧�� JSP��FreeMarker��Velocity ���ֳ�����ͼ��
	 * Ĭ��ΪFreeMarker��ͼ
	 */
	public void configConstant(Constants me) {
		me.setDevMode(true);//����ģʽ
	}

	/**
	 * ���� JFinal ����·��
	 */
	public void configRoute(Routes me) {
		me.add(new UserRoute());//�û�·��
	}

	/**
	 * �������
	 */
	public void configPlugin(Plugins me) {
		//dbConfig(me);//���ݿ���
	}

	/**
	 * ����������
	 */
	public void configInterceptor(Interceptors me) {
	}

	/**
	 * ����������
	 */
	public void configHandler(Handlers me) {
	}

	
	/**
	 * ���ݿ�������
	 */
	public void dbConfig(Plugins me){
		loadPropertyFile("onePicture.properties");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
		getProperty("user"), getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user", User.class);
	}
	
}
