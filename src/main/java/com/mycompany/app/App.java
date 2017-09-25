package com.mycompany.app;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;

  
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    public static boolean search(ArrayList<String> arr,ArrayList<String> arr2,ArrayList<Integer> arr3) {
		

		if(arr.size()==0 || arr2.size()==0 || arr3.size()==0)
		return false;
		if(arr == null || arr2 == null || arr3 == null)
		return false;
     		
		for(int e:arr3)
		{
		
		if(arr.get(e).equals(arr2.get(e)))
		  continue;
		else
		{
		   return false;
		}
		  
		}
		return true;

    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            inputList.add(value);
          }
          System.out.println(inputList);
	  
	  String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList2 = new java.util.ArrayList<>();
	  while (sc2.hasNext())
          {
            String value = sc2.next().replaceAll("\\s","");
            inputList2.add(value);
          }
          System.out.println(inputList2);
	  
	  String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList3 = new java.util.ArrayList<>();
	  while (sc3.hasNext())
          {
            int value =Integer.parseInt(sc3.next().replaceAll("\\s",""));
            inputList3.add(value);
          }
          System.out.println(inputList3);


         

          boolean result = App.search(inputList,inputList2,inputList3);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute", (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}




