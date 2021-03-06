//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.01.04 at 10:12:58 PM CET 
//


package fr.enssat.beans;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


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
 *         &lt;element ref="{}contactName"/>
 *         &lt;element ref="{}adr"/>
 *         &lt;element ref="{}telephone"/>
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
    "contactName",
    "adr",
    "telephone"
})
@XmlRootElement(name = "contactData")
@Entity(name = "ContactData")
@Table(name = "CONTACTDATA")
@Inheritance(strategy = InheritanceType.JOINED)
public class ContactData
    implements Equals, HashCode
{

    @XmlElement(required = true)
    protected Text contactName;
    @XmlElement(required = true)
    protected Adr adr;
    @XmlElement(required = true)
    protected String telephone;
    @XmlTransient
    protected Long hjid;

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link Text }
     *     
     */
    @ManyToOne(targetEntity = Text.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CONTACTNAME_CONTACTDATA_HJID")
    public Text getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Text }
     *     
     */
    public void setContactName(Text value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the adr property.
     * 
     * @return
     *     possible object is
     *     {@link Adr }
     *     
     */
    @ManyToOne(targetEntity = Adr.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "ADR_CONTACTDATA_HJID")
    public Adr getAdr() {
        return adr;
    }

    /**
     * Sets the value of the adr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Adr }
     *     
     */
    public void setAdr(Adr value) {
        this.adr = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "TELEPHONE", length = 255)
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephone(String value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the hjid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "HJID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getHjid() {
        return hjid;
    }

    /**
     * Sets the value of the hjid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setHjid(Long value) {
        this.hjid = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ContactData)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final ContactData that = ((ContactData) object);
        {
            Text lhsContactName;
            lhsContactName = this.getContactName();
            Text rhsContactName;
            rhsContactName = that.getContactName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "contactName", lhsContactName), LocatorUtils.property(thatLocator, "contactName", rhsContactName), lhsContactName, rhsContactName)) {
                return false;
            }
        }
        {
            Adr lhsAdr;
            lhsAdr = this.getAdr();
            Adr rhsAdr;
            rhsAdr = that.getAdr();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "adr", lhsAdr), LocatorUtils.property(thatLocator, "adr", rhsAdr), lhsAdr, rhsAdr)) {
                return false;
            }
        }
        {
            String lhsTelephone;
            lhsTelephone = this.getTelephone();
            String rhsTelephone;
            rhsTelephone = that.getTelephone();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "telephone", lhsTelephone), LocatorUtils.property(thatLocator, "telephone", rhsTelephone), lhsTelephone, rhsTelephone)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            Text theContactName;
            theContactName = this.getContactName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "contactName", theContactName), currentHashCode, theContactName);
        }
        {
            Adr theAdr;
            theAdr = this.getAdr();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "adr", theAdr), currentHashCode, theAdr);
        }
        {
            String theTelephone;
            theTelephone = this.getTelephone();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "telephone", theTelephone), currentHashCode, theTelephone);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
