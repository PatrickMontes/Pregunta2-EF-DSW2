package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class EstudianteWsdlConfig {

    @Bean(name = "estudiantes")
    public DefaultWsdl11Definition estudianteWsdl11Definition(XsdSchema estudianteEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("EstudiantesPort");
        wsdl11Definition.setLocationUri("/ws/estudiantes");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(estudianteEsquema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema estudianteEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/estudiante.xsd"));
    }
}