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
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import com.iut.banque.exceptions.IllegalOperationException;
import com.iut.banque.exceptions.TechnicalException;
import com.iut.banque.facade.BanqueFacade;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Compte;

public class ListeCompteManager extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BanqueFacade banque;
	private boolean aDecouvert;
	private Compte compte;
	private Client client;
	private String userInfo;
	private String compteInfo;

	/**
	 * Constructeur de la classe Connect
	 * 
	 * @return Un objet de type Connect avec façade BanqueFacade provenant de sa
	 *         factory
	 */
	public ListeCompteManager() {
		System.out.println("In Constructor from ListeCompteManager class ");
		ApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(new ServletContext() {
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
				});
		this.banque = (BanqueFacade) context.getBean("banqueFacade");

	}

	/**
	 * Méthode qui va renvoer la liste de tous les clients sous forme de hashmap
	 * 
	 * @return Map<String,Client> : la hashmap correspondant au résultat
	 */
	public Map<String, Client> getAllClients() {
		banque.loadClients();
		return banque.getAllClients();
	}

	/**
	 * Getter pour le champ aDecouvert.
	 * 
	 * @return boolean : la valeur du champ aDecouvert
	 */
	public boolean isaDecouvert() {
		return aDecouvert;
	}

	/**
	 * Setter pour le champ aDecouvert.
	 * 
	 * @param aDecouvert
	 *            : la valeur de ce qu'on veut définir
	 */
	public void setaDecouvert(boolean aDecouvert) {
		this.aDecouvert = aDecouvert;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte
	 *            the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the userInfo
	 */
	public String getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            the userInfo to set
	 */
	private void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	/**
	 * @return the userInfo
	 */
	public String getCompteInfo() {
		return compteInfo;
	}

	/**
	 * @param compteInfo
	 *            the compteInfo to set
	 */
	private void setCompteInfo(String compteInfo) {
		this.compteInfo = compteInfo;
	}

	/**
	 * Action appelée pour supprimer un utilisateur
	 * 
	 * @return String, le status de l'opération
	 */
	public String deleteUser() {
		try {
			setUserInfo(client.getIdentity());
			banque.deleteUser(client);
			return "SUCCESS";
		} catch (TechnicalException e) {
			e.printStackTrace();
			return "ERROR";
		} catch (IllegalOperationException ioe) {
			ioe.printStackTrace();
			return "NONEMPTYACCOUNT";
		}
	}

	/**
	 * Action appelée pour supprimer un compte
	 * 
	 * @return String, le status de l'opération
	 */
	public String deleteAccount() {
		try {
			setCompteInfo(compte.getNumeroCompte());
			banque.deleteAccount(compte);
			return "SUCCESS";
		} catch (IllegalOperationException e) {
			e.printStackTrace();
			return "NONEMPTYACCOUNT";
		} catch (TechnicalException e) {
			e.printStackTrace();
			return "ERROR";
		}
	}
}
