/**
 * PaymentMethodsList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roboxchange.merchant.WebService;

public class PaymentMethodsList  extends com.roboxchange.merchant.WebService.Response  implements java.io.Serializable {
    private com.roboxchange.merchant.WebService.Method[] methods;

    public PaymentMethodsList() {
    }

    public PaymentMethodsList(
           com.roboxchange.merchant.WebService.Result result,
           com.roboxchange.merchant.WebService.Method[] methods) {
        super(
            result);
        this.methods = methods;
    }


    /**
     * Gets the methods value for this PaymentMethodsList.
     * 
     * @return methods
     */
    public com.roboxchange.merchant.WebService.Method[] getMethods() {
        return methods;
    }


    /**
     * Sets the methods value for this PaymentMethodsList.
     * 
     * @param methods
     */
    public void setMethods(com.roboxchange.merchant.WebService.Method[] methods) {
        this.methods = methods;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentMethodsList)) return false;
        PaymentMethodsList other = (PaymentMethodsList) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.methods==null && other.getMethods()==null) || 
             (this.methods!=null &&
              java.util.Arrays.equals(this.methods, other.getMethods())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getMethods() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMethods());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMethods(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentMethodsList.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "PaymentMethodsList"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("methods");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Methods"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Method"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Method"));
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
