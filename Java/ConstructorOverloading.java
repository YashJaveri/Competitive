import java.lang.Math;

class Volume {
    private double radius, l, b, h;

    public Volume(double _l, double _b, double _h) {
        this.l = _l;
        this.b = _b;
        this.h = _h;
    }

    public Volume(double _radius, double _h) {
        this.radius = _radius;
        this.h = _h;
    }

    public Volume(double _radius) {
        this.radius = _radius;
    }

    double getCuboidVolume() {
        return l * b * h;
    }

    double getCubeVolume() {
        return l * l * l;
    }

    double getSphereVolume() {
        return (4 * Math.PI * radius * radius * radius) / 3;
    }

    double getCylinderVolume() {
        return radius * Math.PI * radius * h;
    }
}