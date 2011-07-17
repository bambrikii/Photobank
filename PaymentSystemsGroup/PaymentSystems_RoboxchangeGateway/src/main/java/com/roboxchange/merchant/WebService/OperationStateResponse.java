/**
 * OperationStateResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.roboxchange.merchant.WebService;

public class OperationStateResponse  extends com.roboxchange.merchant.WebService.Response  implements java.io.Serializable {
    private com.roboxchange.merchant.WebService.OperationState state;

    private com.roboxchange.merchant.WebService.OperationInfo info;

    public OperationStateResponse() {
    }

    public OperationStateResponse(
           com.roboxchange.merchant.WebService.Result result,
           com.roboxchange.merchant.WebService.OperationState state,
           com.roboxchange.merchant.WebService.OperationInfo info) {
        super(
            result);
        this.state = state;
        this.info = info;
    }


    /**
     * Gets the state value for this OperationStateResponse.
     * 
     * @return state
     */
    public com.roboxchange.merchant.WebService.OperationState getState() {
        return state;
    }


    /**
     * Sets the state value for this OperationStateResponse.
     * 
     * @param state
     */
    public void setState(com.roboxchange.merchant.WebService.OperationState state) {
        this.state = state;
    }


    /**
     * Gets the info value for this OperationStateResponse.
     * 
     * @return info
     */
    public com.roboxchange.merchant.WebService.OperationInfo getInfo() {
        return info;
    }


    /**
     * Sets the info value for this OperationStateResponse.
     * 
     * @param info
     */
    public void setInfo(com.roboxchange.merchant.WebService.OperationInfo info) {
        this.info = info;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OperationStateResponse)) return false;
        OperationStateResponse other = (OperationStateResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.info==null && other.getInfo()==null) || 
             (this.info!=null &&
              this.info.equals(other.getInfo())));
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
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getInfo() != null) {
            _hashCode += getInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OperationStateResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationStateResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "State"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationState"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("info");
        elemField.setXmlName(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "Info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://merchant.roboxchange.com/WebService/", "OperationInfo"));
        elemField.setMinOccurs(0);
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
