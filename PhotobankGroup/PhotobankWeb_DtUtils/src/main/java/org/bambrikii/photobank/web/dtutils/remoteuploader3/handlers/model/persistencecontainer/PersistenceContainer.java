//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.2-hudson-jaxb-ri-2.2-63-
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2011.03.24 at 08:44:23 PM MSK
//


package org.bambrikii.photobank.web.dtutils.remoteuploader3.handlers.model.persistencecontainer;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FailedFiles" type="{http://model.handlers.remoteuploader3.dtutils.psfotos.ru.bambrikii.org/PersistenceContainer}FailedFiles" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "failedFiles"
})
@XmlRootElement(name = "PersistenceContainer")
public class PersistenceContainer {

    @XmlElement(name = "FailedFiles")
    protected List<FailedFiles> failedFiles;

    /**
     * Gets the value of the failedFiles property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the failedFiles property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFailedFiles().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FailedFiles }
     *
     *
     */
    public List<FailedFiles> getFailedFiles() {
        if (failedFiles == null) {
            failedFiles = new ArrayList<FailedFiles>();
        }
        return this.failedFiles;
    }

}