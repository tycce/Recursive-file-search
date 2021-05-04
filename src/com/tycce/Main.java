package com.tycce;

public class Main {

    public static void main(String[] args) {
        SearchFiles files = new SearchFiles();
        files.Search("test");
	    if(files.writeToFile("result.txt")) System.out.println("Успешно");;
    }
}
