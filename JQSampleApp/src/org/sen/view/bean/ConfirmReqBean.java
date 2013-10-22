package org.sen.view.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.sen.limo.model.RequestDAO;

@ManagedBean(name="confirmReqBean")
@RequestScoped
public class ConfirmReqBean implements Serializable{

	private static final long serialVersionUID = 1L;
        
    public ConfirmReqBean() {    	
        super();
        System.out.println("ConfirmReqBean() ctor has been invoked.");
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("The init() : PostConstruct has been invoked.");
    }

    @PreDestroy
    public void finalizer() {
    	System.out.println("The finalizer() : PreDestroy has been invoked.");
    }


    public void moveToPending(ActionEvent actionEvent) {
        System.out.println("moveToPending() invoked");
        
        FacesContext context = FacesContext.getCurrentInstance();  
        Map requestMap = context.getExternalContext().getRequestParameterMap();  
        String clickedReqId = (String)requestMap.get("clickedReqId");
        System.out.println("clickedReqId :"+clickedReqId);
        
        RequestDAO dao = new RequestDAO();
        dao.updateRequestStatus("Pending", clickedReqId);        
    }

}
