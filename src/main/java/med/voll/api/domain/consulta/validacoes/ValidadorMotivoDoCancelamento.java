package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMotivoDoCancelamento implements ValidadorCancelamentoDeConsulta{

    @Override
    public void validar(DadosConsulta dados) {
        var motivo = dados.motivo();

        if(motivo != "Paciente desistiu" || motivo != "Médico cancelou" || motivo != "Outros"){
            throw new ValidacaoException("Motivo informado é inválido, o motivo deve ser: 'Paciente desistiu', " +
                    "'Médico cancelou' ou 'Outros'!");
        }
    }
}
