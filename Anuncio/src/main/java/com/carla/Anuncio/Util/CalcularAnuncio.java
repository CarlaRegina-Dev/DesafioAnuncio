package com.carla.Anuncio.Util;

import com.carla.Anuncio.DTO.FiltroAnuncioDTO;
import com.carla.Anuncio.Model.AnuncioModel;
import com.carla.Anuncio.error.ResourceNotAcceptableException;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalcularAnuncio {

    private final String MSG_DATA_FIM_MENOR_DATA_INCIO = "A Data Fim não pode ser Menor que a Data Inicio!";



    public Integer calcularPessoasAnuncioOriginal(Double valor) {
        valor = valor * 30;
        return valor.intValue();
    }

    public Integer calcularPessoasClicam(Integer valor) {
        Integer valorPessoa = valor / 100;
        return valorPessoa * 12;
    }

    public Integer calcularPessoasCompartilha(Integer valor) {
        Integer valorPessoa = valor / 20;
        return valorPessoa * 3;
    }

    public Integer calcularPessoasVisualizacaoFinal(Integer valor) {
        Integer valorPessoa = valor * 40;
        return valorPessoa;
    }

    public Integer diferencaoDias(LocalDate dataInicioFiltro, LocalDate dataFimFiltro) {
        int dias = 0;
        dias = Integer.valueOf(dataFimFiltro.getDayOfYear() - dataInicioFiltro.getDayOfYear());
        return dias;
    }

    public Double valorTotalInvestimento(Double valor, Integer dias) {
        return valor * dias;
    }

    public void validarData(FiltroAnuncioDTO filtroAnuncioDTO) {
        if (filtroAnuncioDTO.getDataTermino().isBefore(filtroAnuncioDTO.getDataInicio())) {
            throw new ResourceNotAcceptableException(MSG_DATA_FIM_MENOR_DATA_INCIO);
        }
    }




}
