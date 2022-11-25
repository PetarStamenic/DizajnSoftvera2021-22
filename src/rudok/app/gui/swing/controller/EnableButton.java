package rudok.app.gui.swing.controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.List;

public class EnableButton implements DocumentListener {


    /*
    Potpuno nebitna klasa ukoliko ne zelis da radins neke gluposti kao ja
    namenjana je da disabluje dugme ukoliko nisu sva polja popunjena tako da prilikom preiranja
    u JDialogu ne moze da se desi da neko potvrdi kreiranje a da nije sve popunio
     */
    private ButtonModel buttonModel;
    private List<Document> documentList = new ArrayList<>();

    public EnableButton(ButtonModel buttonModel){
        this.buttonModel = buttonModel;
    }

    public void addText(Document document){
        document.addDocumentListener(this);
        documentList.add(document);
        documentExists();
    }

    public void documentExists(){
        boolean buttonEnable = false;
        if(documentList.get(0).getLength()>0 && documentList.get(1).getLength()>0 && documentList.get(2).getLength()>0 && documentList.get(3).getLength()>0)
                buttonEnable = true;
        buttonModel.setEnabled(buttonEnable);

    }




    @Override
    public void insertUpdate(DocumentEvent e) {
        documentExists();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentExists();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentExists();
    }
}
