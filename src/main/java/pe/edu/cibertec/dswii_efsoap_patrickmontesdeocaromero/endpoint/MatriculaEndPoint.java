package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces.IMatriculaService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class MatriculaEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IMatriculaService matriculaService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMatriculasRequest")
    @ResponsePayload
    public GetMatriculasResponse getMatriculas(@RequestPayload GetMatriculasRequest request) {
        return matriculaService.getMatriculas();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMatriculaRequest")
    @ResponsePayload
    public GetMatriculaResponse getMatriculaPorId(@RequestPayload GetMatriculaRequest request) {
        return matriculaService.getMatriculaPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postMatriculaRequest")
    @ResponsePayload
    public PostMatriculaResponse registrarMatricula(@RequestPayload PostMatriculaRequest request) {
        return matriculaService.registrarMatricula(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putMatriculaRequest")
    @ResponsePayload
    public PutMatriculaResponse actualizarMatricula(@RequestPayload PutMatriculaRequest request) {
        return matriculaService.actualizarMatricula(request);
    }
}