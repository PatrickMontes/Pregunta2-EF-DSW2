package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces.ICursoService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class CursoEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private ICursoService cursoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCursosRequest")
    @ResponsePayload
    public GetCursosResponse getCursos(@RequestPayload GetCursosRequest request) {
        return cursoService.getCursos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCursoRequest")
    @ResponsePayload
    public GetCursoResponse getCursoPorId(@RequestPayload GetCursoRequest request) {
        return cursoService.getCursoPorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postCursoRequest")
    @ResponsePayload
    public PostCursoResponse registrarCurso(@RequestPayload PostCursoRequest request) {
        return cursoService.registrarCurso(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putCursoRequest")
    @ResponsePayload
    public PutCursoResponse actualizarCurso(@RequestPayload PutCursoRequest request) {
        return cursoService.actualizarCurso(request);
    }
}
