package com.roboxchange.merchant.WebService;

public class ServiceSoapProxy implements com.roboxchange.merchant.WebService.ServiceSoap {
  private String _endpoint = null;
  private com.roboxchange.merchant.WebService.ServiceSoap serviceSoap = null;
  
  public ServiceSoapProxy() {
    _initServiceSoapProxy();
  }
  
  public ServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiceSoapProxy();
  }
  
  private void _initServiceSoapProxy() {
    try {
      serviceSoap = (new com.roboxchange.merchant.WebService.ServiceLocator()).getServiceSoap();
      if (serviceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviceSoap != null)
      ((javax.xml.rpc.Stub)serviceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.roboxchange.merchant.WebService.ServiceSoap getServiceSoap() {
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap;
  }
  
  public com.roboxchange.merchant.WebService.PaymentMethodsList getPaymentMethods(java.lang.String merchantLogin, java.lang.String language) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getPaymentMethods(merchantLogin, language);
  }
  
  public com.roboxchange.merchant.WebService.CurrenciesList getCurrencies(java.lang.String merchantLogin, java.lang.String language) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getCurrencies(merchantLogin, language);
  }
  
  public com.roboxchange.merchant.WebService.RatesList getRates(java.lang.String merchantLogin, java.lang.String incCurrLabel, java.math.BigDecimal outSum, java.lang.String language) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.getRates(merchantLogin, incCurrLabel, outSum, language);
  }
  
  public com.roboxchange.merchant.WebService.OperationStateResponse opState(java.lang.String merchantLogin, int invoiceID, java.lang.String signature) throws java.rmi.RemoteException{
    if (serviceSoap == null)
      _initServiceSoapProxy();
    return serviceSoap.opState(merchantLogin, invoiceID, signature);
  }
  
  
}