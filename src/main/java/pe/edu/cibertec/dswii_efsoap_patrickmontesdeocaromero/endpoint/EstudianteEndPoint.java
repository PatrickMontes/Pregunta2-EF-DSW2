package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces.IEstudianteService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class EstudianteEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IEstudianteService estudianteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstudiantesRequest")
    @ResponsePayload
    public GetEstudiantesResponse getEstudiantes(@RequestPayload GetEstudiantesRequest request) {
        return estudianteService.getEstudiantes();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEstudianteRequest")
    @ResponsePayload
    public GetEstudianteResponse getEstudiantePorId(@RequestPayload GetEstudianteRequest request) {
        return estudianteService.getEstudiantePorId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postEstudianteRequest")
    @ResponsePayload
    public PostEstudianteResponse registrarEstudiante(@RequestPayload PostEstudianteRequest request) {
        return estudianteService.registrarEstudiante(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putEstudianteRequest")
    @ResponsePayload
    public PutEstudianteResponse actualizarEstudiante(@RequestPayload PutEstudianteRequest request) {
        return estudianteService.actualizarEstudiante(request);
    }
}
