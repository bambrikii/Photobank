/**
 * Rate.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roboxchange.merchant.WebService;

public class Rate  implements java.io.Serializable {
    private java.math.BigDecimal incSum;  // attribute

    public Rate() {
    }

    public Rate(
           java.math.BigDecimal incSum) {
           this.incSum = incSum;
    }


    /**
     * Gets the incSum value for this Rate.
     * 
     * @return incSum
     */
    public java.math.BigDecimal getIncSum() {
        return incSum;
    }


    /**
     * Sets the incSum value for this Rate.
     * 
     * @param incSum
     */
    public void setIncSum(java.math.BigDecimal incSum) {
        this.incSum = incSum;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Rate)) return false;
        Rate other = (Rate) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.incSum==null && other.getIncSum()==null) || 
             (this.incSum!=null &&
              this.incSum.equals(other.getIncSum())));
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
        if (getIncSum() != null) {
            _hashCode += getIncSum().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Rate.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Rate"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("incSum");
        attrField.setXmlName(new javax.xml.namespace.QName("", "IncSum"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        typeDesc.addFieldDesc(attrField);
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
