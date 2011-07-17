/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roboxchange.merchant.WebService;

public interface ServiceSoap extends java.rmi.Remote {

    /**
     * Получение списка способов оплаты, доступных магазину
     */
    public com.roboxchange.merchant.WebService.PaymentMethodsList getPaymentMethods(java.lang.String merchantLogin, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * Получение списка валют, доступных магазину
     */
    public com.roboxchange.merchant.WebService.CurrenciesList getCurrencies(java.lang.String merchantLogin, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * Получение текущих курсов валют / расчет сумм оплаты в различных
     * валютах
     */
    public com.roboxchange.merchant.WebService.RatesList getRates(java.lang.String merchantLogin, java.lang.String incCurrLabel, java.math.BigDecimal outSum, java.lang.String language) throws java.rmi.RemoteException;

    /**
     * Получение информации об операции и ее текущего состояния
     */
    public com.roboxchange.merchant.WebService.OperationStateResponse opState(java.lang.String merchantLogin, int invoiceID, java.lang.String signature) throws java.rmi.RemoteException;
}
