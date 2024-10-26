package org.lld.model;

import lombok.Data;

@Data
public class Shelf {

    private Item item;
    private int shelfCode;
    private boolean isEmpty;

    public Shelf(){
        isEmpty = true;
    }

    public void addItem(Item item){
        this.item = item;
        this.isEmpty = false;
    }

    public void setShelfEmpty(){
        this.isEmpty = true;
    }

}
