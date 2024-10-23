package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class MatriculaWsdlConfig {

    @Bean(name = "matriculas")
    public DefaultWsdl11Definition matriculaWsdl11Definition(XsdSchema matriculaEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MatriculasPort");
        wsdl11Definition.setLocationUri("/ws/matriculas");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.edu.pe/ws/objects");
        wsdl11Definition.setSchema(matriculaEsquema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema matriculaEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/matricula.xsd"));
    }
}
