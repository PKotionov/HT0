package com.epam.tat.venyamin.HT0.Prj02;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TrackService {
   public static List<Track> getAllTracksFromMap(Map<String, List<Track>> trackMap){
       List<Track> trakList = new ArrayList<>();
       Set<String> albums = trackMap.keySet();
       for (String album : albums) {
           trakList.addAll(trackMap.get(album));
       }
       return trakList;
   }
}
