package org.bambrikii.photobank.business.managers;

import java.util.List;

import org.bambrikii.site.base.business.managers.ConnectionManager;
import org.bambrikii.site.base.business.managers.ManagerBase;
import org.bambrikii.site.base.business.managers.core.ManagerException;
import org.bambrikii.site.base.payment.dao.PaymentSystemDAO;
import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.bambrikii.site.base.payment.model.PaymentSystemStatusEnum;

public class PaymentSystemManager extends
		ManagerBase<PaymentSystem, PaymentSystemDAO> {

	public PaymentSystemManager(ConnectionManager connector)
			throws ManagerException {
		super(connector);
	}

	public List<PaymentSystem> getActiveList() {
		return dao.getList(PaymentSystemStatusEnum.ENABLED, "order DESC");
	}

	public PaymentSystem getByName(String name) {
		return dao.getByName(name);
	}

}
