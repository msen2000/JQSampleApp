package org.sen.view.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.sen.limo.domain.Request;
import org.sen.limo.model.RequestDAO;

@ManagedBean(name="adminBean")
@RequestScoped
public class AdminBean implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RequestVO> requestVOs = new ArrayList<RequestVO>();
    private List<RequestVO> confirmedRequests = new ArrayList<RequestVO>();
    private RequestVO selectedRequestVO;
        
    public AdminBean() {
        super();
        populatePendingRequest();
       // requestVOs = new ArrayList<RequestVO>(); //pending
        //confirmedRequests = new ArrayList<RequestVO>(); //confirmed
       
    }

    public void populatePendingRequest() {
        requestVOs = new ArrayList<RequestVO>(); //pending
        confirmedRequests = new ArrayList<RequestVO>(); 
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
    }
    public void setRequestVOs(List requestVOs) {
        this.requestVOs = requestVOs;
    }

    public List getRequestVOs() {
        return requestVOs;
    }

    public void setConfirmedRequests(List<RequestVO> confirmedRequests) {
        this.confirmedRequests = confirmedRequests;
    }

    public List<RequestVO> getConfirmedRequests() {
        return confirmedRequests;
    }

    public void onConfirmRequest(ActionEvent actionEvent) {
        // Add event code here...
        System.out.println("onConfirmRequest TODO:");
        
        FacesContext context = FacesContext.getCurrentInstance();  
        Map requestMap = context.getExternalContext().getRequestParameterMap();  
        String clickedReqId = (String)requestMap.get("clickedReqId");
        System.out.println("clickedReqId :"+clickedReqId);
        RequestDAO dao = new RequestDAO();
        dao.updateRequestStatus("Confirmed", clickedReqId);
        //dao.updateRequestStatus("Confirmed", "1");
    }

    public void setSelectedRequestVO(RequestVO selectedRequestVO) {
        this.selectedRequestVO = selectedRequestVO;
    }

    public RequestVO getSelectedRequestVO() {
        return selectedRequestVO;
    }

    public void onRequestIdClicked(ActionEvent actionEvent) {
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
}
