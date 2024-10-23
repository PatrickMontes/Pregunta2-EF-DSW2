package pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.util;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_efsoap_patrickmontesdeocaromero.model.Estudiante;
import pe.edu.cibertec.ws.objects.Estudiantews;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstudianteConvert {

    public Estudiante mapToEstudiante(Estudiantews estudianteWs) {
        Estudiante estudiante = new Estudiante();
        estudiante.setId(estudianteWs.getId());
        estudiante.setNombre(estudianteWs.getNombre());
        estudiante.setApellido(estudianteWs.getApellido());
        estudiante.setCarrera(estudianteWs.getCarrera());
        estudiante.setEmail(estudianteWs.getEmail());
        return estudiante;
    }

    public Estudiantews mapToEstudianteWs(Estudiante estudiante) {
        Estudiantews estudianteWs = new Estudiantews();
        estudianteWs.setId(estudiante.getId());
        estudianteWs.setNombre(estudiante.getNombre());
        estudianteWs.setApellido(estudiante.getApellido());
        estudianteWs.setCarrera(estudiante.getCarrera());
        estudianteWs.setEmail(estudiante.getEmail());
        return estudianteWs;
    }

    public List<Estudiante> mapToEstudianteList(List<Estudiantews> estudianteWsList) {
        List<Estudiante> estudianteList = new ArrayList<>();
        for (Estudiantews estudianteWs : estudianteWsList) {
            estudianteList.add(mapToEstudiante(estudianteWs));
        }
        return estudianteList;
    }

    public List<Estudiantews> mapToEstudianteWsList(List<Estudiante> estudianteList) {
        List<Estudiantews> estudianteWsList = new ArrayList<>();
        for (Estudiante estudiante : estudianteList) {
            estudianteWsList.add(mapToEstudianteWs(estudiante));
        }
        return estudianteWsList;
    }

}
