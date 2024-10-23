//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.22 a las 10:59:09 PM PET 
//


package pe.edu.cibertec.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cursoWs complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cursoWs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="creditos" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="semestre" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="facultadId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="profesorId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cursoWs", propOrder = {
    "id",
    "nombre",
    "creditos",
    "semestre",
    "facultadId",
    "profesorId"
})
public class CursoWs {

    protected int id;
    @XmlElement(required = true)
    protected String nombre;
    protected int creditos;
    @XmlElement(required = true)
    protected String semestre;
    protected int facultadId;
    protected int profesorId;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad creditos.
     * 
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Define el valor de la propiedad creditos.
     * 
     */
    public void setCreditos(int value) {
        this.creditos = value;
    }

    /**
     * Obtiene el valor de la propiedad semestre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * Define el valor de la propiedad semestre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemestre(String value) {
        this.semestre = value;
    }

    /**
     * Obtiene el valor de la propiedad facultadId.
     * 
     */
    public int getFacultadId() {
        return facultadId;
    }

    /**
     * Define el valor de la propiedad facultadId.
     * 
     */
    public void setFacultadId(int value) {
        this.facultadId = value;
    }

    /**
     * Obtiene el valor de la propiedad profesorId.
     * 
     */
    public int getProfesorId() {
        return profesorId;
    }

    /**
     * Define el valor de la propiedad profesorId.
     * 
     */
    public void setProfesorId(int value) {
        this.profesorId = value;
    }

}
