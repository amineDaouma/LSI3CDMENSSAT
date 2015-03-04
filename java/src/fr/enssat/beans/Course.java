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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
 *         &lt;element ref="{}courseName"/>
 *         &lt;element ref="{}courseCode"/>
 *         &lt;element ref="{}courseDescription"/>
 *         &lt;element ref="{}level"/>
 *         &lt;element ref="{}teachingTerm" minOccurs="0"/>
 *         &lt;element ref="{}credits" minOccurs="0"/>
 *         &lt;element ref="{}learningObjectives" minOccurs="0"/>
 *         &lt;element ref="{}recommendedPrerequisites" minOccurs="0"/>
 *         &lt;element ref="{}formalPrerequisites" minOccurs="0"/>
 *         &lt;element ref="{}teachingPlace"/>
 *         &lt;element ref="{}syllabus" minOccurs="0"/>
 *         &lt;element ref="{}teachingActivity" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="ident" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "courseName",
    "courseCode",
    "courseDescription",
    "level",
    "teachingTerm",
    "credits",
    "learningObjectives",
    "recommendedPrerequisites",
    "formalPrerequisites",
    "teachingPlace",
    "syllabus",
    "teachingActivity"
})
@XmlRootElement(name = "course")
@Entity(name = "Course")
@Table(name = "COURSE")
@Inheritance(strategy = InheritanceType.JOINED)
public class Course
    implements Equals, HashCode
{

    @XmlElement(required = true)
    protected Text courseName;
    @XmlElement(required = true)
    protected CourseCode courseCode;
    @XmlElement(required = true)
    protected CourseDescription courseDescription;
    @XmlElement(required = true)
    protected String level;
    protected String teachingTerm;
    protected Credits credits;
    protected LearningObjectives learningObjectives;
    protected RecommendedPrerequisites recommendedPrerequisites;
    protected FormalPrerequisites formalPrerequisites;
    @XmlElement(required = true)
    protected TeachingPlace teachingPlace;
    protected Syllabus syllabus;
    protected TeachingActivity teachingActivity;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String id;
    @XmlAttribute(name = "ident", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String ident;
    @XmlTransient
    protected Long hjid;

    /**
     * Gets the value of the courseName property.
     * 
     * @return
     *     possible object is
     *     {@link Text }
     *     
     */
    @ManyToOne(targetEntity = Text.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "COURSENAME_COURSE_HJID")
    public Text getCourseName() {
        return courseName;
    }

    /**
     * Sets the value of the courseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link Text }
     *     
     */
    public void setCourseName(Text value) {
        this.courseName = value;
    }

    /**
     * Gets the value of the courseCode property.
     * 
     * @return
     *     possible object is
     *     {@link CourseCode }
     *     
     */
    @ManyToOne(targetEntity = CourseCode.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "COURSECODE_COURSE_HJID")
    public CourseCode getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the value of the courseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseCode }
     *     
     */
    public void setCourseCode(CourseCode value) {
        this.courseCode = value;
    }

    /**
     * Gets the value of the courseDescription property.
     * 
     * @return
     *     possible object is
     *     {@link CourseDescription }
     *     
     */
    @ManyToOne(targetEntity = CourseDescription.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "COURSEDESCRIPTION_COURSE_HJID")
    public CourseDescription getCourseDescription() {
        return courseDescription;
    }

    /**
     * Sets the value of the courseDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseDescription }
     *     
     */
    public void setCourseDescription(CourseDescription value) {
        this.courseDescription = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "LEVEL_", length = 255)
    public String getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevel(String value) {
        this.level = value;
    }

    /**
     * Gets the value of the teachingTerm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "TEACHINGTERM", length = 255)
    public String getTeachingTerm() {
        return teachingTerm;
    }

    /**
     * Sets the value of the teachingTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeachingTerm(String value) {
        this.teachingTerm = value;
    }

    /**
     * Gets the value of the credits property.
     * 
     * @return
     *     possible object is
     *     {@link Credits }
     *     
     */
    @ManyToOne(targetEntity = Credits.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "CREDITS_COURSE_HJID")
    public Credits getCredits() {
        return credits;
    }

    /**
     * Sets the value of the credits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credits }
     *     
     */
    public void setCredits(Credits value) {
        this.credits = value;
    }

    /**
     * Gets the value of the learningObjectives property.
     * 
     * @return
     *     possible object is
     *     {@link LearningObjectives }
     *     
     */
    @ManyToOne(targetEntity = LearningObjectives.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "LEARNINGOBJECTIVES_COURSE_HJ_0")
    public LearningObjectives getLearningObjectives() {
        return learningObjectives;
    }

    /**
     * Sets the value of the learningObjectives property.
     * 
     * @param value
     *     allowed object is
     *     {@link LearningObjectives }
     *     
     */
    public void setLearningObjectives(LearningObjectives value) {
        this.learningObjectives = value;
    }

    /**
     * Gets the value of the recommendedPrerequisites property.
     * 
     * @return
     *     possible object is
     *     {@link RecommendedPrerequisites }
     *     
     */
    @ManyToOne(targetEntity = RecommendedPrerequisites.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "RECOMMENDEDPREREQUISITES_COU_0")
    public RecommendedPrerequisites getRecommendedPrerequisites() {
        return recommendedPrerequisites;
    }

    /**
     * Sets the value of the recommendedPrerequisites property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecommendedPrerequisites }
     *     
     */
    public void setRecommendedPrerequisites(RecommendedPrerequisites value) {
        this.recommendedPrerequisites = value;
    }

    /**
     * Gets the value of the formalPrerequisites property.
     * 
     * @return
     *     possible object is
     *     {@link FormalPrerequisites }
     *     
     */
    @ManyToOne(targetEntity = FormalPrerequisites.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "FORMALPREREQUISITES_COURSE_H_0")
    public FormalPrerequisites getFormalPrerequisites() {
        return formalPrerequisites;
    }

    /**
     * Sets the value of the formalPrerequisites property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormalPrerequisites }
     *     
     */
    public void setFormalPrerequisites(FormalPrerequisites value) {
        this.formalPrerequisites = value;
    }

    /**
     * Gets the value of the teachingPlace property.
     * 
     * @return
     *     possible object is
     *     {@link TeachingPlace }
     *     
     */
    @ManyToOne(targetEntity = TeachingPlace.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "TEACHINGPLACE_COURSE_HJID")
    public TeachingPlace getTeachingPlace() {
        return teachingPlace;
    }

    /**
     * Sets the value of the teachingPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingPlace }
     *     
     */
    public void setTeachingPlace(TeachingPlace value) {
        this.teachingPlace = value;
    }

    /**
     * Gets the value of the syllabus property.
     * 
     * @return
     *     possible object is
     *     {@link Syllabus }
     *     
     */
    @ManyToOne(targetEntity = Syllabus.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "SYLLABUS_COURSE_HJID")
    public Syllabus getSyllabus() {
        return syllabus;
    }

    /**
     * Sets the value of the syllabus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Syllabus }
     *     
     */
    public void setSyllabus(Syllabus value) {
        this.syllabus = value;
    }

    /**
     * Gets the value of the teachingActivity property.
     * 
     * @return
     *     possible object is
     *     {@link TeachingActivity }
     *     
     */
    @ManyToOne(targetEntity = TeachingActivity.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "TEACHINGACTIVITY_COURSE_HJID")
    public TeachingActivity getTeachingActivity() {
        return teachingActivity;
    }

    /**
     * Sets the value of the teachingActivity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeachingActivity }
     *     
     */
    public void setTeachingActivity(TeachingActivity value) {
        this.teachingActivity = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "ID", length = 255)
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the ident property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Basic
    @Column(name = "IDENT", length = 255)
    public String getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdent(String value) {
        this.ident = value;
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
        if (!(object instanceof Course)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Course that = ((Course) object);
        {
            Text lhsCourseName;
            lhsCourseName = this.getCourseName();
            Text rhsCourseName;
            rhsCourseName = that.getCourseName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "courseName", lhsCourseName), LocatorUtils.property(thatLocator, "courseName", rhsCourseName), lhsCourseName, rhsCourseName)) {
                return false;
            }
        }
        {
            CourseCode lhsCourseCode;
            lhsCourseCode = this.getCourseCode();
            CourseCode rhsCourseCode;
            rhsCourseCode = that.getCourseCode();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "courseCode", lhsCourseCode), LocatorUtils.property(thatLocator, "courseCode", rhsCourseCode), lhsCourseCode, rhsCourseCode)) {
                return false;
            }
        }
        {
            CourseDescription lhsCourseDescription;
            lhsCourseDescription = this.getCourseDescription();
            CourseDescription rhsCourseDescription;
            rhsCourseDescription = that.getCourseDescription();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "courseDescription", lhsCourseDescription), LocatorUtils.property(thatLocator, "courseDescription", rhsCourseDescription), lhsCourseDescription, rhsCourseDescription)) {
                return false;
            }
        }
        {
            String lhsLevel;
            lhsLevel = this.getLevel();
            String rhsLevel;
            rhsLevel = that.getLevel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "level", lhsLevel), LocatorUtils.property(thatLocator, "level", rhsLevel), lhsLevel, rhsLevel)) {
                return false;
            }
        }
        {
            String lhsTeachingTerm;
            lhsTeachingTerm = this.getTeachingTerm();
            String rhsTeachingTerm;
            rhsTeachingTerm = that.getTeachingTerm();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "teachingTerm", lhsTeachingTerm), LocatorUtils.property(thatLocator, "teachingTerm", rhsTeachingTerm), lhsTeachingTerm, rhsTeachingTerm)) {
                return false;
            }
        }
        {
            Credits lhsCredits;
            lhsCredits = this.getCredits();
            Credits rhsCredits;
            rhsCredits = that.getCredits();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "credits", lhsCredits), LocatorUtils.property(thatLocator, "credits", rhsCredits), lhsCredits, rhsCredits)) {
                return false;
            }
        }
        {
            LearningObjectives lhsLearningObjectives;
            lhsLearningObjectives = this.getLearningObjectives();
            LearningObjectives rhsLearningObjectives;
            rhsLearningObjectives = that.getLearningObjectives();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "learningObjectives", lhsLearningObjectives), LocatorUtils.property(thatLocator, "learningObjectives", rhsLearningObjectives), lhsLearningObjectives, rhsLearningObjectives)) {
                return false;
            }
        }
        {
            RecommendedPrerequisites lhsRecommendedPrerequisites;
            lhsRecommendedPrerequisites = this.getRecommendedPrerequisites();
            RecommendedPrerequisites rhsRecommendedPrerequisites;
            rhsRecommendedPrerequisites = that.getRecommendedPrerequisites();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "recommendedPrerequisites", lhsRecommendedPrerequisites), LocatorUtils.property(thatLocator, "recommendedPrerequisites", rhsRecommendedPrerequisites), lhsRecommendedPrerequisites, rhsRecommendedPrerequisites)) {
                return false;
            }
        }
        {
            FormalPrerequisites lhsFormalPrerequisites;
            lhsFormalPrerequisites = this.getFormalPrerequisites();
            FormalPrerequisites rhsFormalPrerequisites;
            rhsFormalPrerequisites = that.getFormalPrerequisites();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "formalPrerequisites", lhsFormalPrerequisites), LocatorUtils.property(thatLocator, "formalPrerequisites", rhsFormalPrerequisites), lhsFormalPrerequisites, rhsFormalPrerequisites)) {
                return false;
            }
        }
        {
            TeachingPlace lhsTeachingPlace;
            lhsTeachingPlace = this.getTeachingPlace();
            TeachingPlace rhsTeachingPlace;
            rhsTeachingPlace = that.getTeachingPlace();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "teachingPlace", lhsTeachingPlace), LocatorUtils.property(thatLocator, "teachingPlace", rhsTeachingPlace), lhsTeachingPlace, rhsTeachingPlace)) {
                return false;
            }
        }
        {
            Syllabus lhsSyllabus;
            lhsSyllabus = this.getSyllabus();
            Syllabus rhsSyllabus;
            rhsSyllabus = that.getSyllabus();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "syllabus", lhsSyllabus), LocatorUtils.property(thatLocator, "syllabus", rhsSyllabus), lhsSyllabus, rhsSyllabus)) {
                return false;
            }
        }
        {
            TeachingActivity lhsTeachingActivity;
            lhsTeachingActivity = this.getTeachingActivity();
            TeachingActivity rhsTeachingActivity;
            rhsTeachingActivity = that.getTeachingActivity();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "teachingActivity", lhsTeachingActivity), LocatorUtils.property(thatLocator, "teachingActivity", rhsTeachingActivity), lhsTeachingActivity, rhsTeachingActivity)) {
                return false;
            }
        }
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            String lhsIdent;
            lhsIdent = this.getIdent();
            String rhsIdent;
            rhsIdent = that.getIdent();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "ident", lhsIdent), LocatorUtils.property(thatLocator, "ident", rhsIdent), lhsIdent, rhsIdent)) {
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
            Text theCourseName;
            theCourseName = this.getCourseName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "courseName", theCourseName), currentHashCode, theCourseName);
        }
        {
            CourseCode theCourseCode;
            theCourseCode = this.getCourseCode();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "courseCode", theCourseCode), currentHashCode, theCourseCode);
        }
        {
            CourseDescription theCourseDescription;
            theCourseDescription = this.getCourseDescription();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "courseDescription", theCourseDescription), currentHashCode, theCourseDescription);
        }
        {
            String theLevel;
            theLevel = this.getLevel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "level", theLevel), currentHashCode, theLevel);
        }
        {
            String theTeachingTerm;
            theTeachingTerm = this.getTeachingTerm();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "teachingTerm", theTeachingTerm), currentHashCode, theTeachingTerm);
        }
        {
            Credits theCredits;
            theCredits = this.getCredits();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "credits", theCredits), currentHashCode, theCredits);
        }
        {
            LearningObjectives theLearningObjectives;
            theLearningObjectives = this.getLearningObjectives();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "learningObjectives", theLearningObjectives), currentHashCode, theLearningObjectives);
        }
        {
            RecommendedPrerequisites theRecommendedPrerequisites;
            theRecommendedPrerequisites = this.getRecommendedPrerequisites();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "recommendedPrerequisites", theRecommendedPrerequisites), currentHashCode, theRecommendedPrerequisites);
        }
        {
            FormalPrerequisites theFormalPrerequisites;
            theFormalPrerequisites = this.getFormalPrerequisites();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "formalPrerequisites", theFormalPrerequisites), currentHashCode, theFormalPrerequisites);
        }
        {
            TeachingPlace theTeachingPlace;
            theTeachingPlace = this.getTeachingPlace();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "teachingPlace", theTeachingPlace), currentHashCode, theTeachingPlace);
        }
        {
            Syllabus theSyllabus;
            theSyllabus = this.getSyllabus();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "syllabus", theSyllabus), currentHashCode, theSyllabus);
        }
        {
            TeachingActivity theTeachingActivity;
            theTeachingActivity = this.getTeachingActivity();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "teachingActivity", theTeachingActivity), currentHashCode, theTeachingActivity);
        }
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theIdent;
            theIdent = this.getIdent();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "ident", theIdent), currentHashCode, theIdent);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

}
