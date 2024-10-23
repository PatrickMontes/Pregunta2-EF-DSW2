package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces;

import pe.edu.cibertec.ws.objects.*;

public interface IEstudianteService {

    GetEstudiantesResponse getEstudiantes();
    GetEstudianteResponse getEstudiantePorId(int id);
    PostEstudianteResponse registrarEstudiante(PostEstudianteRequest request);
    PutEstudianteResponse actualizarEstudiante(PutEstudianteRequest request);

}
