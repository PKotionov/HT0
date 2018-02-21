package com.epam.tat.venyamin.HT0.Prj02;

import java.io.File;
import java.util.List;

/**
 * Created by Kotionov_PV on 20.02.18.
 */
interface FileFinder {
    List<File> findFilesInDir(String path);
}
