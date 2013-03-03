
package br.com.semeru.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author Welton
 */
public class FacesContextUtil {
    private static final String HIBERNATE_SESSION = "hibernate_session";

    public static void setREQUEST_SESSION(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }
    public static Session getREQUEST_SESSION() {
        return (Session)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }
    
}
