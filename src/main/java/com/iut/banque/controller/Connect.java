package com.iut.banque.controller;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import com.iut.banque.constants.LoginConstants;
import com.iut.banque.facade.BanqueFacade;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Compte;
import com.iut.banque.modele.Utilisateur;

public class Connect extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String userCde;
	private String userPwd;
	private BanqueFacade banque;

	/**
	 * Constructeur de la classe Connect
	 * 
	 * @return Un objet de type Connect avec façade BanqueFacade provenant de sa
	 *         factory
	 */
	public Connect() {
		System.out.println("In Constructor from Connect class ");
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext((new ServletContext() {
					@Override
					public String getContextPath() {
						return null;
					}

					@Override
					public ServletContext getContext(String s) {
						return null;
					}

					@Override
					public int getMajorVersion() {
						return 0;
					}

					@Override
					public int getMinorVersion() {
						return 0;
					}

					@Override
					public int getEffectiveMajorVersion() {
						return 0;
					}

					@Override
					public int getEffectiveMinorVersion() {
						return 0;
					}

					@Override
					public String getMimeType(String s) {
						return null;
					}

					@Override
					public Set<String> getResourcePaths(String s) {
						return null;
					}

					@Override
					public URL getResource(String s) throws MalformedURLException {
						return null;
					}

					@Override
					public InputStream getResourceAsStream(String s) {
						return null;
					}

					@Override
					public RequestDispatcher getRequestDispatcher(String s) {
						return null;
					}

					@Override
					public RequestDispatcher getNamedDispatcher(String s) {
						return null;
					}

					@Override
					public void log(String s) {

					}

					@Override
					public void log(String s, Throwable throwable) {

					}

					@Override
					public String getRealPath(String s) {
						return null;
					}

					@Override
					public String getServerInfo() {
						return null;
					}

					@Override
					public String getInitParameter(String s) {
						return null;
					}

					@Override
					public Enumeration<String> getInitParameterNames() {
						return null;
					}

					@Override
					public boolean setInitParameter(String s, String s1) {
						return false;
					}

					@Override
					public Object getAttribute(String s) {
						return null;
					}

					@Override
					public Enumeration<String> getAttributeNames() {
						return null;
					}

					@Override
					public void setAttribute(String s, Object o) {

					}

					@Override
					public void removeAttribute(String s) {

					}

					@Override
					public String getServletContextName() {
						return null;
					}

					@Override
					public ServletRegistration.Dynamic addServlet(String s, String s1) {
						return null;
					}

					@Override
					public ServletRegistration.Dynamic addServlet(String s, Servlet servlet) {
						return null;
					}

					@Override
					public ServletRegistration.Dynamic addServlet(String s, Class<? extends Servlet> aClass) {
						return null;
					}

					@Override
					public ServletRegistration.Dynamic addJspFile(String s, String s1) {
						return null;
					}

					@Override
					public <T extends Servlet> T createServlet(Class<T> aClass) throws ServletException {
						return null;
					}

					@Override
					public ServletRegistration getServletRegistration(String s) {
						return null;
					}

					@Override
					public Map<String, ? extends ServletRegistration> getServletRegistrations() {
						return null;
					}

					@Override
					public FilterRegistration.Dynamic addFilter(String s, String s1) {
						return null;
					}

					@Override
					public FilterRegistration.Dynamic addFilter(String s, Filter filter) {
						return null;
					}

					@Override
					public FilterRegistration.Dynamic addFilter(String s, Class<? extends Filter> aClass) {
						return null;
					}

					@Override
					public <T extends Filter> T createFilter(Class<T> aClass) throws ServletException {
						return null;
					}

					@Override
					public FilterRegistration getFilterRegistration(String s) {
						return null;
					}

					@Override
					public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
						return null;
					}

					@Override
					public SessionCookieConfig getSessionCookieConfig() {
						return null;
					}

					@Override
					public void setSessionTrackingModes(Set<SessionTrackingMode> set) {

					}

					@Override
					public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
						return null;
					}

					@Override
					public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
						return null;
					}

					@Override
					public void addListener(String s) {

					}

					@Override
					public <T extends EventListener> void addListener(T t) {

					}

					@Override
					public void addListener(Class<? extends EventListener> aClass) {

					}

					@Override
					public <T extends EventListener> T createListener(Class<T> aClass) throws ServletException {
						return null;
					}

					@Override
					public JspConfigDescriptor getJspConfigDescriptor() {
						return null;
					}

					@Override
					public ClassLoader getClassLoader() {
						return null;
					}

					@Override
					public void declareRoles(String... strings) {

					}

					@Override
					public String getVirtualServerName() {
						return null;
					}

					@Override
					public int getSessionTimeout() {
						return 0;
					}

					@Override
					public void setSessionTimeout(int i) {

					}

					@Override
					public String getRequestCharacterEncoding() {
						return null;
					}

					@Override
					public void setRequestCharacterEncoding(String s) {

					}

					@Override
					public String getResponseCharacterEncoding() {
						return null;
					}

					@Override
					public void setResponseCharacterEncoding(String s) {

					}
				}));
		this.banque = (BanqueFacade) context.getBean("banqueFacade");

	}

	/**
	 * Méthode pour vérifier la connexion de l'utilisateur basé sur les
	 * paramêtres userCde et userPwd de cette classe
	 * 
	 * @return String, le resultat du login; "SUCCESS" si réussi, "ERROR" si
	 *         échec
	 */
	public String login() {
		System.out.println("Essai de login - 20180512...");

		if (userCde == null || userPwd == null) {
			return "ERROR";
		}
		userCde = userCde.trim();

		int loginResult;
		try {
			loginResult = banque.tryLogin(userCde, userPwd);
		} catch (Exception e) {
			e.printStackTrace();
			loginResult = LoginConstants.ERROR;
		}

		switch (loginResult) {
		case LoginConstants.USER_IS_CONNECTED:
			System.out.println("user logged in");
			return "SUCCESS";
		case LoginConstants.MANAGER_IS_CONNECTED:
			System.out.println("manager logged in");
			return "SUCCESSMANAGER";
		case LoginConstants.LOGIN_FAILED:
			System.out.println("login failed");
			return "ERROR";
		default:
			System.out.println("error");
			return "ERROR";
		}
	}

	/**
	 * Getter du champ userCde
	 * 
	 * @return String, le userCde de la classe
	 */
	public String getUserCde() {
		return userCde;
	}

	/**
	 * Setter du champ userCde
	 * 
	 * @param userCde
	 *            : String correspondant au userCode à établir
	 */
	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}

	/**
	 * Getter du champ userPwd
	 * 
	 * @return String, le userPwd de la classe
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * Setter du champ userPwd
	 * 
	 * @param userPwd
	 *            : correspondant au pwdCde à établir
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * Getter du champ utilisateur (uilisé pour récupérer l'utilisateur
	 * actuellement connecté à l'application)
	 * 
	 * @return Utilisateur, l'utilisateur de la classe
	 */
	public Utilisateur getConnectedUser() {
		return banque.getConnectedUser();
	}

	/**
	 * Méthode qui va récupérer sous forme de map la liste des comptes du client
	 * actuellement connecté à l'application
	 * 
	 * @return Map<String, Compte> correspondant à l'ID du compte et l'objet
	 *         Compte associé
	 */
	public Map<String, Compte> getAccounts() {
		return ((Client) banque.getConnectedUser()).getAccounts();
	}

	public String logout() {
		System.out.println("Logging out");
		banque.logout();
		return "SUCCESS";
	}

}
