package com.iut.banque.controller;

import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;

import com.iut.banque.exceptions.IllegalFormatException;
import com.iut.banque.exceptions.IllegalOperationException;
import com.iut.banque.exceptions.TechnicalException;
import com.iut.banque.facade.BanqueFacade;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Compte;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

public class CreerCompte extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String numeroCompte;
	private boolean avecDecouvert;
	private double decouvertAutorise;
	private Client client;
	private String message;
	private boolean error;
	private boolean result;
	private BanqueFacade banque;
	private Compte compte;

	/**
	 * @param compte
	 *            the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Indique si le résultat de l'action précedente avait réussi
	 * 
	 * @return le status de l'action précédente
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * Setter de l'action précédente
	 * 
	 * @param error
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Constructeur sans paramêtre de CreerCompte
	 */
	public CreerCompte() {
		System.out.println("In Constructor from CreerCompte class ");
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
	 * @return the numeroCompte
	 */
	public String getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * @param numeroCompte
	 *            the numeroCompte to set
	 */
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	/**
	 * @return the avecDecouvert
	 */
	public boolean isAvecDecouvert() {
		return avecDecouvert;
	}

	/**
	 * @param avecDecouvert
	 *            the avecDecouvert to set
	 */
	public void setAvecDecouvert(boolean avecDecouvert) {
		this.avecDecouvert = avecDecouvert;
	}

	/**
	 * @return the decouvertAutorise
	 */
	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	/**
	 * @param decouvertAutorise
	 *            the decouvertAutorise to set
	 */
	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * Getter du message résultant de l'action précédente.
	 * 
	 * @return le message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Choisi le message à enregistrer en fonction du message reçu en paramêtre.
	 * 
	 * @param message
	 *            : le message indiquant le status de l'action précédente.
	 */
	public void setMessage(String message) {
		switch (message) {
		case "NONUNIQUEID":
			this.message = "Ce numéro de compte existe déjà !";
			break;
		case "INVALIDFORMAT":
			this.message = "Ce numéro de compte n'est pas dans un format valide !";
			break;
		case "SUCCESS":
			this.message = "Le compte " + compte.getNumeroCompte() + " a bien été créé.";
			break;
		}
	}

	/**
	 * Getter du status de l'action précédente. Si vrai, indique qu'une création
	 * de compte a déjà été essayée (elle peut avoir réussi ou non). Sinon, le
	 * client vient d'arriver sur la page.
	 * 
	 * @return le status de l'action précédente
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * Setter du status de l'action précédente.
	 * 
	 * @param result
	 *            : le status
	 */
	public void setResult(boolean result) {
		this.result = result;
	}

	/**
	 * Action créant un compte client ou gestionnaire.
	 * 
	 * @return une chaine déterminant le résultat de l'action
	 */
	public String creationCompte() {
		try {
			if (avecDecouvert) {
				try {
					banque.createAccount(numeroCompte, client, decouvertAutorise);
				} catch (IllegalOperationException e) {
					e.printStackTrace();
				}
			} else {
				banque.createAccount(numeroCompte, client);
			}
			this.compte = banque.getCompte(numeroCompte);
			return "SUCCESS";
		} catch (TechnicalException e) {
			return "NONUNIQUEID";
		} catch (IllegalFormatException e) {
			return "INVALIDFORMAT";
		}

	}
}
