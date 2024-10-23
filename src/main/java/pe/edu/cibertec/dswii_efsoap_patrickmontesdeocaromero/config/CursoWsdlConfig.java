package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class CursoWsdlConfig {

    @Bean(name = "cursos")
    public DefaultWsdl11Definition cursosWsdl11Definition(XsdSchema cursoEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CursosPort");
        wsdl11Definition.setLocationUri("/ws/cursos");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(cursoEsquema);
        return wsdl11Definition;
    }


    @Bean
    public XsdSchema cursoEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/curso.xsd"));
    }
}
