package com.nask.naskrekrutacja.models;

import java.util.ArrayList;
import java.util.List;

public class DynamicPage
{
    private int count;
    private int pages;
    private List<People> elements;

    public DynamicPage()
    {
        this.elements=new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<People> getElements() {
        return elements;
    }

    public void setElements(List<People> elements) throws Exception
    {
        if(elements.size()>10) throw new Exception("Za duzo elementow");
        else this.elements = elements;
    }
    public void addElement(People element) throws Exception
    {
        if(this.elements.size()>=10) throw new Exception("Za duzo elementow");
        else this.elements.add(element);
    }
}
