package com.gjj.gd.materialdesign_v7.toolbar;

public class MenuItem{
        boolean isSelected;
        String text;
        int icon;
        int iconSelected;
        public MenuItem(String text,boolean isSelected,int icon,int iconSelected){
            this.icon=icon;
            this.isSelected = isSelected;
            this.text = text;
            this.iconSelected = iconSelected;
        }
    }