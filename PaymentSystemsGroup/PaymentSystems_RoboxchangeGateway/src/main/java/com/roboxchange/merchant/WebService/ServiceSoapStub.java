/**
 * ServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roboxchange.merchant.WebService;

public class ServiceSoapStub extends org.apache.axis.client.Stub implements com.roboxchange.merchant.WebService.ServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPaymentMethods");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "MerchantLogin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Language"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "PaymentMethodsList"));
        oper.setReturnClass(com.roboxchange.merchant.WebService.PaymentMethodsList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "GetPaymentMethodsResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCurrencies");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "MerchantLogin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Language"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "CurrenciesList"));
        oper.setReturnClass(com.roboxchange.merchant.WebService.CurrenciesList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "GetCurrenciesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetRates");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "MerchantLogin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "IncCurrLabel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OutSum"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"), java.math.BigDecimal.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Language"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "RatesList"));
        oper.setReturnClass(com.roboxchange.merchant.WebService.RatesList.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "GetRatesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OpState");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "MerchantLogin"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "InvoiceID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Signature"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationStateResponse"));
        oper.setReturnClass(com.roboxchange.merchant.WebService.OperationStateResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OpStateResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

    }

    public ServiceSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ServiceSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ServiceSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "ArrayOfCurrency");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Currency[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Currency");
            qName2 = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Currency");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "ArrayOfMethod");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Method[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Method");
            qName2 = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Method");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "ArrayOfPaymentMethodGroup");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.PaymentMethodGroup[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "PaymentMethodGroup");
            qName2 = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Group");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "CurrenciesList");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.CurrenciesList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Currency");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Currency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Method");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Method.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationInfo");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.OperationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationPaymentMethod");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.OperationPaymentMethod.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationState");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.OperationState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationStateResponse");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.OperationStateResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "PaymentMethodGroup");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.PaymentMethodGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "PaymentMethodsList");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.PaymentMethodsList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Rate");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Rate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "RatesList");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.RatesList.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Response");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Response.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Result");
            cachedSerQNames.add(qName);
            cls = com.roboxchange.merchant.WebService.Result.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.roboxchange.merchant.WebService.PaymentMethodsList getPaymentMethods(java.lang.String merchantLogin, java.lang.String language) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://merchant.roboxchange.com/WebService/GetPaymentMethods");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "GetPaymentMethods"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {merchantLogin, language});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.roboxchange.merchant.WebService.PaymentMethodsList) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.roboxchange.merchant.WebService.PaymentMethodsList) org.apache.axis.utils.JavaUtils.convert(_resp, com.roboxchange.merchant.WebService.PaymentMethodsList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.roboxchange.merchant.WebService.CurrenciesList getCurrencies(java.lang.String merchantLogin, java.lang.String language) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://merchant.roboxchange.com/WebService/GetCurrencies");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "GetCurrencies"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {merchantLogin, language});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.roboxchange.merchant.WebService.CurrenciesList) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.roboxchange.merchant.WebService.CurrenciesList) org.apache.axis.utils.JavaUtils.convert(_resp, com.roboxchange.merchant.WebService.CurrenciesList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.roboxchange.merchant.WebService.RatesList getRates(java.lang.String merchantLogin, java.lang.String incCurrLabel, java.math.BigDecimal outSum, java.lang.String language) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://merchant.roboxchange.com/WebService/GetRates");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "GetRates"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {merchantLogin, incCurrLabel, outSum, language});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.roboxchange.merchant.WebService.RatesList) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.roboxchange.merchant.WebService.RatesList) org.apache.axis.utils.JavaUtils.convert(_resp, com.roboxchange.merchant.WebService.RatesList.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.roboxchange.merchant.WebService.OperationStateResponse opState(java.lang.String merchantLogin, int invoiceID, java.lang.String signature) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://merchant.roboxchange.com/WebService/OpState");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OpState"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {merchantLogin, new java.lang.Integer(invoiceID), signature});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.roboxchange.merchant.WebService.OperationStateResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.roboxchange.merchant.WebService.OperationStateResponse) org.apache.axis.utils.JavaUtils.convert(_resp, com.roboxchange.merchant.WebService.OperationStateResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
