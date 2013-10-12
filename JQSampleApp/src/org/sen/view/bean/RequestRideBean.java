package org.sen.view.bean;

import java.io.Serializable;

import org.sen.limo.domain.Request;
import org.sen.limo.model.RequestDAO;

public class RequestRideBean  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestVO requestVO = new RequestVO();
    private String requestConfNumber;
    public RequestRideBean() {
        super();
        requestConfNumber = "";
    }

    public void setRequestVO(RequestVO requestVO) {
        this.requestVO = requestVO;
    }

    public RequestVO getRequestVO() {
        return requestVO;
    }
    
    public String onSubmitRequest() { 
        
            System.out.println("onSubmitRequest"); 
            //return "success";
            RequestDAO dao = new RequestDAO();
            Request req = new Request();
            req.typeOfLimo = requestVO.typeOfLimo;
            req.startDate = requestVO.startDate;
            req.endDate = requestVO.endDate;
            req.startTime = requestVO.startTime;
            req.endTime = requestVO.endTime;
            req.passengers = requestVO.passengers;
            req.yourName = requestVO.yourName;
            req.contactNumber = requestVO.contactNumber;
            req.email = requestVO.email;
            req.occasion = requestVO.occasion;
            req.needADrink = requestVO.needADrink;
            req.status = "Pending";
            requestConfNumber = dao.insertRequest(req);
            System.out.println("requestConfNumber : "+requestConfNumber);
            return "reqConfirm";                
    }

    public void setRequestConfNumber(String requestConfNumber) {
        this.requestConfNumber = requestConfNumber;
    }

    public String getRequestConfNumber() {
        return requestConfNumber;
    }
}
