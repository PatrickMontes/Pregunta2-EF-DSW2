package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces;

import pe.edu.cibertec.ws.objects.*;

public interface IMatriculaService {

    GetMatriculasResponse getMatriculas();
    GetMatriculaResponse getMatriculaPorId(int id);
    PostMatriculaResponse registrarMatricula(PostMatriculaRequest request);
    PutMatriculaResponse actualizarMatricula(PutMatriculaRequest request);

}
