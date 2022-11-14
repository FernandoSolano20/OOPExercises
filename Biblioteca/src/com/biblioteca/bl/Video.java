package com.biblioteca.bl;

import java.time.LocalDate;
import java.util.Objects;

public class Video extends Multimedia {
    private String director;

    public Video(int signatura, LocalDate fechaCompra, boolean restrigido, String tema, String formato, int duracion, String idioma, String director) {
        super(signatura, fechaCompra, restrigido, tema, formato, duracion, idioma);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Video{" +
                "'" + super.toString() + '\'' +
                "director='" + director + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof Video) return false;
        Video video = (Video) o;
        return super.equals(video);
    }
}
