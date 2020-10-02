package uz.devfest.app;

public class DevFest {
    private String title, description, image;
    private String time;
    private String startTime;
    private String complexity;
    private String language;
    private String presentation;
    private String videoId;
    private String speaker;
    private String date;
    private boolean expanded;

    private String name;
    private String shortBio;
    private String bio;
    private String photoUrl;
    private String company;
    private String country;
    private String twitter;
    private String linkedin;
    private String github;
    private String facebook;
    private String website;

    public DevFest(String startTime, String time, String title, String description, String image, String complexity,
                   String language, String presentation, String videoId, String speaker, String date,
                   String name, String shortBio, String bio, String photoUrl, String company, String country,
                   String twitter, String linkedin, String github, String facebook, String website) {
        this.startTime = startTime;
        this.time = time;
        this.title = title;
        this.description = description;
        this.image = image;
        this.complexity = complexity;
        this.language = language;
        this.presentation = presentation;
        this.videoId = videoId;
        this.speaker = speaker;
        this.date = date;
        this.expanded = false;

        this.name = name;
        this.shortBio = shortBio;
        this.bio = bio;
        this.photoUrl = photoUrl;
        this.company = company;
        this.country = country;
        this.twitter = twitter;
        this.linkedin = linkedin;
        this.github = github;
        this.facebook = facebook;
        this.website = website;
    }

    public DevFest() {
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getWebsite() {
        return website;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getGithub() {
        return github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getShortBio() {
        return shortBio;
    }

    public String getName() {
        return name;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getImage() {
        return image;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getTitle() {
        return title;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getDescription() {
        return description;
    }

    public String getComplexity() {
        return complexity;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
