package com.mywebsite.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Page Paths Configuration")
public @interface PagePathsConfiguration {
    @AttributeDefinition(
            name = "successPathPage",
            description = "Enter the path for success page",
            type = AttributeType.STRING
    )
    String success_path_page();

    @AttributeDefinition(
            name = "failedPathPage",
            description = "Enter the path for failed page",
            type = AttributeType.STRING
    )
    String failed_path_page();
}
