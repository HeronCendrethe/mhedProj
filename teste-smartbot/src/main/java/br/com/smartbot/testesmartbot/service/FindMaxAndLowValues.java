package br.com.smartbot.testesmartbot.service;

import java.util.List;

public class FindMaxAndLowValues {

    public Float findHighValue(List<Float> listValues){
        float aux = 0;
        for (int i = 0; i < listValues.size(); i ++){
            if (listValues.get(i) > aux){
                aux = listValues.get(i);
            }
        }

        return aux;
    }

    public Float findLowValue(List<Float> listValues){
        float aux = 0;
        for (int i = 0; i < listValues.size(); i ++){
            if (listValues.get(i) < aux){
                aux = listValues.get(i);
            }
        }

        return aux;
    }



}

