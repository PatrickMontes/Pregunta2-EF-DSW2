package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Curso;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.CursoRepository;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces.ICursoService;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.util.CursoConvert;
import pe.edu.cibertec.ws.objects.*;

@Service
@RequiredArgsConstructor
public class CursoService implements ICursoService {

    private final CursoRepository cursoRepository;
    private final CursoConvert cursoConvert;

    @Override
    public GetCursosResponse getCursos() {
        GetCursosResponse getCursosResponse = new GetCursosResponse();
        getCursosResponse.getCursos().addAll(
                cursoConvert.mapToCursoWsList(cursoRepository.findAll())
        );

        return getCursosResponse;
    }

    @Override
    public GetCursoResponse getCursoPorId(int id) {
        GetCursoResponse getCursoResponse = new GetCursoResponse();
        Curso curso = cursoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Curso no encontrado"));

        getCursoResponse.setCurso(
                cursoConvert.mapToCursoWs(curso)
        );
        return getCursoResponse;
    }

    @Override
    public PostCursoResponse registrarCurso(PostCursoRequest request) {
        PostCursoResponse  postCursoResponse = new PostCursoResponse();
        Curso curso = cursoRepository.save(
                cursoConvert.mapToCurso(request.getCurso())
        );

        postCursoResponse.setCurso(
                cursoConvert.mapToCursoWs(curso)
        );

        return postCursoResponse;
    }

    @Override
    public PutCursoResponse actualizarCurso(PutCursoRequest request) {
        PutCursoResponse putCursoResponse = new PutCursoResponse();

        Curso cursoExistente = cursoRepository.findById(request.getCurso().getId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Curso cursoActualizado = cursoConvert.mapToCurso(request.getCurso());
        cursoActualizado.setId(cursoExistente.getId());

        Curso cursoGuardado = cursoRepository.save(cursoActualizado);

        putCursoResponse.setCurso(cursoConvert.mapToCursoWs(cursoGuardado));
        return putCursoResponse;
    }
}
