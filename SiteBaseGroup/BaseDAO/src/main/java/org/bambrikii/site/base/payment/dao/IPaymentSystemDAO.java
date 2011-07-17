package org.bambrikii.site.base.payment.dao;

import java.util.List;

import org.bambrikii.site.base.payment.model.PaymentSystem;
import org.bambrikii.site.base.payment.model.PaymentSystemStatusEnum;

public interface IPaymentSystemDAO {

	public abstract PaymentSystem getByName(String name);

	public abstract List<PaymentSystem> getList(PaymentSystemStatusEnum status,
			String order);

}