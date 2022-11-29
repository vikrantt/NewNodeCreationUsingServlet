package com.mywebsite.core.models;

import com.mywebsite.core.services.PagePaths;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import javax.inject.Inject;

@Model(adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PagePathsModel {
    @OSGiService
    PagePaths paths;

    String path1;
    String path2;

    public String getPath1() {
        return paths.path1();
    }

    public String getPath2() {
        return paths.path2();
    }
}
