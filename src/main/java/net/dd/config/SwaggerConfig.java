package net.dd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docketGroup1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }

    @Bean
    public Docket docketGroup2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }

    @Bean
    public Docket docketGroup3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    @Bean
    public Docket createRestApi(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("Api Doc")
                        .description("This is DD.net's Api doc")
                        .version("0.1").build())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
