package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import static ui.MapMarkerSimple.defaultMarkerSize;

public class MapMarkerNew extends MapMarkerCircle
{

    public MapMarkerNew(Layer layer , Coordinate coordinate)
    {
        super(layer, null, coordinate, defaultMarkerSize, STYLE.VARIABLE, getDefaultStyle());

    }
}
