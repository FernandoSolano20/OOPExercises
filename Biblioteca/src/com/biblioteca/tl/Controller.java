package com.biblioteca.tl;

import com.biblioteca.bl.*;

import java.time.LocalDate;
import java.util.List;

public class Controller {
    private BL logic = new BL();
    public String registrarTexto(int signatura, int dia, int mes, int year, boolean restringido, String tema, String titulo, String autor, int diaPublica, int mesPublica, int yearPublica, int numeroPaginas, String idioma) {
        Textos textos = new Textos(signatura, LocalDate.of(year,mes,dia), restringido,tema,titulo,autor, LocalDate.of(yearPublica,mesPublica,diaPublica),numeroPaginas,idioma);
        return logic.registrarMaterial(textos);
    }

    public String registrarMaterialVideo(int signatura, int dia, int mes, int year, boolean restringido, String tema, String formato, int duracion, String idioma, String director) {
        Video video = new Video(signatura, LocalDate.of(year,mes,dia), restringido,tema,formato,duracion,idioma,director);
        return logic.registrarMaterial(video);
    }

    public String registrarMaterialAudio(int signatura, int dia, int mes, int year, boolean restringido, String tema, String formato, int duracion, String idioma) {
        Audio audio = new Audio(signatura, LocalDate.of(year,mes,dia), restringido,tema,formato,duracion,idioma);
        return logic.registrarMaterial(audio);
    }

    public String registrarOtros(int signatura, int dia, int mes, int year, boolean restringido, String tema, String descripcion) {
        Otros otros = new Otros(signatura, LocalDate.of(year,mes,dia), restringido,tema,descripcion);
        return logic.registrarMaterial(otros);
    }

    public List<String> listarTexto() {
        return logic.listarTexto();
    }

    public List<String> listarMaterialVideo() {
        return logic.listarMaterialVideo();
    }

    public List<String> listarMaterialAudio() {
        return logic.listarMaterialAudio();
    }

    public List<String> listarOtros() {
        return logic.listarOtros();
    }

    public String buscarPorId(int signatura) {
        Material material = logic.buscarPorId(signatura);
        if (material != null && material instanceof Video){
            return ((Video) material).getDirector();
        }
        return "No hay datos";
    }
}
