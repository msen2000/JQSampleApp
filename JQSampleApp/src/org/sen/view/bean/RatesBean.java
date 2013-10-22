package org.sen.view.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.sen.limo.domain.Rates;
import org.sen.limo.model.RatesDAO;

@ManagedBean(name="ratesBean")
@RequestScoped
public class RatesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Rates> ratesVOs;
	    
	public RatesBean() {    	
	    super();
	    System.out.println("RatesBean() ctor has been invoked.");
	    this.retrievesRates();
	}
    
    @PostConstruct
    public void init() {
    	System.out.println("The init() : PostConstruct has been invoked.");
    }

    @PreDestroy
    public void finalizer() {
    	System.out.println("The finalizer() : PreDestroy has been invoked.");
    }

    public void retrievesRates() {
        RatesDAO dao = new RatesDAO();
        ratesVOs = dao.retriveRates();
        System.out.println("ratesVOs size :"+ratesVOs.size());        
    }

	public List<Rates> getRatesVOs() {
		return ratesVOs;
	}

	public void setRatesVOs(List<Rates> ratesVOs) {
		this.ratesVOs = ratesVOs;
	}

}
