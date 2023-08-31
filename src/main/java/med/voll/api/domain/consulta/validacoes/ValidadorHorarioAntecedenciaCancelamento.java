package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaCancelamento implements ValidadorCancelamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosConsulta dados){
        var consulta = repository.findById(dados.id()).get();
        var dataConsulta = consulta.getData();

        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toHours();

        if (diferencaEmMinutos < 24){
            throw new ValidacaoException("Consulta deve ser cancelada com antecedência mínima de 24 horas!");
        }
    }
}
