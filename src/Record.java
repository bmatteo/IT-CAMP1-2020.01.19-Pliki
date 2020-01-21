import static java.lang.Double.NaN;

public class Record {
    private String tekst;
    private int liczba;
    private Boolean logika;
    private double zmiennoprzecinkowa;
    private int drugaliczba;

    public Record(String line) {
        String[] values = line.split(",");
        this.tekst = values[0];
        try {
            this.liczba = Integer.parseInt(values[1]);
        } catch (NumberFormatException e) {
            this.liczba = 1;
        }

        if(values[2].toUpperCase().equals("TRUE")) {
            this.logika = true;
        } else if(values[2].toUpperCase().equals("FALSE")) {
            this.logika = false;
        } else {
            this.logika = null;
        }


        try {
            this.zmiennoprzecinkowa = Double.parseDouble(values[3]);
        } catch (NumberFormatException e) {
            this.zmiennoprzecinkowa = NaN;
        }

        this.drugaliczba = Integer.parseInt(values[4]);
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getLiczba() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba = liczba;
    }

    public boolean isLogika() {
        return logika;
    }

    public void setLogika(boolean logika) {
        this.logika = logika;
    }

    public double getZmiennoprzecinkowa() {
        return zmiennoprzecinkowa;
    }

    public void setZmiennoprzecinkowa(double zmiennoprzecinkowa) {
        this.zmiennoprzecinkowa = zmiennoprzecinkowa;
    }

    public int getDrugaliczba() {
        return drugaliczba;
    }

    public void setDrugaliczba(int drugaliczba) {
        this.drugaliczba = drugaliczba;
    }

    @Override
    public String toString() {
        return "Record{" +
                "tekst='" + tekst + '\'' +
                ", liczba=" + liczba +
                ", logika=" + logika +
                ", zmiennoprzecinkowa=" + zmiennoprzecinkowa +
                ", drugaliczba=" + drugaliczba +
                '}';
    }

    public String fileToString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.tekst)
                .append(",")
                .append(this.liczba)
                .append(",")
                .append(this.logika)
                .append(",")
                .append(this.zmiennoprzecinkowa)
                .append(",")
                .append(this.drugaliczba)
                .append("\n");

        return sb.toString();
    }
}
