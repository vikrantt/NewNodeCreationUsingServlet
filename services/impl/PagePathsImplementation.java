package com.mywebsite.core.services.impl;

import com.mywebsite.core.services.PagePaths;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = PagePaths.class)
@Designate(ocd = PagePathsConfiguration.class)
public class PagePathsImplementation implements PagePaths{
    private String p1;
    private String p2;

    @Activate
    public void Activate(PagePathsConfiguration config)
    {
        p1= config.success_path_page();
        p2= config.failed_path_page();
    }


    @Override
    public String path1() {
        return p1;
    }

    @Override
    public String path2() {
        return p2;
    }
}
