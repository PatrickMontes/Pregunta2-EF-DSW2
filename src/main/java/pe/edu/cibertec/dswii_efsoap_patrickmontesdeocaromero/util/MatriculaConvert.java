package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Curso;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Estudiante;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Matricula;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Profesor;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.CursoRepository;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.EstudianteRepository;
import pe.edu.cibertec.ws.objects.MatriculaWs;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MatriculaConvert {

    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public Matricula mapToMatricula(MatriculaWs matriculaWs) {
        Matricula matricula = new Matricula();
        matricula.setId(matriculaWs.getId());

        Estudiante estudiante = estudianteRepository.findById(matriculaWs.getEstudianteId()).orElseThrow(
                () -> new RuntimeException("Estudiante no encontrado"));

        Curso curso = cursoRepository.findById(matriculaWs.getCursoId()).orElseThrow(
                () -> new RuntimeException("Curso no encontrado"));

        matricula.setEstudiante(estudiante);
        matricula.setCurso(curso);

        return matricula;
    }

    public MatriculaWs mapToMatriculaWs(Matricula matricula) {
        MatriculaWs matriculaWs = new MatriculaWs();
        matriculaWs.setId(matricula.getId());
        matriculaWs.setEstudianteId(matricula.getEstudiante().getId());
        matriculaWs.setCursoId(matricula.getCurso().getId());
        return matriculaWs;
    }

    public List<Matricula> mapToMatriculaList(List<MatriculaWs> matriculaWsList) {
        List<Matricula> matriculaList = new ArrayList<>();
        for (MatriculaWs matriculaWs : matriculaWsList) {
            matriculaList.add(mapToMatricula(matriculaWs));
        }
        return matriculaList;
    }

    public List<MatriculaWs> mapToMatriculaWsList(List<Matricula> matriculaList) {
        List<MatriculaWs> matriculaWsList = new ArrayList<>();
        for (Matricula matricula : matriculaList) {
            matriculaWsList.add(mapToMatriculaWs(matricula));
        }
        return matriculaWsList;
    }

}
