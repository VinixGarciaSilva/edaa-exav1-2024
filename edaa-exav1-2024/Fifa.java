import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fifa {
    private String country;
    private String confederation;
    private Double populationShare;
    private Double tvAudienceShare;
    private Double gdpWeightedShare;

    private List<Fifa> fifa = new ArrayList<>();

    public Fifa() {

    }

    public Fifa(String country, String confederation, Double populationShare, Double tvAudienceShare,
            Double gdpWeightedShare) {
        this.country = country;
        this.confederation = confederation;
        this.populationShare = populationShare;
        this.tvAudienceShare = tvAudienceShare;
        this.gdpWeightedShare = gdpWeightedShare;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public Double getPopulationShare() {
        return populationShare;
    }

    public void setPopulationShare(Double populationShare) {
        this.populationShare = populationShare;
    }

    public Double getTvAudienceShare() {
        return tvAudienceShare;
    }

    public void setTvAudienceShare(Double tvAudienceShare) {
        this.tvAudienceShare = tvAudienceShare;
    }

    public Double getGdpWeightedShare() {
        return gdpWeightedShare;
    }

    public void setGdpWeightedShare(Double gdpWeightedShare) {
        this.gdpWeightedShare = gdpWeightedShare;
    }

    public List<Fifa> getFifa() {
        return fifa;
    }

    public static void file(List<Fifa> fifa) {
        try {
            File file = new File(
                    "C:\\Users\\Vinix\\Desktop\\LISTAULIFE\\LAV1/fifa_countries_audience.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] dados = line.split(",");
                String county = dados[0];
                String conf = dados[1];
                double pop = Double.parseDouble(dados[2]);
                double tv = Double.parseDouble(dados[3]);
                double gdp = Double.parseDouble(dados[4]);

                fifa.add(new Fifa(county, conf, pop, tv, gdp));
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return country + ", " + confederation + ", " + populationShare
                + ", " + tvAudienceShare + ", " + gdpWeightedShare;
    }

    public static void sortCountryes(List<Fifa> list) {
        file(list);
        Collections.sort(list, (countyOne, countryTwo) -> countyOne.getCountry().compareTo(countryTwo.getCountry()));
        list(list);
    }

    public static void sortAudience(List<Fifa> list) {
        file(list);
        Collections.sort(list, (AudienceOne, AudienceTwo) -> AudienceTwo.getTvAudienceShare()
                .compareTo(AudienceOne.getTvAudienceShare()));
        list(list);
    }

    public static void list(List<Fifa> list) {
        for (Fifa f : list) {
            System.out.println(f);
        }
    }
}