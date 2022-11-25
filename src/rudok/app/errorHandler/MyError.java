package rudok.app.errorHandler;

public class MyError extends Exception{

    String message;
    final private ErrorCode enumCode;

    public enum ErrorCode{
        DELETE_WORKSPACE,
        NO_PROJECT,
        SLIDE_NOT_SELECTED,
        PRESENTATION_NOT_SELECTED,
        NOTHING_SELECTED,
    }

/*
MyError preko enhanced switch postavlja poruku u yavisnosti od koda koji smo poslali meni je trebalo
da ne mogu da iybrisem workspace da nema projekat i ostali. Potrebno je dodati kodove u enumeraciju
i u switch u yavisnosti od projekta
 */
    protected  MyError(ErrorCode enumCode){
        switch (enumCode) {
            case DELETE_WORKSPACE -> this.message = "You can't delete Workspace";
            case NO_PROJECT -> this.message = "You must create project first";
            case SLIDE_NOT_SELECTED -> this.message = "Please select slide";
            case PRESENTATION_NOT_SELECTED -> this.message = "Please select presentation";
            case NOTHING_SELECTED -> this.message = "Please select something";
        }
        this.enumCode = enumCode;

    }


    public String getMessage(){
        return message;
    }

    public ErrorCode getEnumCode() {
        return enumCode;
    }


}
