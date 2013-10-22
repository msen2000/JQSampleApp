package org.sen.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.sen.limo.domain.Request;
import org.sen.limo.model.RequestDAO;

@ManagedBean(name="adminBean")
@RequestScoped
public class AdminBean implements Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private List<RequestVO> requestVOs;
    private List<RequestVO> confirmedRequests;
    private RequestVO selectedRequestVO;
    private String clickedRequestId;
        
    public AdminBean() {    	
        super();
        System.out.println("AdminBean() ctor has been invoked.");
        this.populatePendingRequest();
    }
    
    @PostConstruct
    public void init() {
    	System.out.println("The Initializer() : PostConstruct has been invoked.");
    }

    @PreDestroy
    public void finalizer() {
    	System.out.println("The Initializer() : PreDestroy has been invoked.");
    }

    public void populatePendingRequest() {
        requestVOs = new ArrayList<RequestVO>(); //pending
        confirmedRequests = new ArrayList<RequestVO>();  //Conformed
        RequestDAO dao = new RequestDAO();
        List<Request> reqs = dao.retrivePendingRequest();
        for(Request req :reqs) {        
            RequestVO rvo = new RequestVO();
            rvo.ID = req.ID;
            rvo.typeOfLimo = req.typeOfLimo;
            rvo.startDate = req.startDate;
            rvo.endDate = req.endDate;
            rvo.startTime = req.startTime;
            rvo.endTime = req.endTime;
            rvo.yourName = req.yourName;
            rvo.contactNumber = req.contactNumber;
            rvo.email = req.email;
            rvo.occasion = req.occasion;
            rvo.needADrink = req.needADrink;
            rvo.status = req.status;
            if("Pending".equalsIgnoreCase(req.status)) {
                requestVOs.add(rvo);
            } else {
                confirmedRequests.add(rvo);    
            }
        }
        System.out.println("requestVOs size :"+requestVOs.size());
        System.out.println("confirmedRequests size :"+confirmedRequests.size());
    }


    public void setConfirmedRequests(List<RequestVO> confirmedRequests) {
        this.confirmedRequests = confirmedRequests;
    }

    public List<RequestVO> getConfirmedRequests() {
        return confirmedRequests;
    }

    public void setSelectedRequestVO(RequestVO selectedRequestVO) {
        this.selectedRequestVO = selectedRequestVO;
    }

    public RequestVO getSelectedRequestVO() {
        return selectedRequestVO;
    }

	public String getClickedRequestId() {
		return clickedRequestId;
	}

	public void setClickedRequestId(String clickedRequestId) {
		this.clickedRequestId = clickedRequestId;
	}

	public void setRequestVOs(List<RequestVO> requestVOs) {
		this.requestVOs = requestVOs;
	}
	
    public List getRequestVOs() {
        return requestVOs;
    }

    public void onRequestIdClicked(ActionEvent actionEvent) {
    	System.out.println("onRequestIdClicked() invoked");
        FacesContext context = FacesContext.getCurrentInstance();  
        Map requestMap = context.getExternalContext().getRequestParameterMap();  
        String clickedReqId = (String)requestMap.get("currentReqId");
        System.out.println("#currentReqId :"+clickedReqId);
        
        // Add event code here...
        System.out.println(actionEvent.getSource().toString());
        for(RequestVO requestVO : requestVOs ) {
            if(clickedReqId.equalsIgnoreCase(requestVO.getID())) {
                selectedRequestVO = requestVO;
                break;
            }
        }
        
    }

    public void onConfirmRequest(ActionEvent actionEvent) {
        System.out.println("onConfirmRequest() invoked");
        
        FacesContext context = FacesContext.getCurrentInstance();  
        Map requestMap = context.getExternalContext().getRequestParameterMap();  
        String clickedReqId = (String)requestMap.get("clickedReqId");
        System.out.println("clickedReqId :"+clickedReqId);
        
        RequestDAO dao = new RequestDAO();
        dao.updateRequestStatus("Confirmed", clickedReqId);
        
        //Refress the data:
//        if(clickedReqId != null) {
//	        for(Iterator<RequestVO> it = requestVOs.iterator(); it.hasNext();) {        
//	        	if (clickedReqId.equals(it.next().getID())) {
//	        		it.remove();
//	        	}
//	        }
//        }
    }

/*
    public void moveToPending(ActionEvent actionEvent) {
        System.out.println("moveToPending() invoked");
        
        FacesContext context = FacesContext.getCurrentInstance();  
        Map requestMap = context.getExternalContext().getRequestParameterMap();  
        String clickedReqId = (String)requestMap.get("clickedReqId");
        System.out.println("clickedReqId :"+clickedReqId);
        
        RequestDAO dao = new RequestDAO();
        dao.updateRequestStatus("Pending", clickedReqId);
        
    }
*/
}
