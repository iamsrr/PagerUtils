package org.github.iamsrr.position;

/**
 * @Explain:
 * @Description:
 * @Author: 舒华体育-石红雨
 * @Date: 2020/5/3 10:07
 * @tip:
 */
public class Gps {

    private double wgLat;
    private double wgLon;

    public double getWgLat() {
        return wgLat;
    }

    public void setWgLat(double wgLat) {
        this.wgLat = wgLat;
    }

    public double getWgLon() {
        return wgLon;
    }

    public void setWgLon(double wgLon) {
        this.wgLon = wgLon;
    }

    public Gps() {
    }

    public Gps(double wgLat, double wgLon) {
        this.wgLat = wgLat;
        this.wgLon = wgLon;
    }
}
