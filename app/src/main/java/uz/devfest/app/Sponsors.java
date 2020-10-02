package uz.devfest.app;

public class Sponsors {
    private String nameSponsor;
    private String descriptionSponsor;
    private int imageSponsor;

    public static final Sponsors[] sponsors = {
            new Sponsors("GDG DevFest-2020", "Giga Sponsor", R.drawable.devfest2020),
            new Sponsors("Google", "Mega Sponsor", R.drawable.googles)
    };

    public Sponsors() {
    }

    public Sponsors(String nameSponsor, String descriptionSponsor, int imageSponsor) {
        this.imageSponsor = imageSponsor;
        this.nameSponsor = nameSponsor;
        this.descriptionSponsor = descriptionSponsor;
    }

    public String getDescriptionSponsor() {
        return descriptionSponsor;
    }

    public int getImageSponsor() {
        return imageSponsor;
    }

    public String getNameSponsor() {
        return nameSponsor;
    }
}
