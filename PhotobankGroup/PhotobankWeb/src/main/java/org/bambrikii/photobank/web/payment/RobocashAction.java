package org.bambrikii.photobank.web.payment;

import java.text.MessageFormat;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.bambrikii.photobank.web.logging.beans.LoggingBean;
import org.bambrikii.photobank.web.payment.beans.OrderManagementBean;
import org.bambrikii.photobank.web.payment.beans.RobocashBean;
import org.bambrikii.site.base.business.managers.core.ManagerException;

import com.opensymphony.xwork2.ActionSupport;

public class RobocashAction extends ActionSupport implements
		ServletContextAware {
	private static final long serialVersionUID = -7202070439474722819L;

	// Payment notification query / Result_URL
	private String outSum;
	private String invId;
	private String signatureValue;

	// Payment verification by Merchant / Success_URL
	// Unsuccessful (cancelled) payment / Fail_URL
	private String culture;
	private String incCurrLabel;

	private RobocashBean robocashBean;
	private OrderManagementBean orderManagementBean;
	private LoggingBean loggingBean;

	private ServletContext servletContext;

	public void setLoggingBean(LoggingBean loggingBean) {
		this.loggingBean = loggingBean;
	}

	public LoggingBean getLoggingBean() {
		return loggingBean;
	}

	public void setOutSum(String outSum) {
		this.outSum = outSum;
	}

	public String getOutSum() {
		return outSum;
	}

	public void setInvId(String invId) {
		this.invId = invId;
	}

	public String getInvId() {
		return invId;
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}

	public String getSignatureValue() {
		return signatureValue;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getCulture() {
		return culture;
	}

	public void setIncCurrLabel(String incCurrLabel) {
		this.incCurrLabel = incCurrLabel;
	}

	public String getIncCurrLabel() {
		return incCurrLabel;
	}

	public void setRobocashBean(RobocashBean robocashBean) {
		this.robocashBean = robocashBean;
	}

	public RobocashBean getRobocashBean() {
		return robocashBean;
	}

	public void setOrderManagementBean(OrderManagementBean orderManagementBean) {
		this.orderManagementBean = orderManagementBean;
	}

	public OrderManagementBean getOrderManagementBean() {
		return orderManagementBean;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	public ServletContext getServletContext() {
		return this.servletContext;
	}

	private void logInfo(String name) throws ManagerException {
		getLoggingBean().logInfo(
				RobocashAction.class.getName() + "." + name + "." + getInvId(),
				MessageFormat.format("InvId:{0},OutSum:{1},SignatureValue:{2}",
						getInvId(), getOutSum(), getSignatureValue()),
				RobocashAction.class.getName());
	}

	private void logError(String name, Exception ex) throws ManagerException {
		getLoggingBean().logError(
				RobocashAction.class.getName() + "." + name + "." + getInvId(),

				MessageFormat.format("InvId:{0},OutSum:{1},SignatureValue:{2}",
						getInvId(), getOutSum(), getSignatureValue()), ex,
				RobocashAction.class.getName());
	}

	// Action
	public String result() throws Exception {
		logInfo("result");
		try {
			Boolean result = getRobocashBean().checkResult(getOutSum(),
					getInvId(), getSignatureValue());
			if (result) {
				getOrderManagementBean()
						.waitOrder(Integer.parseInt(getInvId()));
				logInfo("result.SUCCESS");
				return SUCCESS;
			}
			logInfo("result.ERROR");
		} catch (Exception ex) {
			logError("result.EXCEPTION", ex);
		}
		return ERROR;
	}

	public String success() throws Exception {
		logInfo("success");
		try {
			Boolean result = getRobocashBean().checkSuccessOrFail(getOutSum(),
					getInvId(), getSignatureValue());
			if (result) {
				getOrderManagementBean().approveOrder(
						Integer.parseInt(getInvId()),
						getOrderManagementBean().getPaymentSystem(
								RobocashBean.PAYMENT_SYSTEM_NAME),
						getServletContext().getRealPath(""));
				logInfo("success.SUCCESS");
				return SUCCESS;
			}
			logInfo("success.ERROR");
		} catch (Exception ex) {
			logError("success.EXCEPTION", ex);
		}
		return ERROR;
	}

	public String fail() throws Exception {
		logInfo("fail");
		try {
			Boolean result = getRobocashBean().checkSuccessOrFail(getOutSum(),
					getInvId(), getSignatureValue());
			if (result) {
				getOrderManagementBean().rejectOrder(
						Integer.parseInt(getInvId()));
				logInfo("fail.SUCCESS");
				return SUCCESS;
			}
			logInfo("fail.ERROR");
		} catch (Exception ex) {
			logError("fail.EXCEPTION", ex);
		}
		return ERROR;
	}
}
