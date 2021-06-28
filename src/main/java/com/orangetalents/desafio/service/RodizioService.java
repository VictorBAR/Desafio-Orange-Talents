package com.orangetalents.desafio.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class RodizioService {

    public boolean diaPermitido(String ano){
        return diaRodizio(ano) == diaSemanaHoje();
    }

    private int diaSemanaHoje() {
        GregorianCalendar gc = new GregorianCalendar();
        return  gc.get(Calendar.DAY_OF_WEEK);
    }

    public int diaRodizio(String ano) {
        String anoString = ano.substring(3);
        switch (anoString) {
            case "0":
            case "1":
                return Calendar.MONDAY;
            case "2":
            case "3":
                return Calendar.TUESDAY;
            case "4":
            case "5":
                return Calendar.WEDNESDAY;
            case "6":
            case "7":
                return Calendar.THURSDAY;
            case "8":
            case "9":
                return Calendar.FRIDAY;
        }
        return 0;
    }

    public String diaSemana(String ano) {
        String anoString = ano.substring(3);
        switch (anoString) {
            case "0":
            case "1":
                return "Segunda-Feira";
            case "2":
            case "3":
                return "Terça-Feira";
            case "4":
            case "5":
                return "Quarta-Feira";
            case "6":
            case "7":
                return "Quinta-Feira";
            case "8":
            case "9":
                return "Sexta-Feira";
        }
        return "";
    }
}
