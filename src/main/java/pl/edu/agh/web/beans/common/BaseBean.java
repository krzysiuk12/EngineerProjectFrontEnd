package pl.edu.agh.web.beans.common;

import pl.edu.agh.exceptions.response.FormValidationError;
import pl.edu.agh.web.beans.ApplicationBean;
import pl.edu.agh.web.beans.SessionBean;
import pl.edu.agh.web.messages.BaseMessage;
import pl.edu.agh.web.messages.ResponseErrorMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.el.ELResolver;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
public class BaseBean {

    private SessionBean sessionBean;
    private ApplicationBean applicationBean;

    public void refreshPageData() {
        getSessionBean().refreshRequestData();
    }

    public String tryToNavigate(NavigationResults navigationResults) {
        return getSessionBean().getErrorMessages().isEmpty() ? navigationResults.getNavigation() : NavigationResults.RELOAD_PAGE.getNavigation();
    }

    public static Object getManagedBean(String beanName) {
        ELResolver resolver = FacesContext.getCurrentInstance().getApplication().getELResolver();
        return resolver.getValue(FacesContext.getCurrentInstance().getELContext(), null, beanName);
    }

    public void processRequestException(Exception ex) {
        System.out.println(ex);
        if (ex instanceof FormValidationError) {
            addErrorMessage(((FormValidationError) ex).getErrorMessages());
        } else if (ex instanceof FormValidationError) {
            //addErrorMessage(ResponseErrorMessages.ZERO_RESULTS_RETURNED);
        } else if (ex instanceof FormValidationError) {
            addErrorMessage(ResponseErrorMessages.ACCESS_DENIED);
        } else if (ex instanceof FormValidationError) {
            addErrorMessage(ResponseErrorMessages.REQUEST_DENIED);
        } else {
            addErrorMessage(ResponseErrorMessages.UNKNOWN_ERROR);
        }
    }

    //<editor-fold desc="Getters and Setters">
    public SessionBean getSessionBean() {
        if (sessionBean == null) {
            sessionBean = (SessionBean) getManagedBean("sessionBean");
        }
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public ApplicationBean getApplicationBean() {
        if (applicationBean == null) {
            applicationBean = (ApplicationBean) getManagedBean("applicationBean");
        }
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }
    //</editor-fold>

    //<editor-fold desc="Messages Management">
    public List<BaseMessage> getErrorMessages() {
        return getSessionBean().getErrorMessages();
    }

    public List<BaseMessage> getInfoMessages() {
        return getSessionBean().getInfoMessages();
    }

    public boolean isErrorMessageEmpty() {
        return getErrorMessages().isEmpty();
    }

    public boolean isInfoMessageEmpty() {
        return getInfoMessages().isEmpty();
    }

    public void addErrorMessage(BaseMessage message) {
        getErrorMessages().add(message);
    }

    public void addErrorMessage(List<? extends BaseMessage> messages) {
        for (BaseMessage message : messages) {
            getErrorMessages().add(message);
        }
    }

    public void addInfoMessage(BaseMessage message) {
        getInfoMessages().add(message);
    }

    public void addInfoMessage(List<? extends BaseMessage> messages) {
        for (BaseMessage message : messages) {
            getInfoMessages().add(message);
        }
    }
    //</editor-fold>
}
