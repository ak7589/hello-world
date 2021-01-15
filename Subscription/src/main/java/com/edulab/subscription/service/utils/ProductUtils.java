package com.edulab.subscription.service.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductUtils {
	
	
	public synchronized static String  getTransactionId(String memberId, String productCode)
	{
	    
	        Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSS");
	        
	        
	        String dateTime = ft.format(dNow);
	        
	        String transactionId = memberId + productCode + dateTime;
	       
	        return transactionId;
	
	}

}
