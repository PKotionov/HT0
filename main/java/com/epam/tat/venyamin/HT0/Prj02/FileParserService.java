package com.epam.tat.venyamin.HT0.Prj02;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Kotionov_PV on 21.02.18.
 */
public interface FileParserService {
    Map<String, List<Track>> getArtistMap(List<File> mp3FileList);
}
