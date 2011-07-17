/**
 * OperationInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roboxchange.merchant.WebService;

public class OperationInfo  implements java.io.Serializable {
    private java.lang.String incCurrLabel;

    private java.math.BigDecimal incSum;

    private java.lang.String incAccount;

    private com.roboxchange.merchant.WebService.OperationPaymentMethod paymentMethod;

    private java.lang.String outCurrLabel;

    private java.math.BigDecimal outSum;

    public OperationInfo() {
    }

    public OperationInfo(
           java.lang.String incCurrLabel,
           java.math.BigDecimal incSum,
           java.lang.String incAccount,
           com.roboxchange.merchant.WebService.OperationPaymentMethod paymentMethod,
           java.lang.String outCurrLabel,
           java.math.BigDecimal outSum) {
           this.incCurrLabel = incCurrLabel;
           this.incSum = incSum;
           this.incAccount = incAccount;
           this.paymentMethod = paymentMethod;
           this.outCurrLabel = outCurrLabel;
           this.outSum = outSum;
    }


    /**
     * Gets the incCurrLabel value for this OperationInfo.
     * 
     * @return incCurrLabel
     */
    public java.lang.String getIncCurrLabel() {
        return incCurrLabel;
    }


    /**
     * Sets the incCurrLabel value for this OperationInfo.
     * 
     * @param incCurrLabel
     */
    public void setIncCurrLabel(java.lang.String incCurrLabel) {
        this.incCurrLabel = incCurrLabel;
    }


    /**
     * Gets the incSum value for this OperationInfo.
     * 
     * @return incSum
     */
    public java.math.BigDecimal getIncSum() {
        return incSum;
    }


    /**
     * Sets the incSum value for this OperationInfo.
     * 
     * @param incSum
     */
    public void setIncSum(java.math.BigDecimal incSum) {
        this.incSum = incSum;
    }


    /**
     * Gets the incAccount value for this OperationInfo.
     * 
     * @return incAccount
     */
    public java.lang.String getIncAccount() {
        return incAccount;
    }


    /**
     * Sets the incAccount value for this OperationInfo.
     * 
     * @param incAccount
     */
    public void setIncAccount(java.lang.String incAccount) {
        this.incAccount = incAccount;
    }


    /**
     * Gets the paymentMethod value for this OperationInfo.
     * 
     * @return paymentMethod
     */
    public com.roboxchange.merchant.WebService.OperationPaymentMethod getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this OperationInfo.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(com.roboxchange.merchant.WebService.OperationPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the outCurrLabel value for this OperationInfo.
     * 
     * @return outCurrLabel
     */
    public java.lang.String getOutCurrLabel() {
        return outCurrLabel;
    }


    /**
     * Sets the outCurrLabel value for this OperationInfo.
     * 
     * @param outCurrLabel
     */
    public void setOutCurrLabel(java.lang.String outCurrLabel) {
        this.outCurrLabel = outCurrLabel;
    }


    /**
     * Gets the outSum value for this OperationInfo.
     * 
     * @return outSum
     */
    public java.math.BigDecimal getOutSum() {
        return outSum;
    }


    /**
     * Sets the outSum value for this OperationInfo.
     * 
     * @param outSum
     */
    public void setOutSum(java.math.BigDecimal outSum) {
        this.outSum = outSum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationInfo)) return false;
        OperationInfo other = (OperationInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.incCurrLabel==null && other.getIncCurrLabel()==null) || 
             (this.incCurrLabel!=null &&
              this.incCurrLabel.equals(other.getIncCurrLabel()))) &&
            ((this.incSum==null && other.getIncSum()==null) || 
             (this.incSum!=null &&
              this.incSum.equals(other.getIncSum()))) &&
            ((this.incAccount==null && other.getIncAccount()==null) || 
             (this.incAccount!=null &&
              this.incAccount.equals(other.getIncAccount()))) &&
            ((this.paymentMethod==null && other.getPaymentMethod()==null) || 
             (this.paymentMethod!=null &&
              this.paymentMethod.equals(other.getPaymentMethod()))) &&
            ((this.outCurrLabel==null && other.getOutCurrLabel()==null) || 
             (this.outCurrLabel!=null &&
              this.outCurrLabel.equals(other.getOutCurrLabel()))) &&
            ((this.outSum==null && other.getOutSum()==null) || 
             (this.outSum!=null &&
              this.outSum.equals(other.getOutSum())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIncCurrLabel() != null) {
            _hashCode += getIncCurrLabel().hashCode();
        }
        if (getIncSum() != null) {
            _hashCode += getIncSum().hashCode();
        }
        if (getIncAccount() != null) {
            _hashCode += getIncAccount().hashCode();
        }
        if (getPaymentMethod() != null) {
            _hashCode += getPaymentMethod().hashCode();
        }
        if (getOutCurrLabel() != null) {
            _hashCode += getOutCurrLabel().hashCode();
        }
        if (getOutSum() != null) {
            _hashCode += getOutSum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OperationInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incCurrLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "IncCurrLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incSum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "IncSum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "IncAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "PaymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationPaymentMethod"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outCurrLabel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OutCurrLabel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outSum");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OutSum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
