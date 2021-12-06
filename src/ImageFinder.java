import java.awt.*;

public class ImageFinder {
    Image imag;
    String name;
    public ImageFinder(Image im, String k){
        imag=im;
        name=k;
    }
    public String getName(){
        return name;
    }
    public Image getImage(){
        return imag;
    }

}
