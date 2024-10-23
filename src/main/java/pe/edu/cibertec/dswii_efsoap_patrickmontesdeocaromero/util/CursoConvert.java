package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Curso;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Facultad;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Profesor;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.FacultadRepository;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.repository.ProfesorRepository;
import pe.edu.cibertec.ws.objects.CursoWs;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CursoConvert {

    private final FacultadRepository facultadRepository;
    private final ProfesorRepository profesorRepository;

    public Curso mapToCurso(CursoWs cursoWs) {
        Curso curso = new Curso();
        curso.setId(cursoWs.getId());
        curso.setNombre(cursoWs.getNombre());
        curso.setCreditos(cursoWs.getCreditos());
        curso.setSemestre(cursoWs.getSemestre());

        Facultad facultad = facultadRepository.findById(cursoWs.getFacultadId())
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));

        Profesor profesor = profesorRepository.findById(cursoWs.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        curso.setFacultad(facultad);
        curso.setProfesor(profesor);
        return curso;
    }

    public CursoWs mapToCursoWs(Curso curso) {
        CursoWs cursoWs = new CursoWs();
        cursoWs.setId(curso.getId());
        cursoWs.setNombre(curso.getNombre());
        cursoWs.setCreditos(curso.getCreditos());
        cursoWs.setSemestre(curso.getSemestre());
        cursoWs.setFacultadId(curso.getFacultad().getId());
        cursoWs.setProfesorId(curso.getProfesor().getId());
        return cursoWs;
    }

    public List<Curso> mapToCursoList(List<CursoWs> cursoWsList) {
        List<Curso> cursoList = new ArrayList<>();
        for (CursoWs cursoWs : cursoWsList) {
            cursoList.add(mapToCurso(cursoWs));
        }
        return cursoList;
    }

    public List<CursoWs> mapToCursoWsList(List<Curso> cursoList) {
        List<CursoWs> cursoWsList = new ArrayList<>();
        for (Curso curso : cursoList) {
            cursoWsList.add(mapToCursoWs(curso));
        }
        return cursoWsList;
    }

}
