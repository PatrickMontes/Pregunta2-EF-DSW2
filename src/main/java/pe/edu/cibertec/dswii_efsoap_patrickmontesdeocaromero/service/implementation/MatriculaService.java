package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Matricula;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.MatriculaRepository;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces.IMatriculaService;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.util.MatriculaConvert;
import pe.edu.cibertec.ws.objects.*;

@Service
@RequiredArgsConstructor
public class MatriculaService implements IMatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final MatriculaConvert matriculaConvert;

    @Override
    public GetMatriculasResponse getMatriculas() {
        GetMatriculasResponse response = new GetMatriculasResponse();
        response.getMatriculas().addAll(
                matriculaConvert.mapToMatriculaWsList(matriculaRepository.findAll())
        );
        return response;
    }

    @Override
    public GetMatriculaResponse getMatriculaPorId(int id) {
        GetMatriculaResponse response = new GetMatriculaResponse();
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        response.setMatricula(
                matriculaConvert.mapToMatriculaWs(matricula)
        );
        return response;
    }

    @Override
    public PostMatriculaResponse registrarMatricula(PostMatriculaRequest request) {
        PostMatriculaResponse response = new PostMatriculaResponse();
        Matricula matricula = matriculaRepository.save(
                matriculaConvert.mapToMatricula(request.getMatricula())
        );

        response.setMatricula(
                matriculaConvert.mapToMatriculaWs(matricula)
        );
        return response;
    }

    @Override
    public PutMatriculaResponse actualizarMatricula(PutMatriculaRequest request) {
        PutMatriculaResponse response = new PutMatriculaResponse();

        Matricula matriculaExistente = matriculaRepository.findById(request.getMatricula().getId())
                .orElseThrow(() -> new RuntimeException("Matrícula no encontrada"));

        Matricula matriculaActualizada = matriculaConvert.mapToMatricula(request.getMatricula());
        matriculaActualizada.setId(matriculaExistente.getId());

        Matricula matriculaGuardada = matriculaRepository.save(matriculaActualizada);

        response.setMatricula(
                matriculaConvert.mapToMatriculaWs(matriculaGuardada)
        );
        return response;
    }
}
