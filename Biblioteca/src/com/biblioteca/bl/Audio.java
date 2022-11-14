package com.biblioteca.bl;

import java.time.LocalDate;

public class Audio extends Multimedia {
    public Audio(int signatura, LocalDate fechaCompra, boolean restrigido, String tema, String formato, int duracion, String idioma) {
        super(signatura, fechaCompra, restrigido, tema, formato, duracion, idioma);
    }

    @Override
    public String toString() {
        return "Audio{ " + super.toString() + "}";
    }
}
