//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.22 a las 10:59:09 PM PET 
//


package pe.edu.cibertec.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para matriculaWs complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="matriculaWs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="estudianteId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cursoId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matriculaWs", propOrder = {
    "id",
    "estudianteId",
    "cursoId"
})
public class MatriculaWs {

    protected int id;
    protected int estudianteId;
    protected int cursoId;

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
     * Obtiene el valor de la propiedad estudianteId.
     * 
     */
    public int getEstudianteId() {
        return estudianteId;
    }

    /**
     * Define el valor de la propiedad estudianteId.
     * 
     */
    public void setEstudianteId(int value) {
        this.estudianteId = value;
    }

    /**
     * Obtiene el valor de la propiedad cursoId.
     * 
     */
    public int getCursoId() {
        return cursoId;
    }

    /**
     * Define el valor de la propiedad cursoId.
     * 
     */
    public void setCursoId(int value) {
        this.cursoId = value;
    }

}
