package com.view;

import com.domain.Blog;
import com.util.AbstractView;

import java.util.List;

public class MainView extends AbstractView {
    private List<Blog> bs;
    @Override
    public void setData(Object o) {
        bs = (List<Blog>) o;
    }

    @Override
    public void show() {
        TitleInfo.showTitle();
        if (bs != null) {
            for (Blog b: bs) {
                System.out.println(b.toString());
            }
        }

        System.out.println("1, enter the blog");
        System.out.println("2, write a blog");
        System.out.println("3, exit");

    }
}
