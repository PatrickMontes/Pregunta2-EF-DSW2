package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Estudiante;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.EstudianteRepository;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.service.interfaces.IEstudianteService;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.util.EstudianteConvert;
import pe.edu.cibertec.ws.objects.*;

@Service
@RequiredArgsConstructor
public class EstudianteService implements IEstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteConvert estudianteConvert;

    @Override
    public GetEstudiantesResponse getEstudiantes() {
        GetEstudiantesResponse getEstudiantesResponse = new GetEstudiantesResponse();
        getEstudiantesResponse.getEstudiantes().addAll(
                estudianteConvert.mapToEstudianteWsList(estudianteRepository.findAll())
        );
        return getEstudiantesResponse;
    }


    @Override
    public GetEstudianteResponse getEstudiantePorId(int id) {
        GetEstudianteResponse getEstudianteResponse = new GetEstudianteResponse();
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Estudiante no encontrado"));

        getEstudianteResponse.setEstudiante(
                estudianteConvert.mapToEstudianteWs(estudiante)
        );
        return getEstudianteResponse;
    }


    @Override
    public PostEstudianteResponse registrarEstudiante(PostEstudianteRequest request) {
        PostEstudianteResponse postEstudianteResponse = new PostEstudianteResponse();
        Estudiante estudiante = estudianteRepository.save(
                estudianteConvert.mapToEstudiante(request.getEstudiante())
        );

        postEstudianteResponse.setEstudiante(
                estudianteConvert.mapToEstudianteWs(estudiante)
        );

        return postEstudianteResponse;
    }

    @Override
    public PutEstudianteResponse actualizarEstudiante(PutEstudianteRequest request) {
        PutEstudianteResponse putEstudianteResponse = new PutEstudianteResponse();
        Estudiante estudiante = estudianteRepository.findById(request.getEstudiante().getId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Estudiante estudianteActualizado = estudianteConvert.mapToEstudiante(request.getEstudiante());
        estudianteActualizado.setId(estudiante.getId());

        Estudiante estudianteGuardado = estudianteRepository.save(estudianteActualizado);

        putEstudianteResponse.setEstudiante(
                estudianteConvert.mapToEstudianteWs(estudianteGuardado)
        );

        return putEstudianteResponse;
    }
}
