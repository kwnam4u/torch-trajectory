package au.edu.rmit.trajectory.torch.mapMatching.model;

import au.edu.rmit.trajectory.torch.base.model.TrajEntry;
import com.github.davidmoten.geo.GeoHash;

/**
 * TorVertex class models a position on the graph.
 * Following Graph-hopper's naming convention, an vertex can be either an tower vertex or an pillar vertex.
 * Refer to TowerVertex and PillarVertex for more information.
 *
 * @see TowerVertex
 * @see PillarVertex
 */
public abstract class TorVertex implements TrajEntry {

    public final double lat;
    public final double lng;
    public final String hash;
    public final boolean isTower;

    public TorVertex(double lat, double lng, boolean isTower) {
        this.lat = lat;
        this.lng = lng;
        this.isTower = isTower;
        this.hash = GeoHash.encodeHash(lat, lng);
    }

    @Override
    public double getLat(){
        return lat;
    }

    @Override
    public double getLng(){
        return lng;
    }

    @Override
    public int getId(){return 0;};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return o.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lat);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "{" + lat + ", " + lng + '}';
    }
}
