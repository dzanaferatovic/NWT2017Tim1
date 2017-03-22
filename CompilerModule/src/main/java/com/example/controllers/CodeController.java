package com.example.controllers;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datamodels.CodeClass;
import com.example.datamodels.ResultClass;

@RestController
@RequestMapping("compiler")
public class CodeController {
	
	@RequestMapping("run")
	public ResultClass runCode(@RequestBody CodeClass code){
		System.out.println(code.code);
		System.out.println(code.username);
		ResultClass result=new ResultClass("working", "/");
		Runtime r=Runtime.getRuntime();
		ProcessBuilder pb=new ProcessBuilder("printf",code.code).redirectOutput(new File("prog.cpp"));
		try {
			Process p = r.exec("rm prog.cpp");
			p.waitFor();
			pb.start().waitFor();
			pb=new ProcessBuilder("g++","-o","prog","prog.cpp");
			pb.start().waitFor();/*
			p=r.exec("g++ -o prog.cpp");
			p.waitFor();*/
			p=r.exec("./prog");
			InputStream is = p.getInputStream();
			Scanner s= new Scanner(is).useDelimiter("\\A");
			String output=s.hasNext() ? s.next(): "nema";
			System.out.println(output);
			result.result=output;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.status="not working";
		}
		return result;
	}
}
