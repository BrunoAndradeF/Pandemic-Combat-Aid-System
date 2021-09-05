package com.bruno.pandemiccombataidsystem.service;

import com.bruno.pandemiccombataidsystem.DTO.FormularioTrocaRecursosDTO;
import com.bruno.pandemiccombataidsystem.DTO.HospitalDTO;
import com.bruno.pandemiccombataidsystem.model.Recurso;
import com.bruno.pandemiccombataidsystem.repository.RecursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoServiceImpl implements RecursoService {

    static final int PONTUACAO_MEDICO=3;
    static final int PONTUACAO_ENFERMEIRO=3;
    static final int PONTUACAO_RESPIRADOR=5;
    static final int PONTUACAO_AMBULANCIA=10;
    static final int PONTUACAO_TOMOGRAFO=12;

    @Autowired
    RecursosRepository recursosRepository;

    @Override
    /**
     * retorna a entidade Recurso associada ao hospital com o cnpj passado como parametro
     */
    public Optional<Recurso> getRecursoByCNPJ(long cnpj) {
        return recursosRepository.findByCnpj(cnpj);
    }

    @Override
    /**
     * salva a entidade Recurso passada como parametro, no repositorio
     */
    public void salvaRegistroRecurso(Recurso recurso) {
        recursosRepository.save(recurso);
    }

    @Override
    /**
     * apaga a entidade recurso passado como parametro, do repositorio
     */
    public void apagaRegistroRecurso(Recurso recurso) {
        recursosRepository.delete(recurso);
    }

    @Override
    /**
     * Cria e retorna uma entidade recurso
     */
    public Recurso criaRecurso(HospitalDTO hospitalDTO) {
        return new Recurso(hospitalDTO.getCnpj(), hospitalDTO.getQuantidadeMedicos(),
                hospitalDTO.getQuantidadeRespiradores(), hospitalDTO.getQuantidadeTomografos(),
                hospitalDTO.getQuantidadeAmbulancias(), hospitalDTO.getQuantidadeEnfermeiros());
    }

    @Override
    /**
     * lista todas as entidades Recurso cadastradas
     */
    public List<Recurso> listaRecursos() {
        return recursosRepository.findAll();
    }

    @Override
    /**
     * troca recursos oferecidos entre os hospitais passados como parametro
     */
    public boolean trocaRecursos(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, Integer percentual1,
                                   FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2, Integer percentual2) {
        int totalPontos1 = getTotalPontosForm(formularioTrocaRecursosDTO1);
        int totalPontos2 = getTotalPontosForm(formularioTrocaRecursosDTO2);

        Boolean trocaRealizada=false;

        if(totalPontos1==totalPontos2) {
                realizaTroca(formularioTrocaRecursosDTO1,formularioTrocaRecursosDTO2);
                trocaRealizada=true;
        } else if (totalPontos1>totalPontos2){
            if(percentual2 > 90) {
                realizaTroca(formularioTrocaRecursosDTO1,formularioTrocaRecursosDTO2);
                trocaRealizada=true;
            }
        } else {
            if(percentual1 > 90) {
                realizaTroca(formularioTrocaRecursosDTO1,formularioTrocaRecursosDTO2);
                trocaRealizada=true;
            }
        }
        return trocaRealizada;
    }

    @Override
    /**
     * calcula e retorna a media entre os hospitais de certo recurso
     */
    public Double mediaRecurso(String recurso) {
        List<Recurso> listaGeral = recursosRepository.findAll();
        if(listaGeral.size()==0) return Double.valueOf(0);
        double montante = 0;

        switch (recurso.toLowerCase().strip()) {
            case "medico":
                montante += filtraRecursoMedico(listaGeral);
                break;
            case "enfermeiro":
                montante += filtraRecursoEnfermeiro(listaGeral);
                break;
            case "respirador":
                montante += filtraRecursoRespirador(listaGeral);
                break;
            case "ambulancia":
                montante += filtraRecursoAmbulancia(listaGeral);
                break;
            case "tomografo":
                montante += filtraRecursoTomografo(listaGeral);
                break;
            default:
                return Double.valueOf(0);
        }
        return (montante/(double) listaGeral.size());
    }

    /**
     * calcula o montante de tomografos entre todos os hospitais
     * @param lista lista com todos recursos cadastrados
     * @return soma de todos os tomografos cadastrados
     */
    private double filtraRecursoTomografo(List<Recurso> lista) {
        double montante=0;
        for (Recurso recurso: lista) {
            montante+=recurso.getQuantidadeTomografos();
        }
        return montante;
    }

    /**
     * calcula o montante de ambulancias entre todos os hospitais
     * @param lista lista com todos recursos cadastrados
     * @return soma de todos os ambulancias cadastrados
     */
    private double filtraRecursoAmbulancia(List<Recurso> lista) {
        double montante=0;
        for (Recurso recurso: lista) {
            montante+=recurso.getQuantidadeAmbulancias();
        }
        return montante;
    }

    /**
     * calcula o montante de respiradores entre todos os hospitais
     * @param lista lista com todos recursos cadastrados
     * @return soma de todos os respiradores cadastrados
     */
    private double filtraRecursoRespirador(List<Recurso> lista) {
        double montante=0;
        for (Recurso recurso: lista) {
            montante+=recurso.getQuantidadeRespiradores();
        }
        return montante;
    }

    /**
     * calcula o montante de enfermeiros entre todos os hospitais
     * @param lista lista com todos recursos cadastrados
     * @return soma de todos os enfermeiros cadastrados
     */
    private double filtraRecursoEnfermeiro(List<Recurso> lista) {
        double montante=0;
        for (Recurso recurso: lista) {
            montante+=recurso.getQuantidadeEnfermeiros();
        }
        return montante;
    }

    /**
     * calcula o montante de medicos entre todos os hospitais
     * @param lista lista com todos recursos cadastrados
     * @return soma de todos os medicos cadastrados
     */
    private double filtraRecursoMedico(List<Recurso> lista) {
        double montante=0;
        for (Recurso recurso: lista) {
            montante+=recurso.getQuantidadeMedicos();
        }
        return montante;
    }

    /**
     * calcula o total de pontos de um formulario para troca de recursos
     * @param formularioTrocaRecursosDTO formulario de troca de recursos
     * @return total de pontos no formulario
     */
    private int getTotalPontosForm(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO) {
        return formularioTrocaRecursosDTO.getQuantidadeAmbulancias() * PONTUACAO_AMBULANCIA
                + formularioTrocaRecursosDTO.getQuantidadeMedicos() * PONTUACAO_MEDICO
                + formularioTrocaRecursosDTO.getQuantidadeRespiradores() * PONTUACAO_RESPIRADOR
                + formularioTrocaRecursosDTO.getQuantidadeTomografos() * PONTUACAO_TOMOGRAFO
                + formularioTrocaRecursosDTO.getQuantidadeEnfermeiros() * PONTUACAO_ENFERMEIRO;
    }

    /**
     * realiza troca entre dos hospitais
     * @param formularioTrocaRecursosDTO1 formulario de troca do hospital 1
     * @param formularioTrocaRecursosDTO2 formulario de troca do hospital 2
     */
    private void realizaTroca(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2) {

        atualizaRecursos(formularioTrocaRecursosDTO1 ,formularioTrocaRecursosDTO2);
        atualizaRecursos(formularioTrocaRecursosDTO2, formularioTrocaRecursosDTO1);
    }

    /**
     * atualiza os recursos de um hospital, removendo o oferecido na troca e adicionando ofertado
     * @param formularioTrocaRecursosDTO1 formulario de troca do proprio hospital
     * @param formularioTrocaRecursosDTO2 formulario de troca de outro hospital
     */
    private void atualizaRecursos(FormularioTrocaRecursosDTO formularioTrocaRecursosDTO1, FormularioTrocaRecursosDTO formularioTrocaRecursosDTO2) {
        Recurso recursos1 = recursosRepository.findByCnpj(formularioTrocaRecursosDTO1.getCnpj()).get();
        Recurso recursos2 = recursosRepository.findByCnpj(formularioTrocaRecursosDTO2.getCnpj()).get();


        recursos1.setQuantidadeMedicos(recursos1.getQuantidadeMedicos() + formularioTrocaRecursosDTO2.getQuantidadeMedicos()
                - formularioTrocaRecursosDTO1.getQuantidadeMedicos());

        recursos1.setQuantidadeEnfermeiros(recursos1.getQuantidadeEnfermeiros() + formularioTrocaRecursosDTO2.getQuantidadeEnfermeiros()
                - formularioTrocaRecursosDTO1.getQuantidadeEnfermeiros());

        recursos1.setQuantidadeAmbulancias(recursos1.getQuantidadeAmbulancias() + formularioTrocaRecursosDTO2.getQuantidadeAmbulancias()
                - formularioTrocaRecursosDTO1.getQuantidadeAmbulancias());

        recursos1.setQuantidadeRespiradores(recursos1.getQuantidadeRespiradores() + formularioTrocaRecursosDTO2.getQuantidadeRespiradores()
                - formularioTrocaRecursosDTO1.getQuantidadeRespiradores());

        recursos1.setQuantidadeTomografos(recursos1.getQuantidadeTomografos() + formularioTrocaRecursosDTO2.getQuantidadeTomografos()
                - formularioTrocaRecursosDTO1.getQuantidadeTomografos());
    }
}
