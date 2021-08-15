package com.ganesh.persistence.station;

import com.ganesh.pojos.Station;

import java.util.Collection;

public interface StationDaoInterface {
    Collection<Station> getAllStations();
    boolean isAStation(int stationId);
    String getStation(int stationId);
}
