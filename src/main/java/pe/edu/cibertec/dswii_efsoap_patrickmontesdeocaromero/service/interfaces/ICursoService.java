package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces;

import pe.edu.cibertec.ws.objects.*;

public interface ICursoService {

    GetCursosResponse getCursos();
    GetCursoResponse getCursoPorId(int id);
    PostCursoResponse registrarCurso(PostCursoRequest request);
    PutCursoResponse actualizarCurso(PutCursoRequest request);

}
