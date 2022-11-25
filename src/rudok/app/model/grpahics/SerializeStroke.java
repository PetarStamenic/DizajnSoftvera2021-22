package rudok.app.model.grpahics;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeStroke implements Stroke, Serializable {

    Stroke stroke;

    /*
    ovo samo kopiraj
     */
    public SerializeStroke(Stroke stroke){
        this.stroke = stroke;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException{
        if(stroke instanceof BasicStroke){
            BasicStroke basicStroke = (BasicStroke) stroke;
            objectOutputStream.writeFloat(basicStroke.getLineWidth());
            objectOutputStream.writeInt((basicStroke.getEndCap()));
            objectOutputStream.writeInt(basicStroke.getLineJoin());
            objectOutputStream.writeFloat(basicStroke.getMiterLimit());
            objectOutputStream.writeObject(basicStroke.getDashArray());
            objectOutputStream.writeFloat(basicStroke.getDashPhase());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException , ClassNotFoundException{
        stroke = new BasicStroke(objectInputStream.readFloat(),
                                objectInputStream.readInt(),
                                objectInputStream.readInt(),
                                objectInputStream.readFloat(),
                                (float[]) objectInputStream.readObject(),
                                objectInputStream.readFloat());
    }

    @Override
    public Shape createStrokedShape(Shape p) {
        return stroke.createStrokedShape(p);
    }
}
