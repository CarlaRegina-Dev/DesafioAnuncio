package com.carla.Anuncio.Service;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.carla.Anuncio.DTO.AnuncioDTO;
import com.carla.Anuncio.DTO.FiltroAnuncioDTO;
import com.carla.Anuncio.DTO.NovoDTO;
import com.carla.Anuncio.Util.CalcularAnuncio;
import com.carla.Anuncio.error.ResourceNotAcceptableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carla.Anuncio.Repository.AnuncioRepository;
import com.carla.Anuncio.Model.AnuncioModel;

import javax.xml.crypto.Data;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository repositorio;
    private final String MSG_ANUNCIO_INEXISTENTE = "Anuncio não existe!";
    private final String MSG_DATA_INCIO_ANTERIOR = "A Data Inicio não pode ser inferior ao cadastrado";
    private final String MSG_DATA_FIM_POSTERIOR = "A Data Fim não pode ser superior ao cadastrado";

    public List<AnuncioModel> listaAnuncio() {
        return repositorio.findAll();
    }

    public AnuncioDTO getAnuncio(FiltroAnuncioDTO filtroAnuncioDTO) {
        AnuncioModel anuncioModel = repositorio.findByCliente(filtroAnuncioDTO.getCliente());
        CalcularAnuncio caulcularAnuncio = new CalcularAnuncio();
        caulcularAnuncio.validarData(filtroAnuncioDTO);
        validarData(filtroAnuncioDTO, anuncioModel);
        return visualizacao(anuncioModel, filtroAnuncioDTO);
    }

    public AnuncioModel cadastrarAnuncio(AnuncioModel anuncio) {
        AnuncioModel retornoAnuncio = repositorio.save(anuncio);
        return retornoAnuncio;
    }

    public AnuncioModel atualizarAnuncio(AnuncioModel anuncio) {
        if (!repositorio.existsById(anuncio.getId())) {
            throw new ResourceNotAcceptableException(MSG_ANUNCIO_INEXISTENTE);
        }
        AnuncioModel retornoAnuncio = repositorio.save(anuncio);
        return retornoAnuncio;
    }

    public Boolean apagarAnuncio(Long id) {

        Boolean retorno = Boolean.FALSE;
        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            retorno = Boolean.TRUE;
        }
        return retorno;

    }

    public AnuncioDTO visualizacao(AnuncioModel anuncio, FiltroAnuncioDTO filtroAnuncioDTO) {
        Integer visualizacaoIniciao = 0;
        Integer visualizacaoFinal = 0;
        Integer dias = 0;
        Double totalInvestimeto = 0.0;

        AnuncioDTO anuncioDTO = new AnuncioDTO();

        CalcularAnuncio caulcularAnuncio = new CalcularAnuncio();

        dias = caulcularAnuncio.diferencaoDias(filtroAnuncioDTO.getDataInicio(), filtroAnuncioDTO.getDataTermino());

        totalInvestimeto = caulcularAnuncio.valorTotalInvestimento(anuncio.getInvestimento(), dias);
        visualizacaoIniciao = caulcularAnuncio.calcularPessoasAnuncioOriginal(totalInvestimeto).intValue();
        visualizacaoFinal = caulcularAnuncio.calcularPessoasAnuncioOriginal(totalInvestimeto).intValue();

        anuncioDTO.setQuantidadeMaximaCliques(caulcularAnuncio.calcularPessoasClicam(visualizacaoFinal));
        anuncioDTO.setQuantidadeMaximaCompartilhamento(caulcularAnuncio.calcularPessoasCompartilha(anuncioDTO.getQuantidadeMaximaCliques()));
        anuncioDTO.setQuantidadeMaximaVisualizacao(caulcularAnuncio.calcularPessoasVisualizacaoFinal(anuncioDTO.getQuantidadeMaximaCompartilhamento()));
        anuncioDTO.setQuantidadeMaximaVisualizacao(anuncioDTO.getQuantidadeMaximaVisualizacao() + visualizacaoIniciao);

        NovoDTO dto = new NovoDTO();
        dto.setCliente(anuncio.getCliente());
        anuncioDTO.setAnuncio(dto);
        anuncioDTO.setValorTotalInvestido(totalInvestimeto);


        return anuncioDTO;
    }
    public void validarData(FiltroAnuncioDTO filtroAnuncioDTO,AnuncioModel anuncioModel) {
        if (filtroAnuncioDTO.getDataInicio().isBefore(anuncioModel.getDataInicio())) {
            throw new ResourceNotAcceptableException(MSG_DATA_INCIO_ANTERIOR);
        }
        if (filtroAnuncioDTO.getDataTermino().isAfter(anuncioModel.getDataTermino())) {
            throw new ResourceNotAcceptableException(MSG_DATA_FIM_POSTERIOR);
        }
    }

}
