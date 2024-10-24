package com.cibertec.servicio;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cibertec.model.Paciente;
import com.cibertec.repository.PacienteRepository;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class PacienteServicio {
	@Autowired
	private PacienteRepository pacienteRepository;

    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
    
    public String generarConstanciaPDF(Paciente paciente) throws Exception {
        File file = new ClassPathResource("constanciaApellido.jasper").getFile();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre", paciente.getNombre());
        parameters.put("apellido", paciente.getApellido());
        parameters.put("direccion", paciente.getDireccion());
        parameters.put("numero", paciente.getNumero());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(List.of(paciente));

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String filePath = "constancia_" + paciente.getApellido() + ".pdf"; 
        JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(filePath));

        return filePath; 
    }
}
