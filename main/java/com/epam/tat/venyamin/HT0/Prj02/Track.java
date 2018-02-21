package com.epam.tat.venyamin.HT0.Prj02;


public class Track {

    private String artist, title, album, length, link;

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public String getLength() {
        return length;
    }

    public String getLink() {
        return link;
    }

    public Track(String artist, String title, String album, String length, String link) {
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.length = length;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Track{" +
                "artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", length='" + length + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
