package com.biblioteca.bl;

import java.util.ArrayList;
import java.util.List;

public class BL {
    private ArrayList<Material> materiales = new ArrayList<>();
    public String registrarMaterial(Material material) {
        if(buscarMaterial(material.getSignatura()) == -1){
            materiales.add(material);
            return "Registrado";
        }
        return "No se registro";
    }

    public int buscarMaterial(int signatura){
        int result = -1;
        for (int i = 0; i < materiales.size(); i++){
            if (materiales.get(i).getSignatura() == signatura){
                result = i;
                break;
            }
        }
        return result;
    }

    public List<String> listarTexto() {
        ArrayList<String> result = new ArrayList<>();
        int size = materiales.size();
        if (size > 0){
            for (Material material:materiales) {
                if (material instanceof Textos){
                    result.add(material.toString());
                }
            }
            if (result.size() == 0){
                result.add("No hay materiales de texto");
            }
        }
        else {
            result.add("No hay datos");
        }
        return result;
    }

    public List<String> listarMaterialVideo() {
        ArrayList<String> result = new ArrayList<>();
        int size = materiales.size();
        if (size > 0){
            for (Material material:materiales) {
                if (material instanceof Video){
                    result.add(material.toString());
                }
            }
            if (result.size() == 0){
                result.add("No hay materiales de video");
            }
        }
        else {
            result.add("No hay datos");
        }
        return result;
    }

    public List<String> listarMaterialAudio() {
        ArrayList<String> result = new ArrayList<>();
        int size = materiales.size();
        if (size > 0){
            for (Material material:materiales) {
                if (material instanceof Audio){
                    result.add(material.toString());
                }
            }
            if (result.size() == 0){
                result.add("No hay materiales de audio");
            }
        }
        else {
            result.add("No hay datos");
        }
        return result;
    }

    public List<String> listarOtros() {
        ArrayList<String> result = new ArrayList<>();
        int size = materiales.size();
        if (size > 0){
            for (Material material:materiales) {
                if (material instanceof Otros){
                    result.add(material.toString());
                }
            }
            if (result.size() == 0){
                result.add("No hay materiales de otros");
            }
        }
        else {
            result.add("No hay datos");
        }
        return result;
    }

    public Material buscarPorId(int signatura) {
        int size = materiales.size();
        if (size > 0){
            for (Material material:materiales) {
                if (material.getSignatura() == signatura){
                    return material;
                }
            }
        }
        return null;
    }
}
