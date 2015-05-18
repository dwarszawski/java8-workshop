package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Podregion {

    private String nazwa;
    private Double iloscZarejestrowanych;
    private Double stopaBezrobocia;
    private Wojewodztwo wojewodztwo;

    public String getNazwa() {
        return nazwa;
    }

    public Double getIloscZarejestrowanych() {
        return iloscZarejestrowanych;
    }

    public Double getStopaBezrobocia() {
        return stopaBezrobocia;
    }

    public Wojewodztwo getWojewodztwo() {
        return wojewodztwo;
    }

    public Podregion(String nazwa, Double iloscZarejestrowanych, Double stopaBezrobocia, Wojewodztwo wojewodztwo) {
        this.nazwa = nazwa;
        this.iloscZarejestrowanych = iloscZarejestrowanych;
        this.stopaBezrobocia = stopaBezrobocia;
        this.wojewodztwo = wojewodztwo;
    }

    public enum Wojewodztwo {
        DOLNO_ŚLĄSKIE,
        KUJAWSKO_POMORSKIE,
        LUBELSKIE,
        LUBUSKIE,
        ŁÓDZKIE,
        MALOPOLSKIE,
        MAZOWIECKIE,
        OPOLSKIE,
        PODKARPACKIE,
        PODLASKIE,
        POMORSKIE,
        ŚLĄSKIE,
        ŚWIĘTOKRZYSKIE,
        WARMIŃSKO_MAZURSKIE,
        WIELKOPOLSKIE,
        ZACHODNIO_POMORSKIE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, iloscZarejestrowanych, stopaBezrobocia, wojewodztwo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Podregion) {
            Podregion other = (Podregion) obj;
            return Objects.equals(nazwa, other.nazwa)
                    && Objects.equals(iloscZarejestrowanych, other.iloscZarejestrowanych)
                    && Objects.equals(stopaBezrobocia, other.stopaBezrobocia)
                    && Objects.equals(wojewodztwo, other.wojewodztwo);
        }

        return false;
    }

    @Override
    public String toString() {
        return nazwa + " " + wojewodztwo + " (" + iloscZarejestrowanych + ") [" + stopaBezrobocia + "]";
    }

    public static class RegionRepository {
        public static List<Podregion> bezrobocie2014() {
            return new ArrayList<Podregion>(Arrays.asList(
                    new Podregion("jeleniogórski", 27.6, 14.3, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Podregion("legnicko-głogowski", 20.1, 11.1, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Podregion("wałbrzyski", 37.5, 17.0, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Podregion("wrocławski", 22.1, 10.2, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Podregion("m. Wrocław", 14.3, 4.3, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Podregion("bydgosko-toruński", 30.4, 9.4, Wojewodztwo.KUJAWSKO_POMORSKIE),
                    new Podregion("grudziądzki", 34.8, 18.0, Wojewodztwo.KUJAWSKO_POMORSKIE),
                    new Podregion("włocławski", 61.9, 21.3, Wojewodztwo.KUJAWSKO_POMORSKIE),
                    new Podregion("bialski", 19.0, 15.4, Wojewodztwo.LUBELSKIE),
                    new Podregion("chełmsko-zamojski", 38.8, 14.4, Wojewodztwo.LUBELSKIE),
                    new Podregion("lubelski", 32.9, 10.4, Wojewodztwo.LUBELSKIE),
                    new Podregion("puławski", 26.2, 12.4, Wojewodztwo.LUBELSKIE),
                    new Podregion("gorzowski", 15.9, 11.0, Wojewodztwo.LUBUSKIE),
                    new Podregion("zielonogórski", 31.2, 13.9, Wojewodztwo.LUBUSKIE),
                    new Podregion("łódzki", 19.4, 13.7, Wojewodztwo.ŁÓDZKIE),
                    new Podregion("m. Łódź", 36.5, 10.8, Wojewodztwo.ŁÓDZKIE),
                    new Podregion("piotrkowski", 29.7, 12.4, Wojewodztwo.ŁÓDZKIE),
                    new Podregion("sieradzki", 23.3, 12.5, Wojewodztwo.ŁÓDZKIE),
                    new Podregion("skierniewicki", 17.3, 11.5, Wojewodztwo.ŁÓDZKIE),
                    new Podregion("krakowski", 24.5, 9.5, Wojewodztwo.MALOPOLSKIE),
                    new Podregion("m. Kraków", 21.9, 5.2, Wojewodztwo.MALOPOLSKIE),
                    new Podregion("nowosądecki", 41.9, 13.4, Wojewodztwo.MALOPOLSKIE),
                    new Podregion("oświęcimski", 27.6, 12.1, Wojewodztwo.MALOPOLSKIE),
                    new Podregion("tarnowski", 23.1, 12.5, Wojewodztwo.MALOPOLSKIE),
                    new Podregion("ciechanowsko-płocki", 41.6, 16.5, Wojewodztwo.MAZOWIECKIE),
                    new Podregion("ostrołęcko-siedlecki", 43.5, 14.2, Wojewodztwo.MAZOWIECKIE),
                    new Podregion("radomski", 55.2, 22.1, Wojewodztwo.MAZOWIECKIE),
                    new Podregion("m.st. Warszawa", 48.8, 4.3, Wojewodztwo.MAZOWIECKIE),
                    new Podregion("warszawski-wschodni", 34.6, 12.9, Wojewodztwo.MAZOWIECKIE),
                    new Podregion("warszawski-zachodni", 26.0, 8.0, Wojewodztwo.MAZOWIECKIE),
                    new Podregion("nyski", 20.5, 16.5, Wojewodztwo.OPOLSKIE),
                    new Podregion("opolski", 21.9, 9.5, Wojewodztwo.OPOLSKIE),
                    new Podregion("krośnieński", 33.1, 15.4, Wojewodztwo.PODKARPACKIE),
                    new Podregion("przemyski", 29.3, 17.3, Wojewodztwo.PODKARPACKIE),
                    new Podregion("rzeszowski", 38.9, 13.4, Wojewodztwo.PODKARPACKIE),
                    new Podregion("tarnobrzeski", 36.7, 14.1, Wojewodztwo.PODKARPACKIE),
                    new Podregion("białostocki", 26.8, 13.5, Wojewodztwo.PODLASKIE),
                    new Podregion("łomżyński", 19.3, 12.1, Wojewodztwo.PODLASKIE),
                    new Podregion("suwalski", 14.3, 13.8, Wojewodztwo.PODLASKIE),
                    new Podregion("gdański", 21.7, 12.6, Wojewodztwo.POMORSKIE),
                    new Podregion("słupski", 31.2, 17.4, Wojewodztwo.POMORSKIE),
                    new Podregion("starogardzki", 25.0, 15.0, Wojewodztwo.POMORSKIE),
                    new Podregion("trójmiejski", 18.8, 5.6, Wojewodztwo.POMORSKIE),
                    new Podregion("bielski", 23.3, 8.5, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("bytomski", 21.0, 14.3, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("częstochowski", 28.6, 13.6, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("gliwicki", 17.5, 8.9, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("katowicki", 24.9, 6.9, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("rybnicki", 19.4, 9.0, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("sosnowiecki", 31.3, 12.6, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("tyski", 9.6, 5.6, Wojewodztwo.ŚLĄSKIE),
                    new Podregion("kielecki", 48.6, 15.6, Wojewodztwo.ŚWIĘTOKRZYSKIE),
                    new Podregion("sandomiersko-jędrzejowski", 26.9, 12.3, Wojewodztwo.ŚWIĘTOKRZYSKIE),
                    new Podregion("elbląski", 35.4, 18.8, Wojewodztwo.WARMIŃSKO_MAZURSKIE),
                    new Podregion("ełcki", 22.4, 23.0, Wojewodztwo.WARMIŃSKO_MAZURSKIE),
                    new Podregion("olsztyński", 40.4, 17.2, Wojewodztwo.WARMIŃSKO_MAZURSKIE),
                    new Podregion("kaliski", 21.7, 7.9, Wojewodztwo.WIELKOPOLSKIE),
                    new Podregion("koniński", 33.9, 13.4, Wojewodztwo.WIELKOPOLSKIE),
                    new Podregion("leszczyński", 16.4, 7.3, Wojewodztwo.WIELKOPOLSKIE),
                    new Podregion("pilski", 19.5, 12.8, Wojewodztwo.WIELKOPOLSKIE),
                    new Podregion("poznański", 14.6, 5.6, Wojewodztwo.WIELKOPOLSKIE),
                    new Podregion("m. Poznań", 10.4, 3.2, Wojewodztwo.WIELKOPOLSKIE),
                    new Podregion("koszaliński", 39.6, 18.9, Wojewodztwo.ZACHODNIO_POMORSKIE),
                    new Podregion("stargardzki", 23.6, 20.6, Wojewodztwo.ZACHODNIO_POMORSKIE),
                    new Podregion("m. Szczecin", 16.2, 9.4, Wojewodztwo.ZACHODNIO_POMORSKIE),
                    new Podregion("szczeciński", 15.0, 13.9, Wojewodztwo.ZACHODNIO_POMORSKIE)
            ));
        }
    }
}
