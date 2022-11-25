package rudok.app.gui.swing.controller.state.slideshow;

public class SlideStateManager {


    /*
    menadzer klasa koja u zavisnosti od selektovanog state postavlje trenutni state
     */
    private SlideState CurrState;
    private EditSlideState editSlideState;
    private SlideShowState slideShowState;

    public SlideStateManager(){
        init();
    }

    private void init(){
        editSlideState = new EditSlideState();
        slideShowState = new SlideShowState();
    }

    public SlideState getCurrState() {
        return CurrState;
    }

    public void setEditSlideState() {
        CurrState = editSlideState;
    }

    public void setSlideShowState() {
        CurrState = slideShowState;
    }

}
