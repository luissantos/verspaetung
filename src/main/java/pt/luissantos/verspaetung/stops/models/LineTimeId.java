package pt.luissantos.verspaetung.stops.models;

import java.io.Serializable;
import java.util.Objects;

public class LineTimeId implements Serializable {
    private Integer lineId;
    private Integer stopId;

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineTimeId that = (LineTimeId) o;
        return Objects.equals(lineId, that.lineId) &&
                Objects.equals(stopId, that.stopId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineId, stopId);
    }
}
