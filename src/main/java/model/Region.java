package model;

import java.util.*;

public class Region {

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

    public Region(String nazwa, Double iloscZarejestrowanych, Double stopaBezrobocia, Wojewodztwo wojewodztwo) {
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

    public static Comparator<Region> comparator = (o1, o2) -> {
        if (o1.getWojewodztwo() == o2.getWojewodztwo())
            return 0;
        return o1.getIloscZarejestrowanych() < o2.getIloscZarejestrowanych() ? -1 : 1;
    };

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, iloscZarejestrowanych, stopaBezrobocia, wojewodztwo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Region) {
            Region other = (Region) obj;
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
        public static List<Region> bezrobocie2014() {
            return new ArrayList<Region>(Arrays.asList(
                    new Region("jeleniogórski", 27.6, 14.3, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Region("legnicko-głogowski", 20.1, 11.1, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Region("wałbrzyski", 37.5, 17.0, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Region("wrocławski", 22.1, 10.2, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Region("m. Wrocław", 14.3, 4.3, Wojewodztwo.DOLNO_ŚLĄSKIE),
                    new Region("bydgosko-toruński", 30.4, 9.4, Wojewodztwo.KUJAWSKO_POMORSKIE),
                    new Region("grudziądzki", 34.8, 18.0, Wojewodztwo.KUJAWSKO_POMORSKIE),
                    new Region("włocławski", 61.9, 21.3, Wojewodztwo.KUJAWSKO_POMORSKIE),
                    new Region("bialski", 19.0, 15.4, Wojewodztwo.LUBELSKIE),
                    new Region("chełmsko-zamojski", 38.8, 14.4, Wojewodztwo.LUBELSKIE),
                    new Region("lubelski", 32.9, 10.4, Wojewodztwo.LUBELSKIE),
                    new Region("puławski", 26.2, 12.4, Wojewodztwo.LUBELSKIE),
                    new Region("gorzowski", 15.9, 11.0, Wojewodztwo.LUBUSKIE),
                    new Region("zielonogórski", 31.2, 13.9, Wojewodztwo.LUBUSKIE),
                    new Region("łódzki", 19.4, 13.7, Wojewodztwo.ŁÓDZKIE),
                    new Region("m. Łódź", 36.5, 10.8, Wojewodztwo.ŁÓDZKIE),
                    new Region("piotrkowski", 29.7, 12.4, Wojewodztwo.ŁÓDZKIE),
                    new Region("sieradzki", 23.3, 12.5, Wojewodztwo.ŁÓDZKIE),
                    new Region("skierniewicki", 17.3, 11.5, Wojewodztwo.ŁÓDZKIE),
                    new Region("krakowski", 24.5, 9.5, Wojewodztwo.MALOPOLSKIE),
                    new Region("m. Kraków", 21.9, 5.2, Wojewodztwo.MALOPOLSKIE),
                    new Region("nowosądecki", 41.9, 13.4, Wojewodztwo.MALOPOLSKIE),
                    new Region("oświęcimski", 27.6, 12.1, Wojewodztwo.MALOPOLSKIE),
                    new Region("tarnowski", 23.1, 12.5, Wojewodztwo.MALOPOLSKIE),
                    new Region("ciechanowsko-płocki", 41.6, 16.5, Wojewodztwo.MAZOWIECKIE),
                    new Region("ostrołęcko-siedlecki", 43.5, 14.2, Wojewodztwo.MAZOWIECKIE),
                    new Region("radomski", 55.2, 22.1, Wojewodztwo.MAZOWIECKIE),
                    new Region("m.st. Warszawa", 48.8, 4.3, Wojewodztwo.MAZOWIECKIE),
                    new Region("warszawski-wschodni", 34.6, 12.9, Wojewodztwo.MAZOWIECKIE),
                    new Region("warszawski-zachodni", 26.0, 8.0, Wojewodztwo.MAZOWIECKIE),
                    new Region("nyski", 20.5, 16.5, Wojewodztwo.OPOLSKIE),
                    new Region("opolski", 21.9, 9.5, Wojewodztwo.OPOLSKIE),
                    new Region("krośnieński", 33.1, 15.4, Wojewodztwo.PODKARPACKIE),
                    new Region("przemyski", 29.3, 17.3, Wojewodztwo.PODKARPACKIE),
                    new Region("rzeszowski", 38.9, 13.4, Wojewodztwo.PODKARPACKIE),
                    new Region("tarnobrzeski", 36.7, 14.1, Wojewodztwo.PODKARPACKIE),
                    new Region("białostocki", 26.8, 13.5, Wojewodztwo.PODLASKIE),
                    new Region("łomżyński", 19.3, 12.1, Wojewodztwo.PODLASKIE),
                    new Region("suwalski", 14.3, 13.8, Wojewodztwo.PODLASKIE),
                    new Region("gdański", 21.7, 12.6, Wojewodztwo.POMORSKIE),
                    new Region("słupski", 31.2, 17.4, Wojewodztwo.POMORSKIE),
                    new Region("starogardzki", 25.0, 15.0, Wojewodztwo.POMORSKIE),
                    new Region("trójmiejski", 18.8, 5.6, Wojewodztwo.POMORSKIE),
                    new Region("bielski", 23.3, 8.5, Wojewodztwo.ŚLĄSKIE),
                    new Region("bytomski", 21.0, 14.3, Wojewodztwo.ŚLĄSKIE),
                    new Region("częstochowski", 28.6, 13.6, Wojewodztwo.ŚLĄSKIE),
                    new Region("gliwicki", 17.5, 8.9, Wojewodztwo.ŚLĄSKIE),
                    new Region("katowicki", 24.9, 6.9, Wojewodztwo.ŚLĄSKIE),
                    new Region("rybnicki", 19.4, 9.0, Wojewodztwo.ŚLĄSKIE),
                    new Region("sosnowiecki", 31.3, 12.6, Wojewodztwo.ŚLĄSKIE),
                    new Region("tyski", 9.6, 5.6, Wojewodztwo.ŚLĄSKIE),
                    new Region("kielecki", 48.6, 15.6, Wojewodztwo.ŚWIĘTOKRZYSKIE),
                    new Region("sandomiersko-jędrzejowski", 26.9, 12.3, Wojewodztwo.ŚWIĘTOKRZYSKIE),
                    new Region("elbląski", 35.4, 18.8, Wojewodztwo.WARMIŃSKO_MAZURSKIE),
                    new Region("ełcki", 22.4, 23.0, Wojewodztwo.WARMIŃSKO_MAZURSKIE),
                    new Region("olsztyński", 40.4, 17.2, Wojewodztwo.WARMIŃSKO_MAZURSKIE),
                    new Region("kaliski", 21.7, 7.9, Wojewodztwo.WIELKOPOLSKIE),
                    new Region("koniński", 33.9, 13.4, Wojewodztwo.WIELKOPOLSKIE),
                    new Region("leszczyński", 16.4, 7.3, Wojewodztwo.WIELKOPOLSKIE),
                    new Region("pilski", 19.5, 12.8, Wojewodztwo.WIELKOPOLSKIE),
                    new Region("poznański", 14.6, 5.6, Wojewodztwo.WIELKOPOLSKIE),
                    new Region("m. Poznań", 10.4, 3.2, Wojewodztwo.WIELKOPOLSKIE),
                    new Region("koszaliński", 39.6, 18.9, Wojewodztwo.ZACHODNIO_POMORSKIE),
                    new Region("stargardzki", 23.6, 20.6, Wojewodztwo.ZACHODNIO_POMORSKIE),
                    new Region("m. Szczecin", 16.2, 9.4, Wojewodztwo.ZACHODNIO_POMORSKIE),
                    new Region("szczeciński", 15.0, 13.9, Wojewodztwo.ZACHODNIO_POMORSKIE)
            ));
        }
    }
}
