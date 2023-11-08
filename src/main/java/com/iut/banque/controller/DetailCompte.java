package com.iut.banque.controller;

import jakarta.servlet.*;
import jakarta.servlet.descriptor.JspConfigDescriptor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.iut.banque.exceptions.IllegalFormatException;
import com.iut.banque.exceptions.InsufficientFundsException;
import com.iut.banque.facade.BanqueFacade;
import com.iut.banque.modele.Client;
import com.iut.banque.modele.Compte;
import com.iut.banque.modele.Gestionnaire;
import com.opensymphony.xwork2.ActionSupport;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import static org.apache.struts2.ServletActionContext.getServletContext;

public class DetailCompte extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected BanqueFacade banque;
	private String montant;
	private String error;
	protected Compte compte;

	/**
	 * Constructeur du controlleur DetailCompte
	 * 
	 * Récupère l'ApplicationContext
	 * 
	 * @return un nouvel objet DetailCompte avec une BanqueFacade provenant de
	 *         la factory
	 */
	public DetailCompte() {
		System.out.println("In Constructor from DetailCompte class ");
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
	 * Retourne sous forme de string le message d'erreur basé sur le champ
	 * "error" actuellement défini dans la classe
	 * 
	 * @return String, le string avec le détail du message d'erreur
	 */
	public String getError() {
		switch (error) {
		case "TECHNICAL":
			return "Erreur interne. Verifiez votre saisie puis réessayer. Contactez votre conseiller si le problème persiste.";
		case "BUSINESS":
			return "Fonds insuffisants.";
		case "NEGATIVEAMOUNT":
			return "Veuillez rentrer un montant positif.";
		case "NEGATIVEOVERDRAFT":
			return "Veuillez rentrer un découvert positif.";
		case "INCOMPATIBLEOVERDRAFT":
			return "Le nouveau découvert est incompatible avec le solde actuel.";
		default:
			return "";
		}
	}

	/**
	 * Permet de définir le champ error de la classe avec le string passé en
	 * paramètre. Si jamais on passe un objet null, on adapte le string
	 * automatiquement en "EMPTY"
	 * 
	 * @param error
	 *            : Un String correspondant à celui qu'on veut définir dans le
	 *            champ error
	 */
	public void setError(String error) {
		if (error == null) {
			this.error = "EMPTY";
		} else {
			this.error = error;
		}
	}

	/**
	 * Getter du champ montant
	 * 
	 * @return String : valeur du champ montant
	 */
	public String getMontant() {
		return montant;
	}

	/**
	 * Setter du champ montant
	 * 
	 * @param montant
	 *            un String correspondant au montant à définir
	 */
	public void setMontant(String montant) {
		this.montant = montant;
	}

	/**
	 * Getter du compte actuellement sélectionné. Récupère la liste des comptes
	 * de l'utilisateur connecté dans un premier temps. Récupère ensuite dans la
	 * HashMap la clé qui comporte le string provenant de idCompte. Renvoie donc
	 * null si le compte n'appartient pas à l'utilisateur
	 * 
	 * @return Compte : l'objet compte après s'être assuré qu'il appartient à
	 *         l'utilisateur
	 */
	public Compte getCompte() {
		if (banque.getConnectedUser() instanceof Gestionnaire) {
			return compte;
		} else if (banque.getConnectedUser() instanceof Client) {
			if (((Client) banque.getConnectedUser()).getAccounts().containsKey(compte.getNumeroCompte())) {
				return compte;
			}
		}
		return null;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/**
	 * Méthode débit pour débter le compte considéré en cours
	 * 
	 * @return String : Message correspondant à l'état du débit (si il a réussi
	 *         ou pas)
	 */
	public String debit() {
		Compte compte = getCompte();
		try {
			banque.debiter(compte, Double.parseDouble(montant.trim()));
			return "SUCCESS";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "ERROR";
		} catch (InsufficientFundsException ife) {
			ife.printStackTrace();
			return "NOTENOUGHFUNDS";
		} catch (IllegalFormatException e) {
			e.printStackTrace();
			return "NEGATIVEAMOUNT";
		}
	}

	/**
	 * Méthode crédit pour créditer le compte considéré en cours
	 * 
	 * @return String : Message correspondant à l'état du crédit (si il a réussi
	 *         ou pas)
	 */
	public String credit() {
		Compte compte = getCompte();
		try {
			banque.crediter(compte, Double.parseDouble(montant.trim()));
			return "SUCCESS";
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			return "ERROR";
		} catch (IllegalFormatException e) {
			e.printStackTrace();
			return "NEGATIVEAMOUNT";
		}
	}
}
