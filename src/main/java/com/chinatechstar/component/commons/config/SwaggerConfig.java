package com.chinatechstar.component.commons.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API接口文档配置类
 * 
 * @版权所有 广东国星科技有限公司 www.mscodecloud.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * API的具体配置
	 * 
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameters = new ArrayList<Parameter>();
		parameterBuilder.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
		parameters.add(parameterBuilder.build());

		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build()
				.apiInfo(new ApiInfoBuilder().title("MSCode Swagger API").description("MSCode微服务平台接口文档").version("3.0.2").build())
				.useDefaultResponseMessages(false).securitySchemes(securitySchemes()).securityContexts(securityContexts())
				.globalOperationParameters(parameters);
	}

	private List<SecurityScheme> securitySchemes() {
		List<SecurityScheme> apiKeyList = new ArrayList<>();
		apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
		return apiKeyList;
	}

	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContexts = new ArrayList<>();
		securityContexts.add(SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("^(?!auth).*$")).build());
		return securityContexts;
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List<SecurityReference> securityReferences = new ArrayList<>();
		securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
		return securityReferences;
	}

}