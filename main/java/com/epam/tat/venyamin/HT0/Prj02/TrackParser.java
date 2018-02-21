package com.epam.tat.venyamin.HT0.Prj02;

import java.io.File;

public interface TrackParser {
    String getArtist(File file);
    String getAlbum(File file);
    String getTitle(File file);
    String getTrackLength(File file);
}
