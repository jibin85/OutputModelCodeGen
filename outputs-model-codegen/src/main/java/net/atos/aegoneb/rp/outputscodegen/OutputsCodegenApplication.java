package net.atos.aegoneb.rp.outputscodegen;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import net.atos.aegoneb.rp.outputscodegen.service.CodegenService;

@SpringBootApplication
public class OutputsCodegenApplication{

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(OutputsCodegenApplication.class, args);
		CodegenService codegenService = appContext.getBean(CodegenService.class);
        try {
			codegenService.process();
		} catch (IOException e) {
			System.out.println("Exception in CodegenService process method");
			e.printStackTrace();
		}
	}

}
