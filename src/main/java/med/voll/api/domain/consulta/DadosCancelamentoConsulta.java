package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosCancelamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data, String motivo) {
    public DadosCancelamentoConsulta(Consulta consulta, String motivo) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData(),
                motivo);
    }
}
