package com.iut.banque.controller;

import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.iut.banque.exceptions.IllegalFormatException;
import com.iut.banque.exceptions.IllegalOperationException;
import com.iut.banque.exceptions.TechnicalException;
import com.iut.banque.facade.BanqueFacade;
import com.opensymphony.xwork2.ActionSupport;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

public class CreerUtilisateur extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BanqueFacade banque;
	private String userId;
	private String nom;
	private String prenom;
	private String adresse;
	private String userPwd;
	private boolean male;
	private boolean client;
	private String numClient;
	private String message;
	private String result;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the userPwd
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * @param userPwd
	 *            the userPwd to set
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * @return the male
	 */
	public boolean isMale() {
		return male;
	}

	/**
	 * @param male
	 *            the male to set
	 */
	public void setMale(boolean male) {
		this.male = male;
	}

	/**
	 * @return the user
	 */
	public boolean isClient() {
		return client;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setClient(boolean client) {
		this.client = client;
	}

	/**
	 * @return the numClient
	 */
	public String getNumClient() {
		return numClient;
	}

	/**
	 * @param numClient
	 *            the numClient to set
	 */
	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}

	/**
	 * Constructeur sans paramêtre de CreerUtilisateur
	 */
	public CreerUtilisateur() {
		System.out.println("In Constructor from CreerUtilisateur class ");
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
	 * Renvoie Le message à afficher si la création d'un utilisateur vient
	 * d'être essayée.
	 * 
	 * @return le message de l'action précédente
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter du message provenant de l'action précedente.
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Le result indique si l'utilisateur vient d'arriver sur la page ou a tenté
	 * la création d'un utilisateur précedemment.
	 * 
	 * @return le status de l'action précedente.
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Setter du result de l'action précedente
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * Création d'un utilisateur.
	 * 
	 * @return String : le status de l'action
	 */
	public String creationUtilisateur() {
		try {
			if (client) {
				banque.createClient(userId, userPwd, nom, prenom, adresse, male, numClient);
			} else {
				banque.createManager(userId, userPwd, nom, prenom, adresse, male);
			}
			this.message = "Le nouvel utilisateur avec le user id '" + userId + "' a bien été crée.";
			this.result = "SUCCESS";
			return "SUCCESS";
		} catch (IllegalOperationException e) {
			this.message = "L'identifiant à déjà été assigné à un autre utilisateur de la banque.";
			this.result = "ERROR";
			return "ERROR";
		} catch (TechnicalException e) {
			this.message = "Le numéro de client est déjà assigné à un autre client.";
			this.result = "ERROR";
			return "ERROR";
		} catch (IllegalArgumentException e) {
			this.message = "Le format de l'identifiant est incorrect.";
			this.result = "ERROR";
			return "ERROR";
		} catch (IllegalFormatException e) {
			this.message = "Format du numéro de client incorrect.";
			this.result = "ERROR";
			return "ERROR";
		}
	}
}
