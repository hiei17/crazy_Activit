package org.crazyit.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.crazyit.activiti.webservice.Sale;


public class WebServiceDelegate implements JavaDelegate {

	private Expression wsdl;

	private Expression operation;

	private Expression creator;

	private Expression createDate;

	public void setWsdl(Expression wsdl) {
		this.wsdl = wsdl;
	}

	public void setOperation(Expression operation) {
		this.operation = operation;
	}

	public void setCreator(Expression creator) {
		this.creator = creator;
	}

	public void setCreateDate(Expression createDate) {
		this.createDate = createDate;
	}

	public void execute(DelegateExecution execution) {
		try {
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			// 使用wsdl路径创建Client		
			Client client = dcf.createClient((String) wsdl.getValue(null));
			// 使用配置的值创建参数对象
			Object[] vars = new Object[] { creator.getValue(null),
					createDate.getValue(null) };
			// 调用
			Object[] object = client
					.invoke((String) operation.getValue(null), vars);
			Sale sale = (Sale) object[0];
			System.out.println("在JavaDelegate中调用Web Service后，结果: "
					+ sale.getSaleCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
