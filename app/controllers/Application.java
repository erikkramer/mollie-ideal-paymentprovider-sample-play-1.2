package controllers;

import paymentproviders.IDeal;
import paymentproviders.IDealBank;
import play.*;
import play.data.validation.Required;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	
    	IDeal ideal = new IDeal();
    	List<IDealBank> idealBanks = ideal.getBanks();
    	render(idealBanks);
    }
    
    /*
     * Prepare iDeal payment flow! in Phase 3 of the ordering process..
     * Redirects to the Mollie iDeal payment page, with a return URL to return
     * to our page and a report/check to do a auto payment check from Mollie's side..
     */
    public static void startIDealPayment(@Required String iDealBank){
    	
    	IDeal ideal = new IDeal();
    	ideal.setBankId(iDealBank);
    	ideal.setTestMode(true);
    	ideal.createPayment(1110, "DESCRIPTION", "RETURN_URL", "REPORTURL->URL_POINTING_TO:checkIDealPayment");
    	
    	Logger.info("ideal.toString: " + ideal.toString());
    	
    	redirect(ideal.getBankUrl());
    }
    
    /*
     * Check IDeal payment. Used by Mollie to confirm to the payment..
     */
    public static void checkIDealPayment(@Required String transaction_id){
    	
    	IDeal ideal = new IDeal();
    	ideal.checkPayment(transaction_id);
    	
    	Logger.info("ideal.toString: " + ideal.toString());
    	
    }

}
