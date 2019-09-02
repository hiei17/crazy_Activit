package org.crazyit.activiti.webservice;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface SaleService {

	@WebMethod
	@WebResult(name = "newSale")
	Sale createSale(@WebParam(name = "creator")String creator, 
			@WebParam(name = "createDate")String createDate);
}
